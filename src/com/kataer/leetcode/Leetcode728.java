package com.kataer.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode728 {
  public static void main(String[] args) {
    System.out.println(selfDividingNumbers(51, 85));
  }

  public static List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> res = new ArrayList<>();
    for (int i = left; i <= right; i++) {
      int flag;
      int data = i;
      boolean add = true;
      do {
        flag = data % 10;
        if (flag == 0) {
          add = false;
          break;
        }
        if (i % flag != 0) {
          add = false;
          break;
        }
        data /= 10;
      } while (data > 0);
      if (add) {
        res.add(i);
      }
    }
    return res;
  }

}
