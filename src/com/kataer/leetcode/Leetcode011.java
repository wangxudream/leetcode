package com.kataer.leetcode;

/**
 * @ClassName Leetcode011
 * @Description: 有序序列两数之和(犀牛医疗面试题)
 * @Author kataer
 * @Date 2020/12/19 11:46
 * @Version V1.0
 **/
public class Leetcode011 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 3, 11, 24};
        Leetcode011 leetcode011 = new Leetcode011();
        Result result = leetcode011.sum(array, 2);
        System.out.println(result);
    }

    public Result sum(int[] array, int sum) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] > sum) {
                j--;
            } else if (array[i] + array[j] < sum) {
                i++;
            } else {
                return new Result(i, j, true);
            }
        }
        return new Result(0, 0, false);
    }

    public class Result {
        private int num1;
        private int num2;
        private boolean success;

        public Result(int num1, int num2, boolean success) {
            this.num1 = num1;
            this.num2 = num2;
            this.success = success;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "num1=" + num1 +
                    ", num2=" + num2 +
                    ", success=" + success +
                    '}';
        }
    }
}
