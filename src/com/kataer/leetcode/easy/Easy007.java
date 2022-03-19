package com.kataer.leetcode.easy;


/**
 * @ClassName Easy007
 * @Description: https://leetcode-cn.com/problems/palindrome-number/
 * 回文数
 * @Author kataer
 * @Date 2021/1/6 21:32
 * @Version V1.0
 **/
public class Easy007 {
    public static void main(String[] args) {
        System.out.println(isPalindrome2(10));
    }

    //转换成字符串,需额外空间
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = x + "";
        int left, right;
        if (str.length() % 2 == 0) {
            left = (str.length() - 1) / 2;
            right = left + 1;
        } else {
            left = (str.length() - 1) / 2 - 1;
            right = (str.length() - 1) / 2 + 1;
        }

        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    //不适用额外空间
    public static boolean isPalindrome2(int x) {
        //小于0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int rev = 0;
        while (rev < x) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        //rev == x 长度为偶数 ,x == rev/10 长度为奇数的情况
        // 121 0*10+1;12 1*10+2;1
        if (rev == x || x == rev / 10) {
            return true;
        }
        return false;
    }


}

