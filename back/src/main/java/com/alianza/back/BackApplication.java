package com.alianza.back;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BackApplication {


	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}



	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(BackApplication.class);
	}

}
