package com.aaseya.alps;

public class OMSConstants {
  public static String CLIENT_ID = "tasklist";
  public static String BPMN_PROCESS_ID = "Process_Orderfullfillment";
  public static String TOKEN_URL = "http://10.13.1.180:18080/auth/realms/camunda-platform/protocol/openid-connect/token";
  public static String CLIENT_SECRET = "XALaRPl5qwTEItdwCMiPS62nVpKs7dL7";

  public static String GRANT_TYPE = "client_credentials";
  public static String TASKS_SEARCH_URL = "http://10.13.1.180:8082/v1/tasks/search";
  public static String BASE_TASK_URL = "http://10.13.1.180:8082/v1/tasks/";
  public static String COMPLETE_URL = "/complete";
  public static String SEARCH_TASK_VARIABLES = "/variables/search";

  public static String KEYCLOAK_CLIENT_ID = "aaseyainspectionsolution";
  public static String KEYCLOAK_CLIENT_SECRET = "nTJJR3VDiLS0GQGySp2aBcNUUHRQIUVn";
  public static final String TASKS_ASSIGN_URL = "http://10.13.1.180:8082/v1/tasks/";
}
