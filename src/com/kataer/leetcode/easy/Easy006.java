package com.kataer.leetcode.easy;

/**
 * @ClassName Easy006
 * @Description: TODO
 * @Author kataer
 * @Date 2021/1/2 22:22
 * @Version V1.0
 **/

/**
 * @ClassName Array_005
 * @Description: https://leetcode-cn.com/problems/remove-vowels-from-a-string/
 * @Author kataer
 * @Date 2020/12/23 11:38
 * @Version V1.0
 **/
public class Easy006 {
    public static void main(String[] args) {

    }

    public String removeVowels(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            switch (cur) {
                case 'a':
                    break;
                case 'e':
                    break;
                case 'i':
                    break;
                case 'o':
                    break;
                case 'u':
                    break;
                default:
                    builder.append(cur);
            }
        }
        return builder.toString();

    }
}
