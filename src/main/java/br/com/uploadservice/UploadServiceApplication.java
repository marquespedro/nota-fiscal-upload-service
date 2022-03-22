package br.com.uploadservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"br.com.uploadservice"})
public class UploadServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadServiceApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();	
		return modelMapper;
	}
}
