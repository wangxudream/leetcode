package com.kataer.leetcode.fast;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
 *
 * @ClassName MaxSubArray
 * @Description: 最大子序列
 * @Author kataer
 * @Date 2021/10/17 18:54
 * @Version V1.0
 **/
public class MaxSubArray {
  public static void main(String[] args) {
    int[] nums = {1,4,-5,100};
    System.out.println(solution(nums));
    //todo 线段树解决
  }

  public static int solution(int[] nums) {
    int pre = 0, maxSum = nums[0];
    for (int num : nums) {
      pre = Math.max(pre + num, num);
      maxSum = Math.max(pre, maxSum);
    }
    return maxSum;
  }
}
