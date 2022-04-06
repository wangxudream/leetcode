package com.kataer.leetcode;

public class Leetcode693 {
  public static void main(String[] args) {
    System.out.println(Integer.toBinaryString(3));
    System.out.println(Integer.toBinaryString(4));
    System.out.println(Integer.toBinaryString(7));
    System.out.println(Integer.toBinaryString(8));
  }

  /**
   * 利用binaryString
   *
   * @param n
   * @return
   */
  public static boolean hasAlternatingBits(int n) {
    String binaryString = Integer.toBinaryString(21);
    return !(binaryString.contains("00") || binaryString.contains("11"));
  }

  /**
   * 取模的结果就是二进制最后一位
   *
   * @param n
   * @return
   */
  public static boolean hasAlternatingBits_2(int n) {
    int flag = n % 2;
    int remain = n / 2;
    while (remain > 0) {
      int res = remain % 2;
      if (flag == res) {
        return false;
      }
      //除法是否可以用位运算
      remain /= 2;
      flag = res;
    }
    return true;
  }

  public static boolean hasAlternatingBits_3(int n) {
    int res = n ^ (n >> 1); //全部是1
    return (res & (res + 1)) == 0;//11 & 1000
  }
}
