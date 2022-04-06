package com.kataer.leetcode;

import java.util.*;

public class Leetcode954 {
  public static void main(String[] args) {
    int[] arr = {4, -2, 2, -4};
    System.out.println(canReorderDoubled_2(arr));
  }

  /**
   * 自己做出来的
   *
   * @param arr
   * @return
   */
  public static boolean canReorderDoubled(int[] arr) {
    Arrays.sort(arr);
    Map<Integer, Integer> dataMap = new HashMap<>();
    for (int i : arr) {
      Integer count = dataMap.get(i);
      if (count == null) {
        count = 1;
      } else {
        count += 1;
      }
      dataMap.put(i, count);
    }
    //0的个数不是偶数则不符合条件
    if (dataMap.getOrDefault(0, 0) % 2 != 0) {
      return false;
    }
    for (int i = 0; i < arr.length; i++) {
      int num = arr[i];
      //减去本身
      Integer count = dataMap.get(num);
      if (count == 0) {
        continue;
      }
      dataMap.put(num, --count);
      int sup;
      if (num < 0) {
        if (num % 2 != 0) {
          return false;
        }
        sup = num / 2;
      } else {
        sup = num * 2;
      }
      Integer supCount = dataMap.get(sup);
      if (supCount == null || supCount == 0) {
        return false;
      } else {
        dataMap.put(sup, --supCount);
      }
    }
    return true;
  }

  /**
   * 官方解法
   *
   * @param arr
   * @return
   */
  public static boolean canReorderDoubled_2(int[] arr) {
    Map<Integer, Integer> data = new HashMap<>();
    //保存每个数字出现的次数
    for (int i : arr) {
      //getOrDefault
      data.put(i, data.getOrDefault(i, 0) + 1);
    }
    //有零则0的个数为偶数
    if (data.getOrDefault(0, 0) % 2 != 0) {
      return false;
    }
    //所有出现的key
    ArrayList<Integer> keys = new ArrayList<>(data.keySet());
    // -2 -4 2 4 abs排序后可以避免除法
    Collections.sort(keys, Comparator.comparingInt(Math::abs));
    //相比遍历原数组，可以避免遍历重复的只
    for (Integer key : keys) {
      int sup = key * 2;
      int count = data.get(key);
      //2x 的数量少于x 的数量 会出现 0 < 0的情况
      if (count == 0) {
        continue;
      }
      if (data.getOrDefault(sup, 0) < count) {
        return false;
      }
      //避免遍历[-2,2,-4,4] 到 getOrDefault 官方解法
//      data.put(sup, data.getOrDefault(sup, 0) - data.get(key));
      data.put(sup, data.get(sup) - data.get(key));
    }
    return true;
  }
}
