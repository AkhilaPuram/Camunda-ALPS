package com.aaseya.alps.zeebe.worker;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.ZeebeClient;

@Component
public class StartReview {

	@Autowired
	private ZeebeClient zeebeClient;

	/*
	 * @JobWorker(type = "start-review") public Map<String, Object>
	 * startReview(final ActivatedJob job) { Map<String, Object> map =
	 * job.getVariablesAsMap(); String businessKey =
	 * map.get("AISBusinessKey").toString();
	 * zeebeClient.newPublishMessageCommand().messageName("StartReviewMessage").
	 * correlationKey(businessKey).send().join(); return map; }
	 */

}
