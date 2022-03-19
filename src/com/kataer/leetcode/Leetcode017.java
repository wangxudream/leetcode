package com.kataer.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Leetcode017
 * @Description: https://leetcode-cn.com/problems/isomorphic-strings/
 * @Author kataer
 * @Date 2020/12/28 22:48
 * @Version V1.0
 * 同构字符串
 **/
public class Leetcode017 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("aaab", "bbba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<Character, Character>();
        Map<Character, Character> tMap = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            //一对一映射关系
            if ((sMap.containsKey(schar) && sMap.get(schar) != tchar) || (tMap.containsKey(tchar) && tMap.get(tchar) != schar)) {
                return false;
            }
            sMap.put(schar, tchar);
            tMap.put(tchar, schar);
        }
        return true;
    }
}
