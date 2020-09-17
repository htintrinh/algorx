package jp.co.hungtin.algorx.string;

public class HayStackAndNeedle {
  public int strStr(String haystack, String needle) {
    if (needle == null || needle.equals("")) {
      return 0;
    }

    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      if (inHaystackFromIndex(haystack, needle, i)) {
        return i;
      }
    }

    return -1;
  }

  private boolean inHaystackFromIndex(String hayStack, String needle, int idxInHayStack) {
    for (int i = 0; i < needle.length(); i++) {
      if (hayStack.charAt(i + idxInHayStack) != needle.charAt(i)) {
        return false;
      }
    }

    return true;
  }
}
