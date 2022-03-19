package com.kataer.leetcode.fast;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @ClassName AddTwoNumbers
 * @Description: 两数之和
 * @Author kataer
 * @Date 2021/10/17 19:22
 * @Version V1.0
 **/
public class AddTwoNumbers {

  public static void main(String[] args) {
    final AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(1);
    addTwoNumbers.addTwoNumbers(l1, l2);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode root = new ListNode();
    ListNode index = root;
    int carry = 0;
    while (l1 != null || l2 != null || carry > 0) {
      int value_1 = l1 == null ? 0 : l1.val;
      int value_2 = l2 == null ? 0 : l2.val;

      int sum = value_1 + value_2 + carry;
      carry = sum / 10;

      ListNode newNode = new ListNode();
      newNode.val = sum % 10;

      index.next = newNode;
      index = newNode;

      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }
    return root.next;
  }


  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
