package com.kataer.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Leetcode021
 * @Description: https://leetcode-cn.com/problems/summary-ranges/
 * @Author kataer
 * @Date 2021/1/4 13:07
 * @Version V1.0
 * 汇总区间
 **/
public class Leetcode022 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges2(nums));
    }

    //自己想的
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        } else if (nums.length == 1) {
            list.add(nums[0] + "");
            return list;
        }
        int slow = 0;
        int fast;
        for (fast = 1; fast < nums.length; fast++) {
            //不符合条件
            if (nums[fast] != (nums[fast - 1] + 1)) {
                StringBuilder temp = new StringBuilder();
                //长度不大于1
                if (slow != (fast - 1)) {
                    //使用自定义builder快于编译器优化的builder
                    temp.append(nums[slow]).append("->").append(nums[fast - 1]);
                    list.add(temp.toString());
                } else {
                    temp.append(nums[slow]);
                    list.add(temp.toString());
                }
                //
                slow = fast;
            }

        }

        StringBuilder temp = new StringBuilder();
        if (slow != (fast - 1)) {
            temp.append(nums[slow]).append("->").append(nums[fast - 1]);
            list.add(temp.toString());
        } else {
            temp.append(nums[slow]);
            list.add(temp.toString());
        }
        return list;
    }

    //官方解答
    public static List<String> summaryRanges2(int[] nums) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            //慢指针
            int low = i;

            i++;
            //符合条件
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            //退出时i位于区间后一个元素
            //快指针
            int high = i - 1;
//            StringBuilder builder = new StringBuilder(nums[low]); 错误的构造方法，该构造方法指定容量
            StringBuilder builder = new StringBuilder(Integer.toString(nums[low]));
            if (low < high) {
                builder.append("->").append(nums[high]);
            }
            list.add(builder.toString());
        }
        return list;
    }
}
