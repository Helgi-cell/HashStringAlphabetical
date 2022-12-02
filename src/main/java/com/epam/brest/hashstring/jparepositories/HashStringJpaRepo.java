package com.epam.brest.hashstring.jparepositories;

import com.epam.brest.hashstring.component.HashString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HashStringJpaRepo extends JpaRepository<HashString, Long> {

    default List<HashString> getAllStrings() {return findAll();}

    default String saveNewHashString(HashString hashString){return save(hashString).getHashing();}

    default void deleteHashString(Long id){deleteById(id);}

}
