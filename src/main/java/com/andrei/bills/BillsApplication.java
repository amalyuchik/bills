package com.andrei.bills;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.andrei.bills.dao")
@SpringBootApplication
public class BillsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillsApplication.class, args);
	}

}
