package com.example.Config;

import lombok.SneakyThrows;

import java.io.IOError;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Utils.BearerTokenUtils;
import com.example.Utils.GlobalUtils;
import com.example.Utils.GlobalUtils.GlobalUtilHeaders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
@Import(BearerTokenGeneratorConfig.class)
public class HeaderConfig {

	@Autowired
	BearerTokenGeneratorConfig bearerTokenGeneratorConfig;

	// @Value("${application.json}")
	// private String applicationJson;

	@SneakyThrows
	public HttpHeaders addHeadersValue() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		// BearerTokenGeneratorConfig bearerTokenGeneratorConfig = new
		// BearerTokenGeneratorConfig();
		headers.set(GlobalUtilHeaders.ACCEPT, GlobalUtilHeaders.APPLICATIONJSON);// applicationJson);
		headers.set(GlobalUtilHeaders.CONTENT_TYPE, GlobalUtilHeaders.APPLICATIONJSON);// applicationJson);
		headers.set(GlobalUtilHeaders.AUTHORIZATION,
				BearerTokenUtils.BEARER + bearerTokenGeneratorConfig.generateBearerToken());
		return headers;
	}

}
