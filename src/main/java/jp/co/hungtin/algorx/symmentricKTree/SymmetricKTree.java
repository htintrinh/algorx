package jp.co.hungtin.algorx.symmentricKTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SymmetricKTree {
  public static void printTree(Node node) {
    var primaryQueue = new LinkedList<Node>();
    var secondaryQueue = new LinkedList<Node>();

    primaryQueue.add(node);
    while (!primaryQueue.isEmpty() || !secondaryQueue.isEmpty()) {
      traceNodeFromQueueToQueue(primaryQueue, secondaryQueue);
      System.out.println("");
      traceNodeFromQueueToQueue(secondaryQueue, primaryQueue);
      System.out.println("");
    }
  }

  public static void traceNodeFromQueueToQueue(Queue<Node> fromQueue, Queue<Node> toQueue) {
    while (!fromQueue.isEmpty()) {
      var currentNode = fromQueue.poll();
      System.out.printf("%d ", currentNode.getValue());
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
    Node leftChild = Node.of(3, List.of(Node.of(9), Node.of(4), Node.of(1)));
    Node rightChild = Node.of(3, List.of(Node.of(1), Node.of(4), Node.of(9)));

    Node node = Node.of(1);
    node.setChildren(List.of(leftChild, rightChild));

    printTree(node);
  }

  // return if the tree node is symmetric or not
  public static boolean solution(Node node) {
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
