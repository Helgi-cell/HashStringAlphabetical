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
	void stringLoad() {
		Integer foundation = getFoundation();
		HashString hashString  = new HashString("AlehSukhadolski", foundation );
		Long idHashString = hashStringService.saveNewHashString(hashString);
		HashString hashString1 = new HashString("AlehSukhadolsky", foundation);
		Long idHashString1 = hashStringService.saveNewHashString(hashString1);
		assertTrue (hashString.getHash() < hashString1.getHash());
		System.out.println("foundation = " + foundation);
		assertTrue (idHashString > 0);
		assertTrue (idHashString1 > 0);
	}

}
