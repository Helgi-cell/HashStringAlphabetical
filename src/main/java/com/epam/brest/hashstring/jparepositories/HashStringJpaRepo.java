package com.epam.brest.hashstring.jparepositories;

import com.epam.brest.hashstring.component.HashString;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface HashStringJpaRepo extends JpaRepository<HashString, Long> {

    default List<HashString> getAllStrings() {
        return findAll();
    }

    default String saveNewHashString(HashString hashString) {
        return save(hashString).getHashing();
    }

    default void deleteHashString(Long id) {
        deleteById(id);
    }
}
