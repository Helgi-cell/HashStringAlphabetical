package com.epam.brest.hashstring.service;

import com.epam.brest.hashstring.component.HashString;
import com.epam.brest.hashstring.contracthashstringapi.HashStringEncoderAPI;
import com.epam.brest.hashstring.jparepositories.HashStringJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ComponentScan("com.epam.brest.*")
public class HashStringService {
    @Autowired
    private HashStringJpaRepo hashStringJpaRepo;
    @Autowired
    private HashStringEncoderAPI hashStringEncoder;

    public List<HashString> getAllHashStringsService() {
        List<HashString> hashStrings = hashStringJpaRepo.getAllStrings();
        if (!hashStrings.isEmpty()) {
            return hashStrings.stream()
                    .sorted(Comparator.comparing(HashString::getHashing))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<HashString>();
        }
    }

    public String saveNewHashStringService(HashString string) {return hashStringJpaRepo.saveNewHashString(string);}

    public void deleteHashStringService(Long id) {hashStringJpaRepo.deleteHashString(id);}

    public String createNewHashStringService (String word, Integer foundation){
       return hashStringEncoder.getHashString(word, new BigInteger(foundation.toString()));
    }
}
