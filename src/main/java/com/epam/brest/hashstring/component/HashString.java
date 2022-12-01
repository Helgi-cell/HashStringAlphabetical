package com.epam.brest.hashstring.component;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Arrays;

import static java.math.BigInteger.valueOf;

@Entity
@Data
public class HashString {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String string;

    private String hashing;
    private Integer foundation;

    public HashString(String string, Integer foundation) {
        this.string = string;
        this.foundation = foundation;
        this.hashing = getHashString(this.string, new BigInteger(this.foundation.toString())).toString();
    }

    public HashString(Long id, String string, String hash, Integer foundation) {
        this.id = id;
        this.string = string;
        this.hashing = hash;
        this.foundation = foundation;
    }

    public HashString() {
    }

    public HashString(Long id, String string) {
        this.id = 0L;
        this.string = string;
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

    public String getHashing() {
        return hashing;
    }

    public void setHashing(String hashing) {
        this.hashing = hashing;
    }

    public Integer getFoundation() {
        return foundation;
    }

    public void setFoundation(Integer foundation) {
        this.foundation = foundation;
    }

    private  BigInteger getHashString(String string, BigInteger foundation) {
        BigInteger maxValue = new BigInteger("99999999999999999999999999999999999999999999999999999999999999999999999");

        BigInteger step = new BigInteger("27");

        BigInteger result = new BigInteger("0");

        BigInteger[] charsToBigInteger = getCharArray(string);

        BigInteger[] charsToDouble = new BigInteger[charsToBigInteger.length];

        charsToDouble[0] = maxValue.multiply(foundation);
        for (int i = 1; i < charsToDouble.length; i++) {
            charsToDouble[i] = charsToDouble[i - 1].divide(step);
        }

        for (int i = 0; i < charsToBigInteger.length; i++) {
            charsToDouble[i] = charsToDouble[i].multiply(charsToBigInteger[i]);
        }
        for (BigInteger chars : charsToDouble) {
            result = chars.add(result);
        }
        return result;
    }

    private  BigInteger[] getCharArray(String string) {
        char[] chars = string.toUpperCase().toCharArray();
        BigInteger[] bytes = new BigInteger[chars.length];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            bytes[i] = BigInteger.valueOf(((chars[i]) & 0x0000_FFFF) * 1L);
        }
        return bytes;
    }
}



