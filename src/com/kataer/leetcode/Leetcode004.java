package com.kataer.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Leetcode004
 * @Description: https://leetcode-cn.com/problems/dota2-senate/
 * @Author kataer
 * @Date 2020/12/11 10:48
 * @Version V1.0
 **/
public class Leetcode004 {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RD"));
    }


    public static String predictPartyVictory(String senate) {
        Queue<Integer> rOrders = new LinkedList<>();
        Queue<Integer> dOrders = new LinkedList<>();
        char[] chars = senate.toCharArray();
        //确定两个阵营投票顺序
        for (int i = 0; i < senate.length(); i++) {
            if (chars[i] == 'R') {
                rOrders.offer(i);
            } else {
                dOrders.offer(i);
            }
        }

        //某个队列为空则停止循环
        while (!rOrders.isEmpty() && !dOrders.isEmpty()) {
            int rIndex = rOrders.poll();
            int dIndex = dOrders.poll();
            //判断哪个阵营先投票
            if (rIndex < dIndex) {
                //radiant 使用权力一+进入下一次循环
                rOrders.offer(rIndex + chars.length);
            } else {
                dOrders.offer(dIndex + chars.length);
            }
        }
        return rOrders.isEmpty() ? "Dire" : "Radiant";
    }

}
