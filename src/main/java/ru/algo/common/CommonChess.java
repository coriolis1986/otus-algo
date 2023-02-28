package ru.algo.common;

public interface CommonChess extends CommonAlgo {

    default String[] exec(String[] input) {
        return guessMoves(Integer.parseInt(input[0])).toResult();
    }

    ChessMove guessMoves(int pos);
}
