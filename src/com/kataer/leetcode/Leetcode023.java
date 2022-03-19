package com.kataer.leetcode;

/**
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 * 根据二叉树创建字符串
 *
 * @date 2022-03-19
 */
public class Leetcode023 {
  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
//    node1.left = node2;
//    node1.right = node3;
//    node2.left = node4;
//    node2.right = node5;

//    preOrder(node1);
    StringBuilder builder = new StringBuilder();
    preOrderWithBuilder(node1, builder);
    System.out.println(builder.toString());
  }

  private static void preOrder(TreeNode node) {
    System.out.println(node.val);
    if (node.left != null) {
      preOrder(node.left);
    }

    if (node.right != null) {
      preOrder(node.right);
    }
  }

  private static void preOrderWithBuilder(TreeNode node, StringBuilder builder) {
    boolean hasLeftNode = false;
    builder.append(node.val);
    if (node.left != null) {
      hasLeftNode = true;
      builder.append("(");
      preOrderWithBuilder(node.left, builder);
      builder.append(")");
    }

    if (!hasLeftNode && node.right != null) {
      builder.append("()");
    }

    if (node.right != null) {
      builder.append("(");
      preOrderWithBuilder(node.right, builder);
      builder.append(")");
    }
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
