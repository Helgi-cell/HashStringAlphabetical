package com.epam.brest.hashstring.component;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class HashString {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String string;
    private long hashing;
    private Integer foundation;

    public HashString(String string, Integer foundation) {
        this.string = string;
        this.foundation = foundation;
        this.hashing = getHashString(string, foundation);
    }

    public HashString(Long id, String string, Long hash, Integer foundation) {
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

    private long getHashString(String string, Integer foundation) {
        long hash = 0L;
        long[] charsToLong = getCharArray(string);
        long step = Long.MAX_VALUE / 256 - foundation;
        Long chars = 0L;
        for (int i = 0; i < charsToLong.length; i++) {
            hash += charsToLong[i] * step;
            step = step / 256;
        }
        return hash;
    }

    private long[] getCharArray(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        int[] bytes = new int[chars.length];
        long[] longs = new long[chars.length];
        for (int i = 0; i < chars.length; i++) {
            bytes[i] = (chars[i]) & 0x0000_FFFF;
            longs[i] = bytes[i];
        }
        return longs;
    }
}



