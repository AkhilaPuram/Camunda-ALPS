package com.aaseya.alps.service;
 
import java.util.HashMap;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.aaseya.alps.dto.StartALPSRequestDTO;
import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
 
@Service
 
public class ALPSService {
 
	@Autowired
	private ZeebeClient zeebeClient;
 
	public String startALPSProcess(StartALPSRequestDTO startALPSRequestDTO) {
 
		String businessKey = "";
		Map<String, Object> map = new HashMap<>();
 
		map.put("applicantId", startALPSRequestDTO.getApplicantId());
		map.put("category", startALPSRequestDTO.getCategory());
		map.put("subcategory", startALPSRequestDTO.getSubcategory());
		map.put("subsubcategory", startALPSRequestDTO.getSubsubcategory());
		map.put("status", "new");
		map.put("createdBy", startALPSRequestDTO.getCreatedBy());
 
		ProcessInstanceEvent processInstanceEvent = zeebeClient.newCreateInstanceCommand().bpmnProcessId("ALPSProcess")
				.latestVersion().variables(map).send().join();
		System.out.println(processInstanceEvent.getProcessInstanceKey());
		businessKey = "ALPS" + processInstanceEvent.getProcessInstanceKey();
		map.put("ALPSBusinessKey", businessKey);
		zeebeClient.newSetVariablesCommand(processInstanceEvent.getProcessInstanceKey()).variables(map).send().join();
		return businessKey;
 
	}
 
	
}
