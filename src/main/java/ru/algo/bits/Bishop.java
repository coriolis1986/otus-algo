package ru.algo.bits;

import ru.algo.common.ChessMove;
import ru.algo.common.CommonChess;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;
import static ru.algo.bits.BitCounter.countBits;

@SuppressWarnings("ConditionalBreakInInfiniteLoop")
public class Bishop implements CommonChess {

    @Override
    public String name() {
        return "Слон";
    }

    @Override
    public ChessMove guessMoves(int pos) {

        BigInteger res = ZERO;

        res = res.or(drawLine(pos, 9));
        res = res.or(drawLine(pos, 7));

        BigInteger max = new BigInteger("ffffffffffffffff", 16);

        while (res.compareTo(max) >= 0)
            res = res.subtract(max.add(ONE));

        ChessMove result = new ChessMove();
        result.setMask(res);
        result.setMoves(countBits(res));

        return result;
    }

    private BigInteger drawLine(int pos, int shift) {

        if (shift == 0)
            return ZERO;

        BigInteger start = ONE.shiftLeft(pos);

        BigInteger p = start;

        while (p.compareTo(valueOf(255)) > 0)
            p = p.shiftRight(8);

        BigInteger max = new BigInteger("ffffffffffffffff", 16);

        BigInteger mask = valueOf(~p.intValue() & 0xff);
        mask = mask.shiftLeft(pos >> 3 << 3);
        mask = max.xor(mask);

        BigInteger curUp = start;
        BigInteger curDown = start;

        BigInteger field = ZERO;

        BigInteger leftBorder = new BigInteger("101010101010101", 16);
        BigInteger rightBorder = new BigInteger("80808080808080", 16);

        while (true) {
            curUp = curUp.shiftLeft(shift);
            curDown = curDown.shiftRight(shift);

            if (curUp.compareTo(max) >= 0)
                curUp = ZERO;

            if (curUp.and(leftBorder).compareTo(ZERO) != 0 || curUp.and(rightBorder).compareTo(ZERO) != 0) {
                field = field.or(curUp);

                curUp = ZERO;
            }

            if (curDown.and(leftBorder).compareTo(ZERO) != 0 || curDown.and(rightBorder).compareTo(ZERO) != 0) {
                field = field.or(curDown);

                curDown = ZERO;
            }

            field = field.or(curUp).or(curDown);

            if (curUp.equals(ZERO) && curDown.equals(ZERO))
                break;
        }

        return field.and(mask);
    }
}
