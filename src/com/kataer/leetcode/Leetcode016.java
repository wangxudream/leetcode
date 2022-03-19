package com.kataer.leetcode;

import java.util.Arrays;

/**
 * @ClassName Leetcode016
 * @Description: https://leetcode-cn.com/problems/assign-cookies/
 * @Author kataer
 * @Date 2020/12/25 23:46
 * @Version V1.0
 **/
public class Leetcode016 {
    public static void main(String[] args) {
        int[] g = new int[]{3, 3};
        int[] s = new int[]{1, 2, 3};
        System.out.println(findContentChildren(g, s));
        ;
    }

    public static int findContentChildren(int[] g, int[] s) {
        quick_sort(g, 0, g.length - 1);
        quick_sort(s, 0, s.length - 1);
        int count = 0;
        int index = -1;
        for (int i = 0; i < g.length; i++) {
            do {
                index++;
            } while (index < s.length && g[i] > s[index]);

            if (index >= s.length) {
                break;
            } else {
                count++;
            }
        }
        return count;
    }


    public int findContentChildren2(int[] g, int[] s) {
        int child = 0;
        int cookie = 0;
        Arrays.sort(g);  //先将饼干 和 孩子所需大小都进行排序
        Arrays.sort(s);
        while (child < g.length && cookie < s.length) { //当其中一个遍历就结束
            if (g[child] <= s[cookie]) { //当用当前饼干可以满足当前孩子的需求，可以满足的孩子数量+1
                child++;
            }
            cookie++; // 饼干只可以用一次，因为饼干如果小的话，就是无法满足被抛弃，满足的话就是被用了
        }
        return child;
    }

    public static void quick_sort(int[] nums, int begin, int end) {
        if (begin < end) {
            int i = begin, j = end;
            int temp = nums[i];

            while (i < j) {
                while (j > i && nums[j] >= temp) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }

                while (i < j && nums[i] < temp) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = temp;
            quick_sort(nums, begin, i - 1);
            quick_sort(nums, i + 1, end);
        }
    }
}
