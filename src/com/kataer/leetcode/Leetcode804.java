package com.kataer.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode804 {
  public static void main(String[] args) {

  }

  public static int uniqueMorseRepresentations(String[] words) {
    String[] codes = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    Set<String> hashSet = new HashSet<>();
    for (String word : words) {
      StringBuilder builder = new StringBuilder();
      for (char c : word.toCharArray()) {
        builder.append(codes[c - 'a']);
      }
      hashSet.add(builder.toString());
    }
    return hashSet.size();
  }
}
