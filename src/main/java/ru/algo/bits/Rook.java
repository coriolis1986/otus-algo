package ru.algo.bits;

import ru.algo.common.ChessMove;
import ru.algo.common.CommonChess;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;
import static ru.algo.bits.BitCounter.countBits;

public class Rook implements CommonChess {

    @Override
    public String name() {
        return "Ладья";
    }

    @Override
    public ChessMove guessMoves(int pos) {

        BigInteger start = ONE.shiftLeft(pos);

        BigInteger res = ZERO;

        res = res.or(drawLine(pos, 1));
        res = res.or(drawLine(pos, 8));

        res = res.xor(start);

        ChessMove result = new ChessMove();
        result.setMoves(countBits(res));
        result.setMask(res);

        return result;
    }

    private BigInteger drawLine(int pos, int shift) {

        if (shift == 0)
            return ZERO;

        BigInteger start = ONE.shiftLeft(pos);

        BigInteger field = ZERO;
        BigInteger newField = start;

        BigInteger min = valueOf(2);
        BigInteger max = valueOf(2);

        if (shift > 0 && shift <= 7) {
            max = max.pow(((pos >> 3) + 1) << 3);
            min = min.pow(pos >> 3 << 3);
        }

        else if (shift > 7) {
            max = new BigInteger("ffffffffffffffff", 16);
            min = ZERO;
        }

        int newShift = shift;

        while (true) {
            BigInteger adder = start.shiftLeft(newShift);
            BigInteger substractor = start.shiftRight(newShift);

            if (adder.compareTo(max) < 0)
                newField = newField.or(adder);

            if (substractor.compareTo(min) >= 0)
                newField = newField.or(substractor);

            if (newField.equals(field))
                break;

            field = newField;
            newShift += shift;
        }

        return field;
    }
}
