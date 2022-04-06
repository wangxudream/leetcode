package com.kataer.leetcode;

/**
 * 区域和检索 - 数组可修改
 * 1、分块处理
 * 2、线段树
 */
public class Leetcode307 {
  public static void main(String[] args) {
    int[] array = new int[]{0,9,5,7,3};
    NumArray numArray = new NumArray(array);
    System.out.println(numArray.sumRange(2, 4));
  }

 public static class NumArray {
    private int[] data;
    private int size;
    private int[] sum;

    public NumArray(int[] nums) {
      this.data = nums;
      //直接舍弃余数
      int len = nums.length;
      this.size = (int) Math.sqrt(len);
      // n/size 向上取整
      sum = new int[(len + size - 1) / size];
      //求出每个分段的和
      for (int i = 0; i < len; i++) {
        sum[i / size] += nums[i];
      }
    }

    public void update(int index, int val) {
      sum[index / size] += val - data[index];
      data[index] = val;
    }

    public int sumRange(int left, int right) {
      int range1 = left / size;
      int range2 = right / size;
      int m1 = left % size;
      int m2 = right % size;
      if (range1 == range2) {
        int sum = 0;
        for (int i = m1; i <= m2; i++) {
          sum += data[range1 * size + i];
        }
        return sum;
      }
      //左边部分
      int sumLeft = 0;
      for (int i = m1; i < size; i++) {
        sumLeft += data[range1 * size + i];
      }
      //中间部分
      int sumMiddle = 0;
      for (int i = range1 + 1; i < range2; i++) {
        sumMiddle += sum[i];
      }
      //右边部分
      int sumRight = 0;
      for (int i = 0; i <= m2; i++) {
        sumRight += data[range2 * size + i];
      }
      return sumLeft + sumMiddle + sumRight;
    }
  }
}
