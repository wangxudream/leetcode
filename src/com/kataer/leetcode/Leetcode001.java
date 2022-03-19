package com.kataer.leetcode;

/**
 * @ClassName Leetcode001
 * @Description: 整数反转
 * @Author kataer
 * @Date 2020/12/10 19:08
 * @Version V1.0
 * https://leetcode-cn.com/problems/reverse-integer/
 **/
public class Leetcode001 {
    public static void main(String[] args) {
        System.out.println(reverse(2147483647));
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10) && pop < -8) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
