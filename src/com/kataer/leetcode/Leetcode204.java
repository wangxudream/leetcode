package com.kataer.leetcode;

import java.util.Arrays;

public class Leetcode204 {
  public static void main(String[] args) {
//    System.out.println(Math.sqrt(Integer.MAX_VALUE));
    System.out.println(46341 * 46341);
    Leetcode204 leetcode204 = new Leetcode204();
    System.out.println(leetcode204.countPrimes(2));
  }

  /**
   * 枚举计算
   *
   * @param n
   * @return
   */
  public int countPrimes(int n) {
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime(i)) count++;
    }
    return count;
  }

  public int countPrimes_2(int n) {
    int[] isPrime = new int[n];
    int count = 0;
    Arrays.fill(isPrime, 1);
    for (int i = 2; i < n; i++) {
      if (isPrime[i] == 1) {
        count++;
        //i*i会超出int范围变成负数
        if ((long) i * i < n) {
          for (int j = i * i; j < n; j += i) {
            isPrime[j] = 0;
          }
        }
      }
    }
    return count;
  }

  public boolean isPrime(int n) {
    //Math.sqrt() 做开方运算
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
