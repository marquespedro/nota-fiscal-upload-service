package br.com.uploadservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "br.com.uploadservice" })
public class UploadServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UploadServiceApplication.class, args);
	}

}
