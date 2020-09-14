package jp.co.hungtin.algorx.benchmarkstream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class BenchmarkStreamApi {
  private static final Long MAX_LIST_SIZE = 10_000_000L;

  public static Long getSmallestNumber1(List<Long> nums) {
    if (nums == null || nums.size() <= 0) {
      throw new RuntimeException("No min number");
    }
    Long minValue = nums.get(0);
    for (Long num : nums) {
      if (num <= minValue) {
        minValue = num;
      }
    }
    return minValue;
  }

  public static Long getSmallestNumber2(List<Long> list) {
    return list.stream()
        .reduce((a, b) -> a <= b ? a : b)
        .orElseThrow(() -> new RuntimeException("No min number"));
  }

  public static Long getSmallestNumber3(List<Long> list) {
    return list.parallelStream()
        .reduce((a, b) -> a <= b ? a : b)
        .orElseThrow(() -> new RuntimeException("No min number"));
  }

  public static void main(String[] args) {
    List<Long> testList = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < MAX_LIST_SIZE; i++) {
      testList.add(random.nextLong());
    }

    benchMarkFunction(() -> getSmallestNumber1(testList), "Sequence compare");
    benchMarkFunction(() -> getSmallestNumber2(testList), "Stream reduce");
    benchMarkFunction(() -> getSmallestNumber3(testList), "Parallel stream reduce");
  }

  public static void benchMarkFunction(Supplier<Long> f, String name) {
    long startTime = System.currentTimeMillis();
    f.get();
    long endTime = System.currentTimeMillis();
    System.out.printf("Total run time for %s: %d%n \n", name, endTime - startTime);
  }

  private static class Person {}
}
