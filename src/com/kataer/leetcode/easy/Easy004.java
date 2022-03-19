package com.kataer.leetcode.easy;

/**
 * @ClassName Easy004
 * @Description: 删除列表的中间元素
 * todo 判断链表是否有环，倒数k个节点
 * @Author kataer
 * @Date 2020/12/21 23:37
 * @Version V1.0
 **/
public class Easy004 {
//0 1 2 3 4 5 6

    public static void main(String[] args) {
//        ListNode node = new ListNode(0);
//        node.next = new ListNode(1);
//        node.next.next = new ListNode(2);
//        node.next.next.next = new ListNode(3);
//        node.next.next.next.next = new ListNode(4);
//        node.next.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next.next = new ListNode(6);
//        node.next.next.next.next.next.next.next = new ListNode(7);
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);
        deleteNode(node);
        System.out.println("....");
        System.out.println(node.val);
        System.out.println(node.next.val);
        System.out.println(node.next.next.val);
        System.out.println(node.next.next.next.val);
    }

    public static void deleteNode(ListNode node) {
        ListNode preNode = node;
        ListNode fNode = node;
        ListNode sNode = node;
        while (fNode != null && fNode.next != null && fNode.next.next != null) {
            preNode = sNode;
            fNode = fNode.next.next;
            sNode = sNode.next;
        }
        //sNode为中间节点,删除这个节点
        preNode.next = sNode.next;
    }


    //快慢指针，快指针移动两次，慢指针移动一次
    public static void findMidNode(ListNode node) {
        ListNode fNode = node;
        ListNode sNode = node;
        while (fNode != null && fNode.next != null && fNode.next.next != null) {
            fNode = fNode.next.next;
            sNode = sNode.next;
        }
        System.out.println(sNode.val);
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
