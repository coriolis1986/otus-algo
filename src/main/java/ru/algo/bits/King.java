package ru.algo.bits;

import ru.algo.common.ChessMove;
import ru.algo.common.CommonChess;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static ru.algo.bits.BitCounter.countBits;

public class King implements CommonChess {

    @Override
    public String name() {
        return "Король";
    }

    @Override
    public String[] exec(String[] input) {
        return guessMoves(Integer.parseInt(input[0])).toResult();
    }

    public ChessMove guessMoves(int pos) {

        BigInteger field = ONE;

        field = field.shiftLeft(pos);

        BigInteger leftBorder = new BigInteger("fefefefefefefefe", 16);
        BigInteger rightBorder = new BigInteger("7f7f7f7f7f7f7f7f", 16);

        BigInteger skipLeftBorder = field.and(leftBorder);
        BigInteger skipRightBorder = field.and(rightBorder);

        field =
                skipLeftBorder.shiftLeft(7)      .or(field.shiftLeft(8))      .or(skipRightBorder.shiftLeft(9)).add(
                skipLeftBorder.shiftRight(1)     .or(ZERO)                       .or(skipRightBorder.shiftLeft(1))).add(
                skipLeftBorder.shiftRight(9)     .or(field.shiftRight(8))     .or(skipRightBorder.shiftRight(7)));

        ChessMove result = new ChessMove();
        result.setMoves(countBits(field));
        result.setMask(field);

        return result;
    }
}
