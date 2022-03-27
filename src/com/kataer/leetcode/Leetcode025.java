package com.kataer.leetcode;

/**
 * https://leetcode-cn.com/problems/find-missing-observations/
 */
public class Leetcode025 {
  public static void main(String[] args) {
    int[] rolls = {1, 2, 3, 4};
    int[] ints = missingRolls_2(rolls, 6, 4);
    for (int anInt : ints) {
      System.out.println(anInt);
    }
  }

  public static int[] missingRolls(int[] rolls, int mean, int n) {
    int m = rolls.length;
    int sum = mean * (m + n);
    int rollsSum = 0;
    //可以利用减法
    for (int roll : rolls) {
      rollsSum += roll;
    }
    int leftSum = sum - rollsSum;
    if (leftSum < n || leftSum > 6 * n) {
      return new int[0];
    }
    int k = leftSum / n;
    //可以使用取模代替
    int retain = leftSum - k * n;
    int[] res = new int[n];
    //求出的是左边尽量打的情况
    for (int i = 0; i < n; i++) {
      if (retain > 0) {
        if (retain <= 6 - k) {
          res[i] = k + retain;
          retain = 0;
        } else {
          res[i] = 6;
          retain = retain - (6 - k);
        }
      } else {
        res[i] = k;
      }
    }
    return res;
  }

  public static int[] missingRolls_2(int[] rolls, int mean, int n) {
    int m = rolls.length;
    int sum = mean * (m + n);
    int missSum = sum;
    for (int roll : rolls) {
      missSum -= roll;
    }
    if (missSum < n || missSum > 6 * n) {
      return new int[0];
    }
    int avg = missSum / n, remain = missSum % n;
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = avg + (i < remain ? 1 : 0);
    }
    return res;
  }
}
