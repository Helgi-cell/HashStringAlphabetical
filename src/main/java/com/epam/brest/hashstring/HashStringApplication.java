package com.epam.brest.hashstring;

import com.epam.brest.hashstring.component.FoundationNumber;
import com.epam.brest.hashstring.component.HashString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HashStringApplication {

	public static void main(String[] args) {

		SpringApplication.run(HashStringApplication.class, args);

		HashString hashString = new HashString("Aleh", 200);
		System.out.println("Hash " + hashString.getString() + " = " + hashString.getHash());
		hashString = new HashString("Alehz", 200);
		System.out.println("Hash " + hashString.getString() + " = " + hashString.getHash());
	}

}
