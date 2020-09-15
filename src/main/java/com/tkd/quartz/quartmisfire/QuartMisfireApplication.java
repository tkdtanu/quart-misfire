package com.tkd.quartz.quartmisfire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QuartMisfireApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuartMisfireApplication.class, args);
	}

}
