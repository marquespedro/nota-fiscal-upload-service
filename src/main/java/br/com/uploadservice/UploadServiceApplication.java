package br.com.uploadservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication(scanBasePackages = { "br.com.uploadservice" })
public class UploadServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UploadServiceApplication.class, args);
	}

	
	@Bean
	public ObjectMapper objectMapper () {
		ObjectMapper mapper = new ObjectMapper();
		return mapper;
	}
	
}
