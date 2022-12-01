package com.epam.brest.hashstring.component;

import java.util.Comparator;

public class ComparatorHash implements Comparator<HashString> {


    @Override
    public int compare(HashString o1, HashString o2) {
        return o1.getHashing().compareTo(o2.getHashing());
    }
}
