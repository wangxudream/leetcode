package com.kataer.leetcode.easy;

/**
 * @ClassName Easy001
 * @Description: https://leetcode-cn.com/problems/richest-customer-wealth/
 * @Author kataer
 * @Date 2020/12/12 15:16
 * @Version V1.0
 **/
public class Easy001 {
    public static void main(String[] args) {
//        int[][] ints = new int[][]{[1,2,3],[3,2,1]}
    }

    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
