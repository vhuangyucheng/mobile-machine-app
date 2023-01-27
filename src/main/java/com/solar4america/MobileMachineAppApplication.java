package com.solar4america;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.solar4america.mapper")
public class MobileMachineAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileMachineAppApplication.class, args);
	}

}
