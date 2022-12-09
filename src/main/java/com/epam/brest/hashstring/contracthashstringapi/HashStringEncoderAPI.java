package com.epam.brest.hashstring.contracthashstringapi;

import java.math.BigInteger;

public interface HashStringEncoderAPI extends MaxBigIntegerBasic{
    String getHashString(String string, BigInteger foundation);
}
