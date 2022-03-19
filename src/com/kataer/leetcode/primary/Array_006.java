package com.kataer.leetcode.primary;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @ClassName Array_005
 * @Description: https://leetcode-cn.com/problems/remove-vowels-from-a-string/
 * @Author kataer
 * @Date 2020/12/23 11:38
 * @Version V1.0
 **/

public class Array_006 {
  public static void main(String[] args) {
    int[] nums1 = new int[]{1, 2, 2, 2, 3, 1}, nums2 = new int[]{2, 3, 2};
    int[] intersect = intersect(nums1, nums2);
//    int[] intersect = intersect_2(nums1, nums2);
    System.out.println(Arrays.toString(intersect));
  }

  //利用map的计数
  public static int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int i : nums1) {
      countMap.put(i, countMap.getOrDefault(i, 0) + 1);
    }

    ArrayList<Integer> undp = new ArrayList<>();
    for (int i : nums2) {
      Integer count = countMap.get(i);
      if (count != null && count > 0) {
        undp.add(i);
        countMap.put(i, --count);
      }
    }
    int[] ints = new int[undp.size()];
    for (int i = 0; i < undp.size(); i++) {
      ints[i] = undp.get(i);
    }
    return ints;
  }

  public static int[] intersect_2(int[] nums1, int[] nums2) {
    ArrayList<Integer> undp = new ArrayList<>();
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int index1 = 0;
    int index2 = 0;
    while (index1 < nums1.length && index2 < nums2.length) {
      if (nums1[index1] == nums2[index2]) {
        undp.add(nums1[index1]);
        index1++;
        index2++;
      } else {
        if (nums1[index1] < nums2[index2]) {
          index1++;
        } else {
          index2++;
        }
      }
    }
    int[] ints = new int[undp.size()];
    for (int i = 0; i < undp.size(); i++) {
      ints[i] = undp.get(i);
    }
    return ints;
  }

}
