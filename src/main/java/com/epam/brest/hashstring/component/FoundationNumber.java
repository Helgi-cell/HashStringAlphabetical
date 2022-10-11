package com.epam.brest.hashstring.component;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
final public class FoundationNumber {

    private static Integer getFoundation(){
        return new Random().nextInt(1000);
    }
}
