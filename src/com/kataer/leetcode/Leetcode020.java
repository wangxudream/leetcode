package com.kataer.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @ClassName Leetcode020
 * @Description: https://leetcode-cn.com/problems/sliding-window-maximum/
 * @Author kataer
 * @Date 2021/1/2 16:38
 * @Version V1.0
 * 滑动窗口最大值
 **/
public class Leetcode020 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
//      int[] ints = maxSlidingWindow(nums, 1);
//        int[] ints = maxSlidingWindow2(nums, 3);
        int[] ints = maxSlidingWindow4(nums, 3);
        System.out.println(Arrays.toString(ints));
    }


    //自己想的
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        //找到初始窗口中的最大值的最大下标
        int maxIndex = findMaxIndex(nums, 0, k - 1);
        int max = nums[maxIndex];
        res[0] = max;
        int count = 1;
        int fast = k - 1;
        //滑动窗口向右移动1位
        for (int slow = 1; slow <= nums.length - k; slow++) {
            if (nums[++fast] >= max) {
                max = nums[fast];
                maxIndex = fast;
                res[count++] = max;
            } else {
                //最大值在窗口内和不在窗口内
                if (maxIndex < slow) {
                    //不在窗口内
                    maxIndex = findMaxIndex(nums, slow, fast);
                    max = nums[maxIndex];
                    res[count++] = max;
                } else {
                    res[count++] = max;
                }
            }
        }
        return res;
    }

    public static int findMaxIndex(int[] array, int begin, int end) {
        int maxIndex = begin;
        if (begin == end) {
            return maxIndex;
        }
        int max = array[begin];
        for (int i = begin; i <= end; i++) {
            //相等的情况，获取最大的下标
            if (array[i] >= max) {
                max = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    //利用优先队列 1、添加元素  2、判断栈顶的元素是否在窗口内 3、选取最大值存入res数组
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        //最大值个数为len - k + 1
        int[] res = new int[nums.length - k + 1];
        //初始化优先队列
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
        }
        //peek
        res[0] = priorityQueue.peek()[0];
        for (int i = 1, j = k; i < res.length; i++, j++) {
            priorityQueue.offer(new int[]{nums[j], j});
            //栈顶的元素为窗口外的元素,全部取出
            //惰性的思想，只判断最大值是否在窗口内，不考虑其它元素
            while (priorityQueue.peek()[1] < i) {
                priorityQueue.poll();
            }
            //符合条件的最大值peek
            res[i] = priorityQueue.peek()[0];
        }
        return res;
    }

    //利用单调队列的思想(下标递增) 1、最大值左边的元素都是无效的
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        //最大值个数为len - k + 1
        int[] res = new int[nums.length - k + 1];
        //单调队列，存储最大值下标
        Deque<Integer> deque = new LinkedList<Integer>();
        //初始化单调队列
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                //同一窗口内最大值左边的元素是无效的
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        for (int i = 1; i < res.length; i++) {
            //新添加元素大于队首元素(队首元素)
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
        }

        return res;
    }


    public static int[] maxSlidingWindow4(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
