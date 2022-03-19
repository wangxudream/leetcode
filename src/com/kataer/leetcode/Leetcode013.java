package com.kataer.leetcode;

/**
 * @ClassName Leetcode013
 * @Description: https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * @Author kataer
 * @Date 2020/12/21 22:11
 * @Version V1.0
 * 使用最小花费爬楼梯  todo
 **/
public class Leetcode013 {
    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i-1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
