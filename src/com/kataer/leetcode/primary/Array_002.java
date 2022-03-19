package com.kataer.leetcode.primary;

/**
 * @ClassName Array_002
 * @Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @Author kataer 买卖股票的最佳时机
 * @Date 2020/12/11 22:14
 * @Version V1.0
 **/
public class Array_002 {
  public static void main(String[] args) {
    int[] ints = new int[]{1, 7, 1};
//    System.out.println(maxProfit(ints));
//    System.out.println(maxProfit_2(ints));
//    System.out.println(minProfit(ints));
    System.out.println(maxProfit_3(ints));
  }

  //同一天参与多比交易(卖出，买进),只能用于计算最大利润
  public static int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      // Math.max(0, prices[i] - prices[i - 1]);
      if (prices[i] > prices[i - 1]) {
        profit += prices[i] - prices[i - 1];
      }
    }
    return profit;
  }

  //动态规划计算
  public static int maxProfit_2(int[] prices) {
    int len = prices.length;
    int[][] dp = new int[len][2];
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    for (int i = 0; i < dp.length; i++) {
      StringBuilder builder = new StringBuilder();
      for (int j = 0; j < dp[i].length; j++) {
        builder.append(dp[i][j]).append(" ");
      }
      System.out.println(builder.toString());
    }
    return dp[len - 1][0];
  }

  public static int maxProfit_3(int[] prices) {
    int hold = -prices[0];
    int nhold = 0;
    for (int i = 1; i < prices.length; i++) {
      hold = Math.max(hold,nhold-prices[i]);
      nhold = Math.max(nhold,hold+prices[i]);
    }
    return nhold;
  }


  public static int minProfit(int[] prices) {
    int len = prices.length;
    int[][] dp = new int[len][2];
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[len - 1][1];
  }

}
