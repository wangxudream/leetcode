package com.kataer.leetcode.primary;

/**
 * @ClassName Array_004
 * @Description: https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 * @Author kataer 只出现一次的数字
 * @Date 2020/12/14 13:25
 * @Version V1.0
 * 1、使用hash表
 * 2、排序后判断
 * 3、异或运算(a^0 = a;a^a=0;a^b^a = a^a^b=0^b = b)
 **/
public class Array_004 {

    public static void main(String[] args) {
        int[] ints = new int[]{4, 2, 2};
        System.out.println(singleNumber2(ints));
    }

    //不使用额外的空间
    public static int singleNumber(int[] nums) {
        //排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    //交换
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        int lowIndex = 0;
        for (int i = 1; i < nums.length; i += 2, lowIndex += 2) {
            if (nums[i] != nums[lowIndex]) {
                return nums[lowIndex];
            }
        }
        return nums[nums.length - 1];
    }

    //异或运算 相同为1，不相同为0
    //0101 0101
    public static int singleNumber2(int[] nums) {
//        int ans = nums[0];
//        for (int i = 1; i <nums.length ; i++) {
//            ans ^= nums[i];
//        }
//        return ans;

        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
