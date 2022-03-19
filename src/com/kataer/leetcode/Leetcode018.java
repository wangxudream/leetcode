package com.kataer.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Leetcode018
 * @Description: https://leetcode-cn.com/problems/last-stone-weight/
 * @Author kataer
 * @Date 2020/12/30 21:15
 * @Version V1.0
 * 最后一块石头的重量
 **/
public class Leetcode018 {
    public static void main(String[] args) {
        int[] stones = new int[]{6, 5, 4, 1, 2, 10};
//        System.out.println(lastStoneWeight(stones));
        PriorityQueueDemo(stones);
    }

    //利用优先队列
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int stone : stones) {
            priorityQueue.offer(stone);
        }

        while (priorityQueue.size() > 1) {
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            if (a - b > 0) {
                priorityQueue.offer(a - b);
            }
        }

        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }

    //正常情况下按自然序排序
    public static void PriorityQueueDemo(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int stone : stones) {
            priorityQueue.offer(stone);
        }
        System.out.println(priorityQueue);
    }
}
