package com.epam.brest.hashstring;

import com.epam.brest.hashstring.component.FoundationNumber;
import com.epam.brest.hashstring.component.HashString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class })
public class HashStringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HashStringApplication.class, args);

	}
}
