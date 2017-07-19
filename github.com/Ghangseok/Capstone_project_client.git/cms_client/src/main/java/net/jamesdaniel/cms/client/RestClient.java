package net.jamesdaniel.cms.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	public void login(String customer_id, String customer_pw) {
		final String uri = "http://localhost:8080/cms/webapi/customer/login?id={id}&pw={pw}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", customer_id);
		params.put("pw", customer_pw);

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class, params);

		System.out.println(result);
	}

	private static void addCustomer(String customer_id) {
		final String uri = "http://localhost:8080/cms/webapi/customer/add?id={id}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", customer_id);

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class, params);

		System.out.println(result);
	}

	/*
	private static void postCustomer(String customer_id) {
		final String uri = "http://localhost:8080/cms/webapi/customer/login?id={id}";

		Object newEmployee = new Object();

		RestTemplate restTemplate = new RestTemplate();
		Object result = restTemplate.postForObject(uri, newEmployee, Object.class);

		System.out.println(result);
	}

	private static void updateCustomer(String customer_id) {
		final String uri = "http://localhost:8080/cms/webapi/customer/login?id={id}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", customer_id);


		Object updatedEmployee = new Object();

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri, updatedEmployee, params);
	}
	*/
	public void withdrawCustomer(String customer_id) {
		final String uri = "http://localhost:8080/cms/webapi/customer/withdraw?id={id}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", customer_id);

		RestTemplate restTemplate = new RestTemplate();		
		String result = restTemplate.getForObject(uri, String.class, params);

		System.out.println(result);
	}

	public static void main(String[] args) {
		RestClient restClient = new RestClient();
		restClient.login("redeteus@gmail.com", "redeteus@gmail.com");
		// restClient.addCustomer("ghangseok.seo@gmail.com");
		restClient.withdrawCustomer("redeteus@gmail.com");
	}

}
