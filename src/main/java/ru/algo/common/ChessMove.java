package ru.algo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChessMove {

    private int moves;
    private BigInteger mask;

    public String[] toResult() {
        String[] result = new String[2];
        result[0] = Integer.toString(moves);
        result[1] = mask.toString();

        return result;
    }
}
