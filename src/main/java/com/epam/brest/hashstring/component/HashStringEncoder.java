package com.epam.brest.hashstring.component;

import com.epam.brest.hashstring.contracthashstringapi.MaxBigIntegerBasic;
import java.math.BigInteger;
public final class HashStringEncoder implements MaxBigIntegerBasic {
    public static BigInteger getHashString(String string, BigInteger foundation) {
        BigInteger step = new BigInteger("257");
        BigInteger result = new BigInteger("0");
        BigInteger[] charsToBigInteger = getCharArray(string);
        BigInteger[] charsToDouble = new BigInteger[charsToBigInteger.length];
        charsToDouble[0] = MaxBigIntegerBasic.maxValue.multiply(foundation);

        for (int i = 1; i < charsToDouble.length; i++) charsToDouble[i] = charsToDouble[i - 1].divide(step);
        for (int i = 0; i < charsToBigInteger.length; i++)
            charsToDouble[i] = charsToDouble[i].multiply(charsToBigInteger[i]);
        for (BigInteger chars : charsToDouble) result = chars.add(result);
        return result;
    }

    private static BigInteger[] getCharArray(String string) {
        char[] chars = string.toUpperCase().toCharArray();
        BigInteger[] bytes = new BigInteger[chars.length];
        int j = 0;
        for (int i = 0; i < chars.length; i++)
            bytes[i] = BigInteger.valueOf(((chars[i]) & 0x0000_FFFF) * 1L);

        return bytes;
    }
}
