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

    public HashString(Long id, String string, long hash, Integer foundation) {
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
        long [] charsToLong = getCharArray(string);
        long step = Long.MAX_VALUE - 26L - foundation * 1L ;

        for (int i = 0; i < charsToLong.length; i++) {
            hash += (charsToLong[i] + step) ;
            step =  step / 2L - 1L;
        }

        return hash;
    }

    private  long[] getCharArray(String string) {
        char[] chars = string.toUpperCase().toCharArray();
        long[] bytes = new long[chars.length];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (((chars[i]* 1L) & 0x0000_0000_0000_FFFF) > 64 && ((chars[i] * 1L) & 0x0000_0000_0000_FFFF) < 91){
                bytes[j] = ((chars[i] * 1L) & 0x0000_0000_0000_FFFF) - 64L;
                j++;
            }
        }
        return bytes;
    }
}



