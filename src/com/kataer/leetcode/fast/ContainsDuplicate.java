package com.kataer.leetcode.fast;

import java.util.HashSet;

/**
 * @ClassName ContainsDuplicate
 * @Description: 是否存在重复的元素
 * @Author kataer
 * @Date 2021/10/17 16:27
 * @Version V1.0
 **/
public class ContainsDuplicate {
  public static void main(String[] args) {
    //可以排序比较相邻的元素
  }

  public static boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) {
        return true;
      } else {
        set.add(num);
      }
    }
    return false;
  }
}
