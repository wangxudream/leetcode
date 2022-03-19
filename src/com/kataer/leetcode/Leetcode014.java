package com.kataer.leetcode;

import java.util.*;

/**
 * @ClassName Leetcode014
 * @Description: https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @Author kataer
 * @Date 2020/12/22 22:39
 * @Version V1.0
 * todo 考虑自己的写法
 **/
public class Leetcode014 {
    public static void main(String[] args) {
        final Leetcode014 leetcode014 = new Leetcode014();
    }

    //从左向右展示
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            //当前队列有多少node
            int currentLevel = nodeQueue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 1; i <= currentLevel; i++) {
                TreeNode node = nodeQueue.poll();
                //加入subList
                subList.add(node.val);
                //判断是否有子节点，有则加入queue
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
            }
            //同一层节点添加完毕，且子节点加入queue
            list.add(subList);
        }
        return list;
    }

    //锯齿遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean leftToRight = true;
        while (!nodeQueue.isEmpty()) {
            //当前队列有多少node
            int currentLevel = nodeQueue.size();
            Deque<Integer> subList = new LinkedList<>();
            for (int i = 1; i <= currentLevel; i++) {
                TreeNode node = nodeQueue.poll();
                //判断是否有子节点，有则加入queue,判断方向
                if (leftToRight) {
                    subList.offerLast(node.val);
                } else {
                    subList.offerFirst(node.val);
                }

                //从左往右加入queue
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
            }
            leftToRight = !leftToRight;
            //同一层节点添加完毕，且子节点加入queue
            list.add(new LinkedList<Integer>(subList));
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
