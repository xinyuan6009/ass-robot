package com.xinyuan.assist.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.xinyuan.assist.*")
public class DailyNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyNotesApplication.class, args);
	}

}
