package com.example.ServiceImpl;

import io.camunda.zeebe.client.ZeebeClient;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Collections;

import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.Config.BearerTokenGeneratorConfig;
import com.example.Config.HeaderConfig;
import com.example.POJO.TaskListVariableDetails;
import com.example.Utils.BearerTokenUtils;
import com.example.Utils.GlobalUtils.GlobalTasklistUtils;
import com.example.Utils.GlobalUtils.GlobalUtilHeaders;

@Import(HeaderConfig.class)
public class TaskListServiceImpl {

	@Autowired
	private HeaderConfig headerConfig;

	public ResponseEntity<String> getAllTask(String requestBody) throws IOException {

		System.out.println("Service for GET A TASK FROM TASKLIST invoked..!!");

		TaskListVariableDetails.TaskListVariableResponse taskListVariableResponse = new TaskListVariableDetails.TaskListVariableResponse();

		HttpHeaders headers = headerConfig.addHeadersValue();
		HttpEntity<String> httpEntity = new HttpEntity(requestBody, headers);
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			response = restTemplate.exchange(GlobalTasklistUtils.TASKSEARCHURL, HttpMethod.POST, httpEntity,
					String.class);
		} catch (Exception ex) {
			taskListVariableResponse.setMessage(ex.getMessage());
			return new ResponseEntity(taskListVariableResponse, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
