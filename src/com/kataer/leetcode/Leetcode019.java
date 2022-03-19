package com.kataer.leetcode;

/**
 * @ClassName Leetcode019
 * @Description: TODO
 * @Author kataer
 * @Date 2021/1/1 11:05
 * @Version V1.0
 **/
public class Leetcode019 {
    public static void main(String[] args) {
        int[] array = new int[]{0, 0, 0};
        System.out.println(canPlaceFlowers(array, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 0;
        int count = 1;//头部增加0，count从1开始
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                count = 0;
            }

            if (count == 3) {
                num++;
                count = 1;
            }
        }
        //末尾增加0
        if (count == 2) {
            num++;
        }
        System.out.println(num);
        return n <= num ? true : false;
    }
}
