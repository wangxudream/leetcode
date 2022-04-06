package com.kataer.leetcode;

/**
 * 1、利用库函数 Integer.bitCount(3)
 * 2、利用与1左移做与运算
 * 3、
 */
public class Leetcode191 {
  public static void main(String[] args) {
    System.out.println(hammingWeight_2(-3));
  }

  /**
   * 循环检查二进制位
   *
   * @param n
   * @return
   */
  public static int hammingWeight(int n) {
    int count = 0;
    //与1左移做与运算
    for (int i = 0; i < 32; i++) {
      if ((n & (1 << i)) != 0) {
        count++;
      }
    }
    return count;
  }

  /**
   * n & (n−1)，其运算结果恰为把 nn 的二进制位中的最低位的 11 变为 00 之后的结果。
   *
   * @param n
   * @return
   */
  public static int hammingWeight_2(int n) {
    int count = 0;
    //与1左移做与运算
    while (n != 0) {
      n &= (n - 1);
      count++;
    }
    return count;
  }
}
