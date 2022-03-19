package com.kataer.leetcode;

/**
 * @ClassName Leetcode015
 * @Description: https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @Author kataer
 * @Date 2020/12/23 10:22
 * @Version V1.0
 * 字符串中的第一个唯一字符
 **/
public class Leetcode015 {
    public static void main(String[] args) {
        Leetcode015 leetcode015 = new Leetcode015();
        System.out.println(leetcode015.firstUniqChar2("leetcode"));
    }

    //自己想的，基于双重遍历
    public int firstUniqChar(String s) {
        boolean[] appear = new boolean[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (!appear[cur - 'a']) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] == cur) {
                        appear[cur - 'a'] = true;
                        break;
                    }
                }
                if (!appear[cur - 'a']) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char cur = chars[i];
            count[cur - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char cur = chars[i];
            if (count[cur - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
