package com.kataer.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode024 {
  public static void main(String[] args) {
    String[] ops = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
    System.out.println(calPoints(ops));
  }

  public static int calPoints(String[] ops) {
    List<Integer> pointsList = new ArrayList<>(ops.length);
    int res = 0;
    for (String op : ops) {
      int n = pointsList.size();
      if ("+".equals(op)) {
        res += (pointsList.get(n - 1) + pointsList.get(n - 2));
        pointsList.add(pointsList.get(n - 1) + pointsList.get(n - 2));
        continue;
      }
      if ("C".equals(op)) {
        res -= pointsList.get(n - 1);
        pointsList.remove(n - 1);
        continue;
      }
      if ("D".equals(op)) {
        res += pointsList.get(n - 1) * 2;
        pointsList.add(pointsList.get(n - 1) * 2);
        continue;
      }
      res += Integer.parseInt(op);
      pointsList.add(Integer.parseInt(op));
    }
    return res;
  }
}
