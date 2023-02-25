package ru.algo.bits;

import ru.algo.common.ChessMove;
import ru.algo.common.CommonChess;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;
import static ru.algo.bits.BitCounter.countBits;

public class Horse implements CommonChess {

    @Override
    public String name() {
        return "Конь";
    }

    @Override
    public String[] exec(String[] input) {
        return guessMoves(Integer.parseInt(input[0])).toResult();
    }

    @Override
    public ChessMove guessMoves(int pos) {
        BigInteger field = ONE.shiftLeft(pos);
        BigInteger mask = prepareMask(pos);

        BigInteger res = ZERO;

        res = res.or(field.shiftRight(15));
        res = res.or(field.shiftRight(17));
        res = res.or(field.shiftRight(10));
        res = res.or(field.shiftRight(6));

        res = res.or(field.shiftLeft(15));
        res = res.or(field.shiftLeft(17));
        res = res.or(field.shiftLeft(10));
        res = res.or(field.shiftLeft(6));

        res = res.and(mask);

        ChessMove result = new ChessMove();
        result.setMoves(countBits(res));
        result.setMask(res);

        return result;
    }

    private BigInteger prepareMask(int pos) {
        int mask = 0b00011111;

        int p = pos % 8 - 2;

        if (p > 0)
            mask = (mask << p) & 0b11111111;

        if (p < 0)
            mask = (mask >> -p);

        BigInteger result = valueOf(mask);
        result = result.or(result.shiftLeft(8));
        result = result.or(result.shiftLeft(8));
        result = result.or(result.shiftLeft(8));
        result = result.or(result.shiftLeft(8));
        result = result.or(result.shiftLeft(8));
        result = result.or(result.shiftLeft(8));
        result = result.or(result.shiftLeft(8));

        return result;
    }
}
