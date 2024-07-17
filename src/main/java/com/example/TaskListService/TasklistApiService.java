package com.example.TaskListService;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.example.POJO.TaskListVariableDetails;

public interface TasklistApiService {

	ResponseEntity<String> getAllTask(String requestBody);

}
