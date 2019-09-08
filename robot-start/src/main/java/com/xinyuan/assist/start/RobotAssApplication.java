package com.xinyuan.assist.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.xinyuan.assist.*")
public class RobotAssApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotAssApplication.class, args);
	}

}
