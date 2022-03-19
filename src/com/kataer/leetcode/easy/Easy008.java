package com.kataer.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Easy008
 * @Description: https://leetcode-cn.com/problems/valid-parentheses/
 * @Author kataer
 * @Date 2021/1/7 22:15
 * @Version V1.0
 **/
public class Easy008 {
    public static void main(String[] args) {
        System.out.println('0'-48);
    }

    public static boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                deque.offerLast(ch);
            } else {
                if (ch == ')') {
                    //")"
                    if (deque.isEmpty() || deque.pollLast() != '(') {
                        return false;
                    }
                } else if (ch == ']') {
                    if (deque.isEmpty() || deque.pollLast() != '[') {
                        return false;
                    }
                } else if (ch == '}') {
                    if (deque.isEmpty() || deque.pollLast() != '{') {
                        return false;
                    }
                }
            }
        }
        //"(("
        if (!deque.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isValid2(String s) {
        if ("".equals(s)) {
            return true;
        }
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                deque.push(ch);
            } else {
                if (ch == ')') {
                    //")"
                    if (deque.isEmpty() || deque.pop() != '(') {
                        return false;
                    }
                } else if (ch == ']') {
                    if (deque.isEmpty() || deque.pop() != '[') {
                        return false;
                    }
                } else if (ch == '}') {
                    if (deque.isEmpty() || deque.pop() != '{') {
                        return false;
                    }
                }
            }
        }
        //"(("
        if (!deque.isEmpty()) {
            return false;
        }
        return true;
    }
}
