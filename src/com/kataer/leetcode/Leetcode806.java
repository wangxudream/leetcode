package com.kataer.leetcode;

public class Leetcode806 {
  public static void main(String[] args) {
    int[] widths = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    String s = "aaaaaaaaaa";
    int[] ints = numberOfLines(widths, s);
    for (int i = 0; i < ints.length; i++) {
      System.out.println(ints[i]);
    }
  }

  public static int[] numberOfLines(int[] widths, String s) {
    int[] res = new int[2];
    if (s.length() == 0) return res;
    char[] chars = s.toCharArray();
    int width = 0;
    int line = 1;
    for (char aChar : chars) {
      width += widths[aChar - 'a'];
      if (width > 100) {
        line++;
        width = widths[aChar - 'a'];
      }
    }
    res[0] = line;
    res[1] = width;
    return res;
  }
}
