package com.kataer.leetcode.easy;

/**
 * @ClassName Easy002
 * @Description: https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @Author kataer
 * @Date 2020/12/12 15:52
 * @Version V1.0
 **/
public class Easy002 {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords3("abcdef", 2));
    }


    public static String reverseLeftWords3(String s, int n) {
        String str1 = s.substring(0,n);
        String str2 = s.substring(n);
        return str2+str1;
    }


    //找出规律
    public static String reverseLeftWords2(String s, int n) {
        int len = s.length();
        char[] newStr = new char[len];
        for (int i = 0; i < len; i++) {
            if (i < n) {
                newStr[i + len - n] = s.charAt(i);
            } else {
                newStr[i - n] = s.charAt(i);
            }
        }
        return new String(newStr);
    }

    //字符串左移n次
    public static String reverseLeftWords1(String s, int n) {
        char[] chars = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            char temp = chars[0];
            for (int j = 1; j < s.length(); j++) {
                chars[j - 1] = chars[j];
            }
            chars[s.length()-1] = temp;
        }
        return new String(chars);
    }
}
