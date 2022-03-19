package com.kataer.leetcode;

/**
 * @ClassName Leetcode005
 * @Description: https://leetcode-cn.com/problems/wiggle-subsequence/
 * 摆动序列
 * @Author kataer
 * @Date 2020/12/12 22:27
 * @Version V1.0
 **/
public class Leetcode005 {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 8, 8};
        System.out.println(wiggleMaxLength(ints));
    }
    //找出转折点
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int preDiff = nums[1] - nums[0];
        int res = preDiff == 0 ? 1 : 2;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            //要考虑等于的情况[1,3,3,2]
            if ((preDiff <= 0 && diff > 0) || (preDiff >= 0 && diff < 0)) {
                preDiff = diff;
                res++;
            }
        }

        return res;
    }
}
