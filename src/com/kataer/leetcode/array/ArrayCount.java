package com.kataer.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 统计数组区间内数的数量
 */
public class ArrayCount {
  public static void main(String[] args) {
    int[] datas = {1, 3, 5, 11, 17, 18, 20, 25, 36};
    System.out.println(arrayCount(datas, 5));
  }

  private static List<Node> arrayCount(int[] datas, int interval) {
    List<Node> nodes = new ArrayList<>();
    int flag = interval;
    int count = 0;
    for (int i = 0; i < datas.length; i++) {
      int data = datas[i];
      if (data >= flag || i == datas.length - 1) {
        Node node = new Node();
        node.setCount(count);
        node.setFlag(flag);
        nodes.add(node);
        //
        count = 0;
        flag += interval;
        while (data > flag) {
          Node node1 = new Node();
          if (i == datas.length) {
            node1.setCount(1);
          } else {
            node1.setCount(0);
          }
          node1.setFlag(flag);
          nodes.add(node1);
          flag += interval;
        }
      }
      count++;
    }
    return nodes;
  }


  private static class Node {
    private int flag;
    private int count;

    public int getFlag() {
      return flag;
    }

    public void setFlag(int flag) {
      this.flag = flag;
    }

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }

    @Override
    public String toString() {
      return "Node{" +
          "flag=" + flag +
          ", count=" + count +
          '}';
    }
  }
}
