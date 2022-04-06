package com.kataer.leetcode.array;

public class BinarySearch {
  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 3, 5, 6, 7, 8};
    int target = 4;
    System.out.println(binarySearch(arr, target));
  }

  public static int binarySearch(int[] arr, int target) {
    int len = arr.length;
    int left = 0, right = len - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      System.out.println("left :" + left + " right :" + right + " mid :" + mid);
      if (arr[mid] == target) {
        return mid;
      }
      if (arr[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
