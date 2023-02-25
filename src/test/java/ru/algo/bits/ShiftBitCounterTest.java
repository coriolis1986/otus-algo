package ru.algo.bits;

import org.junit.jupiter.api.Test;

import static java.math.BigInteger.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.algo.bits.BitCounter.countBits;
import static ru.algo.bits.BitCounter.countBitsViaAnd;
import static ru.algo.bits.BitCounter.countBitsViaCaching;

class ShiftBitCounterTest {

    @Test
    void testCountBits() {

        int val = 0b10101010_10101010_10001000;
        int cnt = countBits(valueOf(val));
        int cnt2 = countBitsViaAnd(valueOf(val));
        int cnt3 = countBitsViaCaching(valueOf(val));

        assertEquals(10, cnt);
        assertEquals(10, cnt2);
        assertEquals(10, cnt3);
    }
}