package jp.co.hungtin.algorx.buddystring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuddyStringTest {

  @Test
  void solution() {
      assertTrue(BuddyString.solution("ab", "ba"));
      assertTrue(BuddyString.solution("aa", "aa"));
      assertTrue(BuddyString.solution("aaaaabc", "aaaaacb"));

      assertFalse(BuddyString.solution("ab", "ab"));
  }
}