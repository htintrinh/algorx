package jp.co.hungtin.algorx.duplicate;

public class SortedArrayDuplication {
  /**
   * Leetcode solution
   *
   * @param nums sorted integer array
   * @return length of sub rearrange array that NOT contains duplicated elements
   */
  public static int consolidateDuplicatedArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        i++;
        nums[i] = nums[j];
      }
    }

    return i + 1;
  }
}
