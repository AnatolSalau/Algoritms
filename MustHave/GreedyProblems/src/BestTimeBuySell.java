import java.lang.reflect.Array;
import java.util.Arrays;

public class BestTimeBuySell {
      /**
             121. Best Time to Buy and Sell Stock

             Companies
             You are given an array prices where prices[i] is the price of a given stock on the ith day.

             You want to maximize your profit by choosing a single day to buy one stock
             and choosing a different day in the future to sell that stock.

             Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

             Example 1:
             Input: prices = [7,1,5,3,6,4]
             Output: 5
             Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

             Example 2:
             Input: prices = [7,6,4,3,1]
             Output: 0
             Explanation: In this case, no transactions are done and the max profit = 0.
       */
      public static void main(String[] args) {
            test1();
            test2();
      }
      /*
            0  1  2  3  4  5
            7, 1, 5, 3, 6, 4

            buyDay = 0;
            buyPrice = 7;

            sellDay = 0;
            sellPrice = 7;

            for:
            i:1 buyDay = 1;
                buyPrice = 1;
                sellDay = 1;
                sellPrice = 1;

            i:2 buyDay = 1;
                buyPrice = 1;
                sellDay = 2;
                sellPrice = 5;

            i:3 buyDay = 1;
                buyPrice = 1;
                sellDay = 2;
                sellPrice = 5;

            i:4 buyDay = 1;
                buyPrice = 1;
                sellDay = 4;
                sellPrice = 6;

            i:5 buyDay = 1;
                buyPrice = 1;<-------
                sellDay = 4;
                sellPrice = 6;<------

                return 6 - 1 = 5

       */
      static void test1() {
            int[] prices = {7,1,5,3,6,4};
            int expected = 5;
            System.out.println(Arrays.toString(prices));
            BestTimeBuySell bestTimeBuySell = new BestTimeBuySell();
            int maxProfit = bestTimeBuySell.getMaxProfit(prices);
            System.out.println("Max profit : " + maxProfit);
            System.out.println("Expected result : " + expected);
            System.out.println();
      }
      /*

       */
      static void test2() {
            int[] prices = {7,6,4,3,1};
            int expected = 0;
            System.out.println(Arrays.toString(prices));
            BestTimeBuySell bestTimeBuySell = new BestTimeBuySell();
            int maxProfit = bestTimeBuySell.getMaxProfit(prices);
            System.out.println("Max profit : " + maxProfit);
            System.out.println("Expected result : " + expected);
            System.out.println();
      }

      private int getMaxProfit(int[] prices) {
            int buyPrice = prices[0];
            int buyDay = 0;

            int sellPrice = prices[0];
            int sellDay = 0;

            int maxProfit = 0;

            for (int i = 0; i < prices.length; i++) {
                  int currPrice = prices[i];
                  int currDay = i;
                  int currProfit = currPrice - buyPrice;

                  if (currProfit > maxProfit) {
                        maxProfit = currProfit;
                        sellDay = currDay;
                        sellPrice = currPrice;

                  } else {
                        if (currPrice < buyPrice) {
                              buyPrice = currPrice;
                              buyDay = currDay;
                        }
                  }

            }
            System.out.println("Buy day :" + buyDay);
            System.out.println("With price :" + buyPrice);
            System.out.println("Sell day :" + sellDay);
            System.out.println("Sell price :" + sellPrice);
            return maxProfit;
      }
}
