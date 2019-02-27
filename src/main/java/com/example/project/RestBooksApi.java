package com.example.project;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class RestBooksApi {
	
	public static void main(String[] args) {
		SpringApplication.run(RestBooksApi.class, args);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpheader = new HttpHeaders();
		
		httpheader.setContentType(MediaType.APPLICATION_JSON);
		httpheader.add("accept", "application/json");
		HttpEntity<String> httpentity = new HttpEntity<String>(httpheader);
		String url = "https://www.googleapis.com/books/v1/volumes?q=isbn:0735619670";
		ResponseEntity<Object> response = 
				restTemplate.exchange(url, HttpMethod.GET, httpentity,Object.class);
		System.out.println(response.getStatusCode());
		System.out.println(response.toString());
		
		
		
	}
	
}
