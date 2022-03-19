package com.kataer.leetcode;

/**
 * @ClassName Leetcode002
 * @Description: https://leetcode-cn.com/problems/lemonade-change/
 * @Author kataer
 * @Date 2020/12/10 19:36
 * @Version V1.0
 **/
public class Leetcode002 {
    public static void main(String[] args) {
        int[] bills = new int[]{5, 5,5, 10, 20};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        int[] money = new int[2];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                money[0]++;
            } else if (bills[i] == 10) {
                if (money[0] <= 0) {
                    return false;
                } else {
                    money[0]--;
                    money[1]++;
                }
            } else {
                //优先使用10+5找零的方式
                if (money[0] > 0 && money[1] > 0) { //10+5
                    money[0]--;
                    money[1]--;
                } else if (money[0] >= 3) { //5+5+5
                    money[0] = money[0] - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
