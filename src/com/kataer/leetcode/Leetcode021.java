package com.kataer.leetcode;

/**
 * @ClassName Leetcode021
 * @Description: TODO
 * @Author kataer
 * @Date 2021/1/4 13:07
 * @Version V1.0
 **/
public class Leetcode021 {
    public static void main(String[] args) {
        System.out.println(fib2(4));
    }

    //动态规划，简化为滚动数组
    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    //前两个数之和
    public static int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 1;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            count = p + q;
            p = q;
            //关键步骤
            q = count;
        }
        return count;
    }
}
