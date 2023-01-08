package com.vg.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringbootProducerApp implements CommandLineRunner {
	
	@Autowired 
	private  WikimediaChangesProducer wikimediaChangesProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootProducerApp.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception { 
		
		wikimediaChangesProducer.sendMsg();
	}

}
