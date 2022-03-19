package com.kataer.leetcode.primary;

/**
 * @ClassName Array_003
 * @Description: https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * @Author kataer 旋转数组
 * @Date 2020/12/13 21:30
 * @Version V1.0
 **/
public class Array_003 {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate2(ints, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    //每次整体向右移位一次
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 1; i <= k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }

    //循环交换
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;//结束时移动次数等于数组长度
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int pre = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                count++;
                current = next;
            } while (current != start);
        }
    }

}
