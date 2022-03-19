package com.kataer.leetcode;

import java.util.*;

/**
 * @ClassName Leetcode006
 * @Description: https://leetcode-cn.com/problems/contains-duplicate/
 * @Author kataer
 * @Date 2020/12/13 10:58
 * @Version V1.0
 **/
public class Leetcode006 {
    public static void main(String[] args) {
        int[] ints = new int[]{72, 6, 57, 88, 60, 42, 42};
        quick_sort(ints, 0, ints.length - 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    //利用hash表
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //如果重复，add方法返回false
            if (!integerSet.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    //快速排序https://www.runoob.com/w3cnote/quick-sort.html
    //排序后遍历字符串，判断是否有前后相等
    public static void quick_sort(int[] nums, int begin, int end) {
        if (begin < end) {
            int i = begin, j = end;
            //取出nums[i]作为基准
            int temp = nums[i];

            while (i < j) {
                //从右向左寻找小于temp的数
                while (j > i && nums[j] >= temp) {
                    //不符合条件的情况
                    j--;
                }
                //找到小于temp的值，将其置于i处，i++(不用再比较i处)
                if (i < j) {
                    nums[i++] = nums[j];
                }

                //向右寻找大于temp的数
                while (i < j && nums[i] < temp) {
                    i++;
                }
                //找到大于temp的数，将其置于j处
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }

            //一轮遍历结束，i==j，将temp填入,结果为左侧元素全小于temp，右侧元素大于temp
            nums[i] = temp;


            //一轮遍历结束，i左侧是小于temp的数，右侧是小于temp的数
            //对左侧和右侧重复上述步骤
            quick_sort(nums, begin, i - 1);
            quick_sort(nums, i + 1, end);
        }
    }

//    void quicksort(int s[], int l, int r) {
//        if (l < r) {
//            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
//            int i = l, j = r, x = s[l];
//            while (i < j) {
//                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
//                    j--;
//                if (i < j)
//                    s[i++] = s[j];
//
//                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
//                    i++;
//                if (i < j)
//                    s[j--] = s[i];
//            }
//            s[i] = x;
//            quick_sort(s, l, i - 1); // 递归调用
//            quick_sort(s, i + 1, r);
//        }
//    }


}
