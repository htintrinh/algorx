package jp.co.hungtin.algorx.sodoku;

import java.util.HashSet;
import java.util.Set;

class SudokuChecker {
  public String wrapSymbolCharToString(char symbol) {
    return "(" + symbol + ")";
  }

  public boolean isValidSudoku(char[][] board) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        char b = board[i][j];

        if (b != '.'
            && (!set.add(i + wrapSymbolCharToString(b))
                || !set.add(wrapSymbolCharToString(b) + j)
                || !set.add(i / 3 + wrapSymbolCharToString(b) + j / 3))) {
          return false;
        }
      }
    }

    return true;
  }
}
