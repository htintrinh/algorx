package jp.co.hungtin.algorx.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivisionTest {

    private static Stream<Arguments> providerForDivisionWithBitManipulation() {
        return Stream.of(
//                Arguments.of(15, 3, 5),
//                Arguments.of(2048, 2, 1024),
//                Arguments.of(101, 2, 50),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE, 1)
//                Arguments.of(Integer.MAX_VALUE, 1, Integer.MAX_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("providerForDivisionWithBitManipulation")
    void solution(int dividend, int divisor, int quotient) {
        var SUT = new Division();

        assertEquals(quotient, SUT.solution(dividend, divisor));
    }
}