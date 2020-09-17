package jp.co.hungtin.algorx.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HayStackAndNeedleTest {

    private static Stream<Arguments> providerHayStackAndNeedle() {
        return Stream.of(
                Arguments.of("hello", "ll", 2),
                Arguments.of("aaaaa", "baa", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("providerHayStackAndNeedle")
    void strStr(String hayStack, String needle, int expect) {
        var SUT = new HayStackAndNeedle();
        assertEquals(expect, SUT.strStr(hayStack, needle));
    }
}