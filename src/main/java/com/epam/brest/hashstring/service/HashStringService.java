package com.epam.brest.hashstring.service;

import com.epam.brest.hashstring.component.HashString;
import com.epam.brest.hashstring.jparepositories.HashStringJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ComponentScan("com.epam.brest.*")
public class HashStringService {
    @Autowired
    private HashStringJpaRepo hashStringJpaRepo;

    public List<HashString> getAllHashStringsService() {
        List<HashString> hashStrings = hashStringJpaRepo.getAllStrings();

        if (hashStrings != null) {
            hashStrings = hashStrings.stream()
                    .sorted(Comparator.comparingLong(HashString::getHashing))
                    .collect(Collectors.toList());
        }
        return hashStrings;
    }

    public Long saveNewHashStringService(HashString string) {
        return hashStringJpaRepo.saveNewHashString(string);
    }

    public void deleteHashStringService(Long id) {
        hashStringJpaRepo.deleteHashString(id);
    }
}
