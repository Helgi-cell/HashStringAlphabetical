package com.epam.brest.hashstring;

import com.epam.brest.hashstring.component.FoundationNumber;
import com.epam.brest.hashstring.component.HashString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.epam.brest.hashstring.component.FoundationNumber.getFoundation;

@SpringBootTest
class HashStringApplicationTests {

	@Test
	void contextLoads() {
		Integer foundation = getFoundation();
		HashString hashString  = new HashString("AlehSukhadolski", foundation );
		HashString hashString1 = new HashString("AlehSukhadolsky", foundation);
		Assertions.assertTrue (hashString.getHash() < hashString1.getHash());
        System.out.println("foundation = " + foundation);
	}


}
