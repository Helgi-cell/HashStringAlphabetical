package com.epam.brest.hashstring.component;




import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigInteger;

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


    public HashString(String string, String hashString,Integer foundation) {
        this.string = string;
        this.foundation = foundation;
        this.hashing = hashString;
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
}



