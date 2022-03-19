package com.kataer.leetcode;

/**
 * @ClassName Leetcode008
 * @Description: https://leetcode-cn.com/problems/monotone-increasing-digits/
 * @Author kataer 单调递增的数字
 * @Date 2020/12/15 20:30
 * @Version V1.0
 **/
public class Leetcode008 {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits2(332));
    }

    //(自己想的)超出时间限制
    public static int monotoneIncreasingDigits(int N) {
        for (int i = N; i >= 0; i--) {
            int num = i;
            int pre = i % 10;
            boolean isTrue = true;
            while (num > 0) {
                int current = num % 10;
                num /= 10;
                if (current > pre) {
                    isTrue = false;
                    break;
                }
                pre = current;
            }
            if (isTrue) {
                return i;
            }
        }
        return 0;
    }

    //贪心
    public static int monotoneIncreasingDigits2(int N) {
        char[] chars = Integer.toString(N).toCharArray();
        int index = 1;
        while (index < chars.length && chars[index - 1] <= chars[index]) {
            index++;
        }

        //本身符合index会越界
        if (index < chars.length) {
            while (index > 0 && chars[index - 1] > chars[index]) {
                chars[index - 1] = (char) (chars[index - 1] - 1);
                index--;
            }
            for (int i = index + 1; i < chars.length; i++) {
                chars[i] = '9';
            }
        }
        return Integer.parseInt(new String(chars));
    }


}
