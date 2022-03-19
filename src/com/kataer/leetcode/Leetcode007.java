package com.kataer.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Leetcode007
 * @Description: https://leetcode-cn.com/problems/group-anagrams/
 * @Author kataer 字母异位词分组
 * @Date 2020/12/14 11:06
 * @Version V1.0
 **/
public class Leetcode007 {
    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams2(strings);
        System.out.println(lists);
    }

    //排序后的String作为key(异位词排序后结果一致)
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringListMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (stringListMap.containsKey(strs[i])) {
                stringListMap.get(strs[i]).add(strs[i]);
            } else {
                String s = sortChar(strs[i]);
                if (stringListMap.containsKey(s)) {
                    stringListMap.get(s).add(strs[i]);
                } else {
                    List<String> stringList = new ArrayList<>();
                    stringList.add(strs[i]);
                    stringListMap.put(s, stringList);
                }
            }

        }
        List<List<String>> listArrayList = new ArrayList<>();
        for (String s : stringListMap.keySet()) {
            listArrayList.add(stringListMap.get(s));
        }
        return listArrayList;
    }

    //统计每个字母出现的次数(异位词每个字母出现的次数一致)
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> stringListMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] counts = new int[26];
            //统计每个字母出现的次数
            for (int j = 0; j < strs[i].length(); j++) {
                counts[strs[i].charAt(j) - 'a']++;
            }
            //不能直接拼接数字，考虑ab 11+0 和1+10的区别
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < counts.length; j++) {
                if (counts[j] != 0) {
                    builder.append((char) ('a' + j));
                    builder.append(counts[j]);
                }
            }
            String str = builder.toString();
            //
            List<String> orDefault = stringListMap.getOrDefault(str, new ArrayList<String>());
            orDefault.add(strs[i]);
            stringListMap.put(str, orDefault);
        }
        return new ArrayList<List<String>>(stringListMap.values());
    }

    public static String sortChar(String str) {
        if (str.length() <= 1) {
            return str;
        }
        char[] chars = str.toCharArray();
        sort(chars, 0, chars.length - 1);
        return new String(chars);
    }

    //排序
    public static void sort(char[] chars, int begin, int end) {
        if (begin < end) {
            int i = begin, j = end;
            char temp = chars[i];
            while (i < j) {
                while (chars[j] >= temp && i < j) {
                    j--;
                }
                if (i < j) {
                    chars[i++] = chars[j];
                }

                while (chars[i] < temp && i < j) {
                    i++;
                }

                if (i < j) {
                    chars[j--] = chars[i];
                }
            }
            chars[i] = temp;
            sort(chars, begin, i - 1);
            sort(chars, i + 1, end);
        }
    }
}
