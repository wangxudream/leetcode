package com.kataer.leetcode;

public class Leetcode744 {
  public static void main(String[] args) {
    char[] chars = {'c', 'f', 'j'};
    char target = 'j';
    System.out.println(nextGreatestLetter_2(chars, target));
  }

  public static char nextGreatestLetter(char[] letters, char target) {
    for (char letter : letters) {
      if (letter > target) {
        return letter;
      }
    }
    return letters[0];
  }

  public static char nextGreatestLetter_2(char[] letters, char target) {
    if (target >= letters[letters.length - 1]) {
      return letters[0];
    }
    int left = 0, right = letters.length - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      if (letters[mid] > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return letters[left];
  }
}
