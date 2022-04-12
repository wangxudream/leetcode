package com.kataer.leetcode;

/**
 * 统计各位数字都不同的数字个数
 */
public class Leetcode357 {
  public static void main(String[] args) {
    System.out.println(countNumbersWithUniqueDigits(3));
  }

  public static int countNumbersWithUniqueDigits(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 10;
    }
    int count = 10;
    for (int j = 2; j <= n; j++) {
      int partCount = 9;
      int remain = 9;
      for (int i = 1; i < j; i++) {
        partCount *= remain;
        remain--;
      }
      count += partCount;
    }
    return count;
  }
}
