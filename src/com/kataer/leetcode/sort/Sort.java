package com.kataer.leetcode.sort;

import java.util.Arrays;

/**
 * @ClassName Sort
 * @Description: TODO
 * @Author kataer
 * @Date 2020/12/29 10:01
 * @Version V1.0
 **/
public class Sort {
    public static void main(String[] args) {
        int[] array = new int[]{8, 9, 9, 6, 3, 1};
        bubbleSortIncr(array);
        System.out.println(">>>>>>>>>>>>>>>>");
        bubbleSortDesc(array);
        System.out.println(">>>>>>>>>>>>>>>>");
        selectSortIncr(array);
        System.out.println(">>>>>>>>>>>>>>>>");
        selectSortDesc(array);
        System.out.println(">>>>>>>>>>>>>>>>");
        selectSortIncr2(array);
        System.out.println(">>>>>>>>>>>>>>>>");
        insertSort(array);
        System.out.println(">>>>>>>>>>>>>>>>");
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    //1、外层循环控制循环次数 2、内层循环交换数字
    public static int[] bubbleSortIncr(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        for (int i = 1; i < copy.length; i++) {
            for (int j = 0; j < copy.length - i; j++) {
                if (copy[j] > copy[j + 1]) {
                    //交换后j++，指针位于交换后的数字
                    int temp = copy[j + 1];
                    copy[j + 1] = copy[j];
                    copy[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(copy));
        return copy;
    }

    public static int[] bubbleSortDesc(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        for (int i = 1; i < copy.length; i++) {
            for (int j = 0; j < copy.length - i; j++) {
                if (copy[j] < copy[j + 1]) {
                    int temp = copy[j + 1];
                    copy[j + 1] = copy[j];
                    copy[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(copy));
        return copy;
    }

    public static int[] selectSortIncr(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        for (int i = 0; i < copy.length; i++) {
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[j] < copy[i]) {
                    int temp = copy[i];
                    copy[i] = copy[j];
                    copy[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(copy));
        return copy;
    }

    public static int[] selectSortDesc(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        for (int i = 0; i < copy.length; i++) {
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[j] > copy[i]) {
                    int temp = copy[i];
                    copy[i] = copy[j];
                    copy[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(copy));
        return copy;
    }

    public static int[] selectSortIncr2(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        for (int i = 0; i < copy.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[j] < copy[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = copy[minIndex];
                copy[minIndex] = copy[i];
                copy[i] = temp;
            }
        }
        System.out.println(Arrays.toString(copy));
        return copy;
    }


    public static int[] insertSort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        for (int i = 1; i < copy.length; i++) {
            int temp = copy[i];
            int j = i;
            while (j > 0 && temp < copy[j - 1]) {
                copy[j] = copy[j - 1];
                j--;
            }
            if (j != i) {
                copy[j] = temp;
            }
        }
        System.out.println(Arrays.toString(copy));
        return copy;
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int x = begin;
            int y = end;
            int temp = array[begin];
            while (x < y) {
                while (x < y && array[y] >= temp) {
                    y--;
                }
                if (x < y) {
                    array[x++] = array[y];
                }

                while (x < y && array[x] < temp) {
                    x++;
                }
                if (x < y) {
                    array[y--] = array[x];
                }
            }
            array[x] = temp;
            quickSort(array, begin, x - 1);
            quickSort(array, x + 1, end);
        }
    }


}


