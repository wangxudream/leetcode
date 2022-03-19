package com.kataer.leetcode;

import java.util.HashMap;

/**
 * @ClassName Leetcode009
 * @Description: https://leetcode-cn.com/problems/word-pattern/
 * @Author kataer 单词规律
 * @Date 2020/12/16 12:03
 * @Version V1.0
 * pattern = "abba", str = "dog cat cat dog"
 **/
public class Leetcode009 {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    //自己想的
    public static boolean wordPattern(String pattern, String s) {
        String[] patterns = pattern.split("");
        String[] splits = s.split(" ");
        if (patterns.length != splits.length) {
            return false;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            if (hashMap.containsKey(patterns[i])) {
                if (!splits[i].equals(hashMap.get(patterns[i]))) {
                    return false;
                }
            } else {
                //不同pattern的对应的value不能一致 a = dog b= dog
                if (hashMap.containsValue(splits[i])) {
                    return false;
                }
                hashMap.put(patterns[i], splits[i]);
            }
        }
        return true;
    }

//    public static boolean wordPattern2(String pattern, String s) {
//        String[] patterns = pattern.split("");
//        String[] splits = s.split(" ");
//        if (patterns.length != splits.length) {
//            return false;
//        }
//        HashMap<String, String> pmap = new HashMap<>();
//        HashMap<String, String> smap = new HashMap<>();
//        for (int i = 0; i < patterns.length; i++) {
//            if (!pmap.containsKey(patterns[i])) {
//                pmap.put(patterns[i], splits[i]);
//            } else {
//
//            }
//
//            if (!smap.containsKey(splits[i])) {
//                smap.put(splits[i], patterns[i]);
//            }
//
//
//        }
//    }
}
