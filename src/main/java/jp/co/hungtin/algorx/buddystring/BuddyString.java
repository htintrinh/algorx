package jp.co.hungtin.algorx.buddystring;

import java.util.ArrayList;
import java.util.HashSet;

public class BuddyString {
  public static boolean solution(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    }

    if (a.equals(b) && hasDuplicateChar(a)) {
      return true;
    }

    var mismatchIdx = new ArrayList<Integer>();
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        mismatchIdx.add(i);
      }
    }

    if (mismatchIdx.size() != 2) {
      return false;
    }
    var mismatchIdx1 = mismatchIdx.get(0);
    var mismatchIdx2 = mismatchIdx.get(1);

    return a.charAt(mismatchIdx1) == b.charAt(mismatchIdx2)
        && a.charAt(mismatchIdx2) == b.charAt(mismatchIdx1);
  }

  private static boolean hasDuplicateChar(String a) {
    var charSet = new HashSet<Character>();
    for (Character c : a.toCharArray()) {
      charSet.add(c);
    }

    return charSet.size() < a.length();
  }
}
