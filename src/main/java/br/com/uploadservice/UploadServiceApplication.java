package br.com.uploadservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@SpringBootApplication(scanBasePackages = {"br.com.uploadservice"})
public class UploadServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadServiceApplication.class, args);
	}

	
	@Bean
	public XmlMapper xmlMapper() {

		XmlMapper mapper = new XmlMapper();
		
		return mapper;
	}
}
