package com.epam.brest.hashstring;


import com.epam.brest.hashstring.component.HashString;
import com.epam.brest.hashstring.service.HashStringService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import javax.transaction.Transactional;

import java.math.BigInteger;
import java.util.List;

import static com.epam.brest.hashstring.component.FoundationNumber.getFoundation;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ComponentScan("com.epam.brest")
@EntityScan("com.epam.brest")
@Transactional
@EnableJpaRepositories
class HashStringApplicationTests {

	@Autowired (required=true)
	HashStringService hashStringService;
	@Test
	void contextLoads() {
		assertTrue(hashStringService != null);
	}




	@Test
	void isMaxSymbols () {
		HashString string  = new HashString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 1000);
		String idHashString = hashStringService.saveNewHashStringService(string);
		HashString string1  = new HashString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 1000);
		String idHashString1 = hashStringService.saveNewHashStringService(string1);
		List<HashString> strings = hashStringService.getAllHashStringsService();
		assertTrue (string.getHashing().compareTo(string1.getHashing()) < 0 );
		//assertTrue (idHashString.compareTo(idHashString1) > 0 );

	}


	@Test
	void isSymbols () {
		String string = "AA2345/.,0-sdbHH";
		string = string.toUpperCase();
		assertTrue (string.equals("AA2345/.,0-SDBHH"));
		//assertTrue (idHashString.compareTo(idHashString1) > 0 );

	}

}
