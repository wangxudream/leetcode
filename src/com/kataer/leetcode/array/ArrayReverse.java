package com.kataer.leetcode.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName ArrayReverse
 * @Description: TODO
 * @Author kataer
 * @Date 2021/10/23 23:08
 * @Version V1.0
 **/
public class ArrayReverse {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};
    System.out.println(Arrays.toString(nums));
    reverse(nums, 1, 2);
    System.out.println(Arrays.toString(nums));
    System.out.println(print(nums));
  }

  public static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  public static String print(int nums[]) {
    if (nums == null) {
      return "null";
    }
    int iMax = nums.length - 1;
    if (iMax == -1) {
      return "[]";
    }
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    for (int i = 0; ; i++) {
      builder.append(nums[i]);
      if (i == iMax) {
        return builder.append("]").toString();
      }
      builder.append(",");
    }
  }

}
