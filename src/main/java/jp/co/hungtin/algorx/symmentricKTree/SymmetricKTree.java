package jp.co.hungtin.algorx.symmentricKTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SymmetricKTree {
  public static void printTree(Node node) {
    var primaryQueue = new LinkedList<Node>();
    var secondaryQueue = new LinkedList<Node>();

    primaryQueue.add(node);
    while (!primaryQueue.isEmpty() || !secondaryQueue.isEmpty()) {
      traceNodeFromQueueToQueue(primaryQueue, secondaryQueue, n -> System.out.printf("%d ", n.getValue()));
      System.out.println("");
      traceNodeFromQueueToQueue(secondaryQueue, primaryQueue, n -> System.out.printf("%d ", n.getValue()));
      System.out.println("");
    }
  }

  public static void traceNodeFromQueueToQueue(Queue<Node> fromQueue, Queue<Node> toQueue, Consumer<Node> action) {
    while (!fromQueue.isEmpty()) {
      var currentNode = fromQueue.poll();
      action.accept(currentNode);
      var children = currentNode.getChildren();
      if (children != null) {
        toQueue.addAll(children);
      }
    }
  }

  public static List<Node> randomListNode(int size) {
    return Stream.iterate(0, i -> i + 1)
        .limit(size)
        .map(idx -> Node.of(ThreadLocalRandom.current().nextInt(100)))
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    var leftChild = Node.of(3, List.of(Node.of(9), Node.of(4), Node.of(1)));
    var rightChild = Node.of(3, List.of(Node.of(1), Node.of(4), Node.of(9)));

    var node = Node.of(1);
    node.setChildren(List.of(leftChild, rightChild));

    printTree(node);
  }

  public static boolean isSymmetricList(List<Integer> numbers) {
    if (numbers.size() < 2) {
      return true;
    }

    for (int i = 0, j = numbers.size() - 1; i <= j; i++, j--) {
      if(numbers.get(i) != numbers.get(j)) {
        return false;
      }
    }

    return true;
  }

  // return if the tree node is symmetric or not
  public static boolean solution(Node node) {
    if (node.getChildren() == null || node.getChildren().size() == 0) {
      return true;
    }
    var primaryQueue = new LinkedList<Node>();
    var secondaryQueue = new LinkedList<Node>();
    primaryQueue.add(node);

    while (!primaryQueue.isEmpty() || !secondaryQueue.isEmpty()) {
      var childrenNodeValues = new ArrayList<Integer>();
      traceNodeFromQueueToQueue(primaryQueue, secondaryQueue, n -> childrenNodeValues.add(n.value));
      if (!isSymmetricList(childrenNodeValues)) {
        return false;
      }

      var childrenNodeValues2 = new ArrayList<Integer>();
      traceNodeFromQueueToQueue(secondaryQueue, primaryQueue, n -> childrenNodeValues2.add(n.value));
      if (!isSymmetricList(childrenNodeValues2)) {
        return false;
      }
    }

    return true;
  }

  static class Node {
    private int value;
    private List<Node> children;

    private Node(int value) {
      this.value = value;
    }

    private Node(int value, List<Node> children) {
      this.value = value;
      this.children = children;
    }

    public static Node of(int value) {
      return new Node(value);
    }

    public static Node of(int value, List<Node> children) {
      return new Node(value, children);
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public List<Node> getChildren() {
      return children;
    }

    public void setChildren(List<Node> children) {
      this.children = children;
    }
  }
}
