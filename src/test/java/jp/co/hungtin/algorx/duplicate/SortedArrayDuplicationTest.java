package jp.co.hungtin.algorx.duplicate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortedArrayDuplicationTest {

    private static Stream<Arguments> consolidateDuplicatedArrayProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 5),
                Arguments.of(new int[]{1, 1, 1, 1, 5}, 2),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 1),
                Arguments.of(new int[]{}, 0),
                Arguments.of(null, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("consolidateDuplicatedArrayProvider")
    void consolidateDuplicatedArray(int[] input, int expect) {
        int actualResult = SortedArrayDuplication.consolidateDuplicatedArray(input);
        assertEquals(expect, actualResult);
    }
}