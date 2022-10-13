package com.epam.brest.hashstring.component;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Comparator;

//@Component
@Entity
public class HashString {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String string;
    private Double hash;
    private Integer foundation;



    public HashString(String string, Integer foundation) {
        this.string = string;
        this.foundation = foundation;
        this.hash = getHashString(string, foundation);
    }

    public HashString() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Double getHash() {
        return hash;
    }

    public void setHash(Double hash) {
        this.hash = hash;
    }

    public Integer getFoundation() {
        return foundation;
    }

    public void setFoundation(Integer foundation) {
        this.foundation = foundation;
    }

    static private Double getHashString(String string, Integer foundation){
        Double hash = 0.0 ;
        short [] charsToInteger = getCharArray(string);
        double step = Double.MAX_VALUE / 256 - foundation;
        for (int i = 0; i < charsToInteger.length ; i++ ){
            hash += charsToInteger[i] * step;
            step = step / 2 - 1;
        }
        return hash;
    }

    static private short [] getCharArray(String string){
        char [] chars = string.toLowerCase().toCharArray();
        short [] bytes = new short [chars.length];
        for (int i = 0; i < chars.length; i++){
            bytes [i] = (short) (chars[i] & 0x00FF);
            //System.out.println("bytes [" + i + "] = " + bytes[i]);
        }
        return bytes;
    }
}



