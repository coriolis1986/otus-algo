package ru.algo.bits;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

public class BitCounter {

    public static int countBits(BigInteger num) {
        int count = 0;

        while (!num.equals(ZERO)) {
            count += num.and(ONE).intValue();
            num = num.shiftRight(1);
        }

        return count;
    }

    public static int countBitsViaAnd(BigInteger num) {
        int count = 0;

        while (!num.equals(ZERO)) {
            count++;
            num = num.and(num.subtract(ONE));
        }

        return count;
    }

    private static final int[] BIT_COUNT_CACHE = new int[256];

    static {
        for (int i = 0; i < BIT_COUNT_CACHE.length; i++)
            BIT_COUNT_CACHE[i] = countBits(valueOf(i));
    }

    public static int countBitsViaCaching(BigInteger num) {

        int count = 0;

        while (!num.equals(ZERO)) {
            BigInteger check = num.and(valueOf(0b1111_1111));
            count += countBitsViaAnd(check);

            num = num.shiftRight(8);
        }

        return count;
    }
}
