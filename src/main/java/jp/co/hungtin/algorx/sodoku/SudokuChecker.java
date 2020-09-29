package jp.co.hungtin.algorx.sodoku;

import java.util.*;

class SudokuChecker {
    public boolean isValidSudoku(char[][] board) {
        return isBoardRowValid(board) && isBoardColValid(board) && isSmall3x3BoardValid(board);
    }

    public boolean isBoardRowValid(char[][] board) {
        Set<Character> set = new HashSet<>();

        for (char[] row : board) {
            set.clear();
            for (char symbol : row) {
                if (symbol != ('.') && !set.add(symbol)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBoardColValid(char[][] board) {
        Set<Character> set = new HashSet<>();

        for (int colIdx = 0; colIdx < 9; colIdx++) {
            set.clear();
            for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
                if (board[rowIdx][colIdx] != ('.') && !set.add(board[rowIdx][colIdx])) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isSmall3x3BoardValid(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int colIdx = 0; colIdx < 9; colIdx++) {
            for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
                int boxRowId = rowIdx / 3;
                int boxColId = colIdx / 3;

                String b = boxRowId + "(" + board[rowIdx][colIdx] + ")" + boxColId;
                if (board[rowIdx][colIdx] != ('.') && !set.add(b)) {
                    return false;
                }
            }
        }

        return true;
    }
}