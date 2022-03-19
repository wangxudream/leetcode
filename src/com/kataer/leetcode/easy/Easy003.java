package com.kataer.leetcode.easy;

/**
 * @ClassName Easy003
 * @Description: TODO
 * @Author kataer
 * @Date 2020/12/21 23:21
 * @Version V1.0
 **/
public class Easy003 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 1, 1};
        int[] sum = runningSum(array);
        for (int i = 0; i < sum.length; i++) {
            System.out.println(sum[i]);
        }
    }

    public static int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            runningSum[i] = sum;
        }
        return runningSum;
    }

    //修改原数组
    public static int[] runningSum2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

}
