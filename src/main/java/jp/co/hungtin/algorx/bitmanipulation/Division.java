package jp.co.hungtin.algorx.bitmanipulation;

public class Division {
    public int solution(int dividend, int divisor) {
        // dividend = 15, divisor = 3
        // divisor = 3, 6, 12, 24 -> 4
        // divisor = 3
        // dividend = 15 = 4 * 3 + 3
        // quotient = 5

        // dividend = 14, divisor = 3
        // divisor = 3, 6, 12 => quotient = 1 << 2 = 4
        // dividend = 14 = 4 * 3 + 2
        // quotient = 4

//        if (divisor == 1) {
//            return dividend;
//        }

        if (dividend < divisor) {
            return 0;
        }

        int quotient = 0;
        while (dividend >= divisor) {
            int round = 0;

            int divisorRound = divisor;
            while (dividend >= divisorRound) {
                if (divisorRound << 1 == Integer.MIN_VALUE) {
                    break;
                }
                divisorRound = divisorRound << 1;

                round++;
            }
            quotient += 1 << (round - 1);
            dividend = dividend - (divisor << (round - 1));
        }

        return quotient;
    }
}
