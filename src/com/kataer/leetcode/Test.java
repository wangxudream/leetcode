package com.kataer.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName Test
 * @Description: TODO
 * @Author kataer
 * @Date 2021/4/16 22:20
 * @Version V1.0
 **/
public class Test {
  public static void main(String[] args) {
    int a = 3; int b=4;
    a = a^b;
    b = a^b;
    a = b^a;
    System.out.println(a);
    System.out.println(b);
  }


}
