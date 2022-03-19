//package com.kataer.leetcode;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @ClassName Easy003
// * @Description: https://leetcode-cn.com/problems/2vYnGI/
// * @Author kataer
// * @Date 2020/12/10 20:09
// * @Version V1.0
// **/
//public class Easy003 {
//    public static void main(String[] args) {
//        int[] staple = new int[]{5, 6, 3, 1};
//        for (int i = 1; i < staple.length; i++) {
//            for (int j = 0; j < staple.length - i; j++) {
//                if (staple[j] > staple[j + 1]) {
//                    int temp = staple[j];
//                    staple[j] = staple[j + 1];
//                    staple[j + 1] = temp;
//                }
//            }
//        }
//        for (int i = 0; i < staple.length; i++) {
//            System.out.println(staple[i]);
//        }
//
//        List<Integer> stapleList = Arrays.stream(staple).boxed().collect(Collectors.toList());
//        Collections.sort(stapleList);
//        System.out.println(stapleList);
//    }
//
//    //超时
//    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
//        int count = 0;
//        for (int i = 0; i < staple.length; i++) {
//            if (staple[i] < x) {
//                int surplus = x - staple[i];
//                for (int j = 0; j < drinks.length; j++) {
//                    if (drinks[j] < x && drinks[j] <= surplus) {
//                        count++;
//                    }
//                }
//            }
//        }
//        return count;
//    }
//
//    public static int breakfastNumber2(int[] staple, int[] drinks, int x) {
//        List<Integer> stapleList = Arrays.stream(staple).boxed().collect(Collectors.toList());
//        List<Integer> drinksList = Arrays.stream(drinks).boxed().collect(Collectors.toList());
//        Collections.sort(stapleList);
//        Collections.sort(drinksList);
//        int index1 = 0;
//        int index2 = 0;
//        int count = 0;
//        for (Integer stap : stapleList) {
//            if (stap < x) {
//                index1++;
//                int surplus =
//                for (Integer drink : drinksList) {
//                    if (){
//
//                    }
//                }
//            }
//        }
//    }
//
//
//}
