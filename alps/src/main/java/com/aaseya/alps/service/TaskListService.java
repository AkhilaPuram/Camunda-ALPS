package com.aaseya.alps.service;


	 
	import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.aaseya.alps.OMSConstants;

import com.aaseya.alps.dto.AccessToken;
import com.aaseya.alps.dto.TaskVariables;
import com.fasterxml.jackson.databind.ObjectMapper;
	 
	@Service
	public class TaskListService{
	 
	  Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	//  @Value("camunda.client.id")
	//  private String clientId;
	//  
	//  @Value("camunda.client.id")
	//  private String clientSecret;
	//  
	//  @Value("camunda.grant.type")
	//  private String grantType;
	//  
	//  @Value("camunda.keycloak.id")
	//  private String keycloakId;
	//  
	//  @Value("camunda.keycloak.url")
	//  private String keycloakUrl;
	  
	  
	 
	  public String getTasklistToken() {
	    String token = "";
	 
	    RestTemplate restTemplate = new RestTemplate();
	    try {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	      MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	      map.add("client_secret", OMSConstants.CLIENT_SECRET);
	      map.add("client_id", OMSConstants.CLIENT_ID);
	      map.add("grant_type", OMSConstants.GRANT_TYPE);
	      HttpEntity<MultiValueMap<String, String>> request =
	          new HttpEntity<MultiValueMap<String, String>>(map, headers);
	 
	      ResponseEntity<AccessToken> response =
	          restTemplate.exchange(
	              OMSConstants.TOKEN_URL, HttpMethod.POST, request, AccessToken.class);
	 
	      token = response.getBody().getAccess_token();
	      System.out.println("token: " + token);
	    } catch (Exception eek) {
	      logger.info("** Exception: " + eek.getMessage());
	    }
	 
	    return token;
	  }
	 
	  public String getActiveTaskID(String ProcessID) {
	    String TaskID = "";
	    RestTemplate restTemplate = new RestTemplate();
	    try {
	 
	      HttpComponentsClientHttpRequestFactory requestFactory =
	          new HttpComponentsClientHttpRequestFactory();
	      requestFactory.setConnectTimeout(0);
	      //requestFactory.setReadTimeout(0);
	      restTemplate.setRequestFactory(requestFactory);
	      HttpHeaders headers = new HttpHeaders();
	      headers.setContentType(MediaType.APPLICATION_JSON);
	      String AuthToken = "Bearer " + getTasklistToken();
	      headers.add("Authorization", AuthToken);
	      System.out.println("processId"+ ProcessID);
	      String requestJson =
	          "{\"taskState\":\"CREATED\",\"processInstanceKey\":\"" + ProcessID + "\"}";
	      HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
	 
	      ResponseEntity<TaskVariables[]> resEntity =
	          restTemplate.exchange(
	              OMSConstants.TASKS_SEARCH_URL, HttpMethod.POST, entity, TaskVariables[].class);
	      System.out.println("resEntity"+ resEntity);
	      TaskVariables[] task = resEntity.getBody();
	      for (int i = 0; i < task.length; i++) {
	        if (task[i].getProcessInstanceKey().equals(ProcessID)
	            && task[i].getTaskState().equals("CREATED")) {
	        	System.out.println(" Match found at " + i + task[i].getName());
	          TaskID += task[i].getId();
//	        		  + ",";
	        }
	      }
	      System.out.println("taskId"+TaskID);
	    } catch (Exception eek) {
	      logger.info("** Exception:---" + eek.getMessage());
	    }
	 
	    return TaskID;
	  }
	 
	  public String CompleteTaskByID(String id, Map<String, Object> variables) {
	    String uri = OMSConstants.BASE_TASK_URL + id + OMSConstants.COMPLETE_URL;
	 
	    ResponseEntity<String> response = null;
	    logger.info(" Complete Varaibles" + variables);
//	    logger.info("Complete request" + variables.toString().contains("Approve"));
	 
	    RestTemplate restTemplate = new RestTemplate();
	    try {
	 
	      HttpComponentsClientHttpRequestFactory requestFactory =
	          new HttpComponentsClientHttpRequestFactory();
	      requestFactory.setConnectTimeout(0);
	      //requestFactory.setReadTimeout(0);
	      restTemplate.setRequestFactory(requestFactory);
	      logger.info("complete task URI::: " + uri);
	      HttpHeaders headers = new HttpHeaders();
	      headers.setContentType(MediaType.APPLICATION_JSON);
	      String AuthToken = "Bearer " + getTasklistToken();
	      headers.add("Authorization", AuthToken);
	      String requestJson = "";
	      ObjectMapper mapper = new ObjectMapper();
	      String MapperRequest = "";
	      try {
	        MapperRequest = mapper.writeValueAsString(variables);
	 
	        logger.info("JSON request" + MapperRequest);
	      } catch (Exception e) {
	        logger.info("JSON request exception");
	      }
	      if (variables.toString().contains("reviewStatus")) {
	        requestJson = "{\"variables\": [{\"name\": \"reviewStatus\",\"value\": true}]}";
	      } else if (variables.toString().contains("approved")) {
	        requestJson = "{\"variables\": [{\"name\": \"approved\",\"value\": true}]}";
	      } else {
	        requestJson = "{\"variables\": [{\"name\": \"ProcessID\",\"value\": \"\\\"hello\\\"\"}]}";
	      }
	 
	      headers.setContentType(MediaType.APPLICATION_JSON);
	      HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
	      logger.info("BBB:" + entity.getBody());
	      response = restTemplate.exchange(uri, HttpMethod.PATCH, entity, String.class);
	      
	      logger.info("hello");
	    } catch (Exception eek) {
	      logger.info("** Exception: " + eek.getMessage());
	    }
	    return response.getBody();
	  }
	 
	  public ArrayList<TaskVariables> GetOpenOrders(String process) {
	 
	    if (process.equals("")) {
	      process = "Order";
	    }
	 
	    ResponseEntity<TaskVariables[]> Resentity = null;
	    ArrayList<TaskVariables> Task1 = new ArrayList<TaskVariables>();
	 
	    RestTemplate restTemplate = new RestTemplate();
	    try {
	 
	      HttpComponentsClientHttpRequestFactory requestFactory =
	          new HttpComponentsClientHttpRequestFactory();
	      requestFactory.setConnectTimeout(0);
	      //requestFactory.setReadTimeout(0);
	      restTemplate.setRequestFactory(requestFactory);
	 
	      HttpHeaders headers = new HttpHeaders();
	      headers.setContentType(MediaType.APPLICATION_JSON);
	      String AuthToken = "Bearer " + getTasklistToken();
	      headers.add("Authorization", AuthToken);
	 
	      String requestJson =
	          "{\"taskState\":\"CREATED\",\"includeVariables\": [\r\n"
	              + "    {\r\n"
	              + "      \"name\": \"firstName\"\r\n"
	              + "      },\r\n"
	              + "       {\r\n"
	              + "      \"name\": \"orderID\"\r\n"
	              + "      },\r\n"
	              + "      {\r\n"
	              + "        \"name\":\"status\"\r\n"
	              + "      }]}";
	 
	      HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
	      Resentity =
	          restTemplate.exchange(
	              OMSConstants.TASKS_SEARCH_URL, HttpMethod.POST, entity, TaskVariables[].class);
	      TaskVariables[] task = Resentity.getBody();
	      logger.info("Fetch all orders" + Resentity.getBody());
	      for (int i = 0; i < task.length; i++) {
	 
	        // logger.info("result " + i + " " + task[i]); String taskid =
	        task[i].getId();
	        String processID = task[i].getProcessInstanceKey();
	 
	        if (task[i].getProcessName().contains(process)
	            && (task[i].getTaskState() == null
	                || task[i].getTaskState().equalsIgnoreCase("CREATED"))) {
	 
	          Task1.add(task[i]);
	          logger.info(
	              "Process ID"
	                  + processID
	                  + "State "
	                  + task[i].getState()
	                  + "  Task State"
	                  + task[i].getTaskState());
	        }
	      }
	 
	    } catch (Exception e) {
	      logger.info("exception in get tasks " + e.getMessage());
	    }
	    return Task1;
	  }
	 
	  public String getKeyCloakToken() {
	    String token = "";
	    String uri =
	        "http://localhost:18080/auth/realms/camunda-platform/protocol/openid-connect/token";
	    logger.info(" inside Patch ::" + uri);
	    RestTemplate restTemplate = new RestTemplate();
	    try {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	      MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	 
	      map.add("client_secret", OMSConstants.KEYCLOAK_CLIENT_SECRET);
	      map.add("client_id", OMSConstants.KEYCLOAK_CLIENT_ID);
	      map.add("grant_type", OMSConstants.GRANT_TYPE);
	 
	      HttpEntity<MultiValueMap<String, String>> request =
	          new HttpEntity<MultiValueMap<String, String>>(map, headers);
	 
	      ResponseEntity<AccessToken> response =
	          restTemplate.exchange(uri, HttpMethod.POST, request, AccessToken.class);
	      token = response.getBody().getAccess_token();
	 
	      logger.info(" accss toekn ::: " + response.getBody());
	      logger.info(
	          "Result - status (" + response.getStatusCode() + ") has body: " + response.hasBody());
	    } catch (Exception eek) {
	      logger.info("** Exception: " + eek.getMessage());
	    }
	 
	    return token;
	  }
	 
	  public TaskVariables[] GetOpenOrders(String process, String userGroup) {
	 
	    if (process.equals("")) {
	      process = "Order";
	    }
	    TaskVariables[] task = null;
	    ResponseEntity<TaskVariables[]> Resentity = null;
	    ArrayList<TaskVariables> Task1 = new ArrayList<TaskVariables>();
	 
	    RestTemplate restTemplate = new RestTemplate();
	 
	    try {
	 
	      HttpComponentsClientHttpRequestFactory requestFactory =
	          new HttpComponentsClientHttpRequestFactory();
	 
	      requestFactory.setConnectTimeout(0);
	      //requestFactory.setReadTimeout(0);
	      restTemplate.setRequestFactory(requestFactory);
	 
	      HttpHeaders headers = new HttpHeaders();
	      headers.setContentType(MediaType.APPLICATION_JSON);
	 
	      String AuthToken = "Bearer " + getTasklistToken();
	      headers.add("Authorization", AuthToken);
	 
	      String requestJson = "{\"state\":\"CREATED\",\"candidateGroup\":\"" + userGroup + "\"}";
	 
	      logger.info("----requestJson-->" + requestJson);
	 
	      HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
	 
	      Resentity =
	          restTemplate.exchange(
	              OMSConstants.TASKS_SEARCH_URL, HttpMethod.POST, entity, TaskVariables[].class);
	 
	      task = Resentity.getBody();
	 
	    } catch (Exception e) {
	      logger.info("exception in get tasks " + e.getMessage());
	    }
	    return task;
	  }
	  public void assignTask(String ProcessID, String taskID, String userID) {
		   
		    RestTemplate restTemplate = new RestTemplate();
		    try {
	 
		      HttpComponentsClientHttpRequestFactory requestFactory =
		          new HttpComponentsClientHttpRequestFactory();
		      requestFactory.setConnectTimeout(0);
		      //requestFactory.setReadTimeout(0);
		      restTemplate.setRequestFactory(requestFactory);
		      HttpHeaders headers = new HttpHeaders();
		      headers.setContentType(MediaType.APPLICATION_JSON);
		      String AuthToken = "Bearer " + getTasklistToken();
		      headers.add("Authorization", AuthToken);
	 
		      String requestJson =
		    		  "{\"assignee\":\""+ userID +"\" , \"allowOverrideAssignment\":true}";
		      HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
	 
		   //   ResponseEntity<TaskVariables> resEntity =
		          restTemplate.exchange(
		              OMSConstants.TASKS_ASSIGN_URL+taskID+"/assign", HttpMethod.PATCH, entity, TaskVariables.class);
		     // System.out.println("assign task response: "+ resEntity.getBody());
//		      TaskVariables[] task = resEntity.getBody();
//		      for (int i = 0; i < task.length; i++) {
//		        if (task[i].getProcessInstanceKey().equals(ProcessID)
//		            && task[i].getTaskState().equals("CREATED")) {
//		          logger.info(" Match found at " + i + task[i].getName());
//		          TaskID += task[i].getId();
////		        		  + ",";
//		        }
//		      }
	 
		    } catch (Exception eek) {
		      logger.info("** Exception: " + eek.getMessage());
		    }
	 
		    
		  }
	}
	 


