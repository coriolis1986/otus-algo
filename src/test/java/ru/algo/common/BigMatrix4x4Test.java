package ru.algo.common;

import org.junit.jupiter.api.Test;

import static java.math.BigInteger.valueOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BigMatrix4x4Test {

    @Test
    void multiple() {
        BigMatrix4x4 m1 = new BigMatrix4x4();
        m1.a11 = valueOf(2); m1.a12 = valueOf(1);
        m1.a21 = valueOf(1); m1.a22 = valueOf(1);

        BigMatrix4x4 m2 = new BigMatrix4x4();
        m2.a11 = valueOf(1); m2.a12 = valueOf(1);
        m2.a21 = valueOf(1); m2.a22 = valueOf(0);

        BigMatrix4x4 res = new BigMatrix4x4();
        res.a11 = valueOf(3); res.a12 = valueOf(2);
        res.a21 = valueOf(2); res.a22 = valueOf(1);

        BigMatrix4x4 mul = m1.multiple(m2);

        assertTrue(mul.equals(res));
    }

    @Test
    void pow() {
        BigMatrix4x4 m = new BigMatrix4x4();
        m.a11 = valueOf(1); m.a12 = valueOf(1);
        m.a21 = valueOf(1); m.a22 = valueOf(0);

        BigMatrix4x4 res4 = new BigMatrix4x4();
        res4.a11 = valueOf(5); res4.a12 = valueOf(3);
        res4.a21 = valueOf(3); res4.a22 = valueOf(2);

        BigMatrix4x4 res19 = new BigMatrix4x4();
        res19.a11 = valueOf(6765); res19.a12 = valueOf(4181);
        res19.a21 = valueOf(4181); res19.a22 = valueOf(2584);

        BigMatrix4x4 poweredMatrix4 = m.power(4);
        BigMatrix4x4 poweredMatrix19 = m.power(19);

        assertTrue(poweredMatrix4.equals(res4));
        assertTrue(poweredMatrix19.equals(res19));
    }
}