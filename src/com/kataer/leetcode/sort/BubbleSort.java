package com.kataer.leetcode.sort;


import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName BubbleSort
 * @Description: TODO
 * @Author kataer
 * @Date 2020/12/28 18:51
 * @Version V1.0
 **/
public class BubbleSort {
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(1024*1024*2);
        Random random = new Random(System.currentTimeMillis());
        int[] array = new int[1000];
        for (int i = 0; i < 100; i++) {
            array[i] = random.nextInt(500);
        }
        sort(array);
        bubbleSortIncr(array);
        insertSort(array);
        quick_sort(array, 0, array.length - 1);
        System.out.println(count);
    }

    //选择排序
    public static int[] bubbleSortIncr(int[] array) {
        int count = 0;
        int[] newArray = Arrays.copyOf(array, array.length);
        //i < array.length 或 i < array.length - 1 都可以，最后一次循环不是必须的
        for (int i = 0; i < newArray.length - 1; i++) {
            for (int j = i + 1; j < newArray.length; j++) {
                //第一次找出最小值存于array[0]    1、array[j]与array[0]比较大小 2、小于array[0]则交换位置
                //第二次找出第二小值存于array[1]  1、array[j]与array[1]比较大小 2、小于array[0]则交换位置
                if (newArray[j] < newArray[i]) {
                    count++;
                    int temp = newArray[j];
                    newArray[j] = newArray[i];
                    newArray[i] = temp;
                }
            }
        }
        System.out.println("bubbleSortIncr count:" + count);
        return newArray;
    }

    public static void bubbleSortDesc(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                //第一次找出最大值存于array[0] 1、array[j]与array[0]比较大小 2、大于array[0]则交换位置
                if (array[j] > array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }


    //冒泡排序
    public static int[] sort(int[] array) {
        int count = 0;
        int[] newArray = Arrays.copyOf(array, array.length);
        for (int i = 1; i < newArray.length; i++) {
            boolean swap = false;
            for (int j = 0; j < newArray.length - i; j++) {
                if (newArray[j] > newArray[j + 1]) {
                    swap = true;
                    count++;
                    int temp = newArray[j + 1];
                    newArray[j + 1] = newArray[j];
                    newArray[j] = temp;
                }
            }

            if (!swap) {
                break;
            }
        }
        System.out.println("sort count:" + count);
        return newArray;
    }


    public static int[] insertSort(int[] array) {
        int count = 0;
        int[] newArray = Arrays.copyOf(array, array.length);
        for (int i = 1; i < newArray.length; i++) {
            int temp = newArray[i];
            int j = i;
            while (j > 0 && temp < newArray[j - 1]) {
                count++;
                newArray[j] = newArray[j - 1];
                j--;
            }

            if (j != i) {
                count++;
                newArray[j] = temp;
            }

        }
        System.out.println("insertSort:" + count);
        return newArray;
    }


    public static void quick_sort(int s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j) {
                    count++;
                    s[i++] = s[j];
                }
                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j) {
                    count++;
                    s[j--] = s[i];
                }
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }

}
