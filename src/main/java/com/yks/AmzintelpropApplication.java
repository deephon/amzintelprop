package com.yks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yks.**.dao")
public class AmzintelpropApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmzintelpropApplication.class, args);
	}
}
