package com.epam.brest.hashstring.component;

import java.util.Comparator;

public class ComparatorHash implements Comparator<HashString> {


    @Override
    public int compare(HashString o1, HashString o2) {
        if(o1.getHashing() > o2.getHashing())
            return 1;
        else if(o1.getHashing() < o2.getHashing())
            return -1;
        else
            return 0;
    }
}
