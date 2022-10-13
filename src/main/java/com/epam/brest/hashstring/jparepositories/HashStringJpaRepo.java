package com.epam.brest.hashstring.jparepositories;

import com.epam.brest.hashstring.component.HashComparator;
import com.epam.brest.hashstring.component.HashString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface HashStringJpaRepo extends JpaRepository <HashString, Long> {

    default List<HashString> getAllStrings(){

        return findAll()
                .stream()
                .sorted(new HashComparator().thenComparingDouble(HashString::getHash))
                .collect(Collectors.toList());
    }


    default Long saveNewHashString (HashString hashString){
       return save(hashString).getId();
    }

}
