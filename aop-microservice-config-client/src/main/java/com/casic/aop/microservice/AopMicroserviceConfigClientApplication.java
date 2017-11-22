package com.casic.aop.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
@EnableDiscoveryClient
public class AopMicroserviceConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopMicroserviceConfigClientApplication.class, args);
	}

	@Autowired
	void setEnvironment(Environment env) {
		System.out.println("my-config.appName from env: " + env.getProperty("my-config.appName"));
	}

	@Value("${my-config.appName}")
	private String appName;

	@RequestMapping("/appname")
	public String getAppName() {
		return appName;
	}
}
