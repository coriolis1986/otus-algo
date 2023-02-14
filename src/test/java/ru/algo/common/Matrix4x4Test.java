package ru.algo.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Matrix4x4Test {

    @Test
    void multiple() {
        Matrix4x4 m1 = new Matrix4x4();
        m1.a11 = 2; m1.a12 = 1;
        m1.a21 = 1; m1.a22 = 1;

        Matrix4x4 m2 = new Matrix4x4();
        m2.a11 = 1; m2.a12 = 1;
        m2.a21 = 1; m2.a22 = 0;

        Matrix4x4 res = new Matrix4x4();
        res.a11 = 3; res.a12 = 2;
        res.a21 = 2; res.a22 = 1;

        Matrix4x4 mul = m1.multiple(m2);

        assertTrue(mul.equals(res));
    }

    @Test
    void pow() {
        Matrix4x4 m = new Matrix4x4();
        m.a11 = 1; m.a12 = 1;
        m.a21 = 1; m.a22 = 0;

        Matrix4x4 res4 = new Matrix4x4();
        res4.a11 = 5; res4.a12 = 3;
        res4.a21 = 3; res4.a22 = 2;

        Matrix4x4 res19 = new Matrix4x4();
        res19.a11 = 6765; res19.a12 = 4181;
        res19.a21 = 4181; res19.a22 = 2584;

        Matrix4x4 poweredMatrix4 = m.power(4);
        Matrix4x4 poweredMatrix19 = m.power(19);

        assertTrue(poweredMatrix4.equals(res4));
        assertTrue(poweredMatrix19.equals(res19));
    }
}