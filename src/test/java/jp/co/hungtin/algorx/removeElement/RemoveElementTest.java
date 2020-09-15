package jp.co.hungtin.algorx.removeElement;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RemoveElementTest {

  private static Stream<Arguments> providerForRemoveElement() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 4}, 1, 3), Arguments.of(new int[] {1, 1, 1, 4}, 1, 1));
  }

  @ParameterizedTest
  @MethodSource("providerForRemoveElement")
  void removeElement(int[] elements, int removeVal, int expect) {
    var SUT = new RemoveElement();

    assertEquals(expect, SUT.removeElement(elements, removeVal));
    for (int i = 0; i < expect; i++) {
      assertNotEquals(removeVal, elements[i]);
    }
  }

  @ParameterizedTest
  @MethodSource("providerForRemoveElement")
  void testSlowFastRemoveElement(int[] elements, int removeVal, int expect) {
    var SUT = new SlowFastPointerRemoveElement();

    assertEquals(expect, SUT.removeElement(elements, removeVal));
    for (int i = 0; i < expect; i++) {
      assertNotEquals(removeVal, elements[i]);
    }
  }

  @ParameterizedTest
  @MethodSource("providerForRemoveElement")
  void testArrayShrinkRemoveElement(int[] elements, int removeVal, int expect) {
    var SUT = new ArrayShrinkRemoveElement();

    assertEquals(expect, SUT.removeElement(elements, removeVal));
    for (int i = 0; i < expect; i++) {
      assertNotEquals(removeVal, elements[i]);
    }
  }
}
