package com.example.POJO;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

public class TaskListVariableDetails {

	public static class TaskListVariableResponse {

		@Getter
		@Setter
		ResponseEntity<String> taskDetails;

		public ResponseEntity<String> getTaskDetails() {
			return taskDetails;
		}

		public void setTaskDetails(ResponseEntity<String> taskDetails) {
			this.taskDetails = taskDetails;
		}

		public String getProcessDefinitionKey() {
			return processDefinitionKey;
		}

		public void setProcessDefinitionKey(String processDefinitionKey) {
			this.processDefinitionKey = processDefinitionKey;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public JSONObject getJsonResponse() {
			return jsonResponse;
		}

		public void setJsonResponse(JSONObject jsonResponse) {
			this.jsonResponse = jsonResponse;
		}

		public String getFormId() {
			return formId;
		}

		public void setFormId(String formId) {
			this.formId = formId;
		}

		public String getAssignee() {
			return assignee;
		}

		public void setAssignee(String assignee) {
			this.assignee = assignee;
		}

		public String getTaskState() {
			return taskState;
		}

		public void setTaskState(String taskState) {
			this.taskState = taskState;
		}

		@Getter
		@Setter
		String processDefinitionKey;

		@Getter
		@Setter
		public String message;

		@Getter
		@Setter
		public JSONObject jsonResponse;

		@Getter
		@Setter
		public String formId;

		@Getter
		@Setter
		String assignee;

		@Getter
		@Setter
		String taskState;
	}

}
