package com.epam.brest.hashstring.component;

import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class HashComparator implements Comparator<HashString> {

    public int compare(HashString a, HashString b){
        return a.getHash().compareTo(b.getHash());
    }
}