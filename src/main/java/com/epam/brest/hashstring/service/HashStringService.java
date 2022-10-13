package com.epam.brest.hashstring.service;

import com.epam.brest.hashstring.component.HashString;
import com.epam.brest.hashstring.jparepositories.HashStringJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan ("com.epam.brest")
@EnableJpaRepositories
public class HashStringService {
    @Autowired (required=true)
    HashStringJpaRepo hashStringJpaRepo;

    public List <HashString> getAllHashStrings (){
        return hashStringJpaRepo.getAllStrings();
    }

    public Long saveNewHashString (HashString hashString){
        return hashStringJpaRepo.saveNewHashString(hashString);
    }
}
