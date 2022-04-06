package com.kataer.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * todo 
 */
public class leetcode420 {
  public static void main(String[] args) {

  }

  public int strongPasswordChecker(String password) {
    char[] chars = password.toCharArray();
    //char数组排序
    Arrays.sort(chars);
    //记录每个元素的重复次数
    Map<Character, Integer> countMap = new HashMap<>();
    //判断是否包含数字和大小写字母
    boolean hasAllElement = false;
    boolean hasDuplicate = false;
    boolean hasNum = false;
    boolean hasUper = false;
    boolean hasLow = false;
    for (char p : chars) {
      if (p <= 9) {
        hasNum = true;
      }
      if ('a' <= p && p <= 'z') {
        hasLow = true;
      }
      if ('A' <= p && p <= 'Z') {
        hasUper = true;
      }
      //记录次数
      countMap.put(p, countMap.getOrDefault(p, 0) + 1);
    }
    //
    hasAllElement = hasNum && hasLow && hasUper;
    int noElementCount = 0;
    if (!hasNum) {
      noElementCount++;
    }
    if (!hasLow) {
      noElementCount++;
    }
    if (!hasUper) {
      noElementCount++;
    }
    //处理连续需要的操作次数
    int replaceCount = 0;
    for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
      if (entry.getValue() >= 3) {
        replaceCount += (entry.getValue() / 3);
      }
    }
    //对长度进行判断
    int len = chars.length;
    if (len < 6) {
      return 6 - len + replaceCount;
    }
    //合适长度
    if (len <= 20) {
      if (replaceCount >= 3) {
        return replaceCount;
      } else {
        return Math.max(replaceCount, noElementCount);
      }
    }
    //长度超出
    if (len > 20) {
      if (replaceCount >= 3) {
        return len - 20;
      } else {
        return len - 20 + replaceCount;
      }
    }
    return 0;
  }
}
