import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
      /**
             714. Best Time to Buy and Sell Stock with Transaction Fee

             You are given an array prices where prices[i] is the price of a given stock on the ith day,
             and an integer fee representing a transaction fee.

             Find the maximum profit you can achieve.
             You may complete as many transactions as you like,
             but you need to pay the transaction fee for each transaction.

             Note:

             You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
             The transaction fee is only charged once for each stock purchase and sale.


             Example 1:
             Input: prices = [1,3,2,8,4,9], fee = 2
             Output: 8
             Explanation: The maximum profit can be achieved by:
             - Buying at prices[0] = 1
             - Selling at prices[3] = 8
             - Buying at prices[4] = 4
             - Selling at prices[5] = 9
             The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

             Example 2:
             Input: prices = [1,3,7,5,10,3], fee = 3
             Output: 6
       */
      public static void main(String[] args) {
            //testOne();
            testTwo();
      }

      static void testOne() {
            int[] prices = {1,3,2,8,4,9};
            int fee = 2;
            int expected = 8;
            System.out.println(Arrays.toString(prices));
            BestTimeToBuyAndSellStock buyAndSellStock = new BestTimeToBuyAndSellStock();
            int maxProfit = buyAndSellStock.getMaxProfit(prices, fee);
            System.out.println("Result : " + maxProfit);
            System.out.println("Expected : " + expected);
      }

      static void testTwo() {
            int[] prices = {1,3,7,5,10,3};
            int fee = 3;
            int expected = 6;
            System.out.println(Arrays.toString(prices));
            BestTimeToBuyAndSellStock buyAndSellStock = new BestTimeToBuyAndSellStock();
            int maxProfit = buyAndSellStock.getMaxProfit(prices, fee);
            System.out.println("Result : " + maxProfit);
            System.out.println("Expected : " + expected);
      }

      int getMaxProfit(int[] prices, int fee) {
            int profit = 0;
            int buyPrice = prices[0];

            for (int i = 0; i < prices.length; i++) {
                  int currPrice = prices[i];
                  int currProfit = currPrice - buyPrice - fee;
                  if (currProfit > profit) {
                        profit = currProfit;
                  }
                  int currBuyPrice = currPrice - profit;
                  if (currBuyPrice < buyPrice) {
                        buyPrice = currBuyPrice;
                  }
            }

            return  profit ;
      }
}
