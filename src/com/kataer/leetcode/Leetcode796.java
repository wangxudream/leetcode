package com.kataer.leetcode;

/**
 * 将字符串的旋转理解成拼接
 */
public class Leetcode796 {
  public static void main(String[] args) {
    System.out.println(rotateString("abcd", "bcda"));
  }

  public static boolean rotateString(String s, String goal) {
    if (s.length() != goal.length()) {
      return false;
    }
    String append = s + s;
    return append.contains(goal);
  }
}
