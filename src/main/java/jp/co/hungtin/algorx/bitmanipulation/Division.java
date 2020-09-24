package jp.co.hungtin.algorx.bitmanipulation;

public class Division {
  public int solution(int dividend, int divisor) {

    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    long dividendLong = Math.abs(Long.valueOf(dividend));
    long divisorLong = Math.abs(Long.valueOf(divisor));
    int sign = dividend < 0 ^ divisor < 0 ? -1 : 1;

    int quotient = 0;
    while (dividendLong >= divisorLong) {
      int round = 0;
      long divisorRound = divisorLong;
      while (dividendLong >= divisorRound) {
        divisorRound = divisorRound << 1;
        round++;
      }
      quotient += 1 << (round - 1);
        dividendLong = dividendLong - (divisorLong << (round - 1));
    }

    return quotient * sign;
  }
}
