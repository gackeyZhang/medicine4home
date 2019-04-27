package com.gackey.medicine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.gackey.medicine.mapper")
@SpringBootApplication
public class Medicine4homeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Medicine4homeApplication.class, args);
	}

}
