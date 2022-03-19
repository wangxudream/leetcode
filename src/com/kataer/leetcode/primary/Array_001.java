package com.kataer.leetcode.primary;

/**
 * @ClassName Array_001
 * @Description: 删除排序数组中的重复项
 * @Author kataer
 * @Date 2020/12/11 19:49
 * @Version V1.0
 **/
public class Array_001 {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,2,3};
//        System.out.println(removeDuplicates(ints));
//        System.out.println(removeDuplicates(ints));
        System.out.println(dubbleIndex(ints));
    }

    //自己想出来的
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int preNum = nums[0];
        int difCount = 1;
        int commonCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (preNum == nums[i]) {
                //元素向前移动
                for (int j = i; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                commonCount++;
            } else {
                preNum = nums[i];
                difCount++;
            }

            if ((difCount + commonCount) == nums.length) {
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(">>>>" + nums[i]);
        }
        return difCount;
    }


    //双指针(快慢指针)
    public static int dubbleIndex(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slowIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[slowIndex] != nums[i]) {
                //慢指针前进
                slowIndex++;
                //交换两指针位置元素
                nums[slowIndex] = nums[i];
            }
            //慢指针不动
            //快指针前进
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(">>>>" + nums[i]);
        }
        return slowIndex + 1;
    }
}
