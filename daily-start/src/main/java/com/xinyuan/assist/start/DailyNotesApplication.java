package com.xinyuan.assist.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.xinyuan.assist.*")
@EnableScheduling
public class DailyNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyNotesApplication.class, args);
	}

}
