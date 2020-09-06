package jp.co.hungtin.algorx.symmentricKTree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertSame;

class SymmetricKTreeTest {

  private static Stream<Arguments> providerForSymmetricKTree() {
    var leftChild =
        SymmetricKTree.Node.of(
            3, of(SymmetricKTree.Node.of(9), SymmetricKTree.Node.of(4), SymmetricKTree.Node.of(1)));
    var rightChild =
        SymmetricKTree.Node.of(
            3, of(SymmetricKTree.Node.of(1), SymmetricKTree.Node.of(4), SymmetricKTree.Node.of(9)));

    var symmetricNode = SymmetricKTree.Node.of(1);
    symmetricNode.setChildren(of(leftChild, rightChild));

    return Stream.of(
        Arguments.of(symmetricNode, true),
        Arguments.of(SymmetricKTree.Node.of(1), true),
        Arguments.of(
            SymmetricKTree.Node.of(1, of(SymmetricKTree.Node.of(2), SymmetricKTree.Node.of(3))),
            false));
  }

  private static Stream<Arguments> providerForIsSymmetricList() {
    return Stream.of(
        Arguments.of(List.of(1, 3, 4, 3, 1), true),
        Arguments.of(List.of(1), true),
        Arguments.of(List.of(1, 1), true),
        Arguments.of(List.of(1, 2), false),
        Arguments.of(List.of(1, 2, 3, 1, 2), false),
        Arguments.of(List.of(1, 2, 3, 4, 5), false));
  }

  @ParameterizedTest
  @MethodSource("providerForSymmetricKTree")
  void solutionShouldReturnExpectResult(SymmetricKTree.Node tree, boolean expect) {
    assertSame(expect, SymmetricKTree.solution(tree));
  }

  @ParameterizedTest
  @MethodSource("providerForIsSymmetricList")
  void isSymmetricList(List<Integer> numbers, boolean expect) {
    assertSame(expect, SymmetricKTree.isSymmetricList(numbers));
  }
}
