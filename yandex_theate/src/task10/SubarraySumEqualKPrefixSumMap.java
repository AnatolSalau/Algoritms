package task10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class SubarraySumEqualKPrefixSumMap {
      /**
       Дан список интов и число-цель. Нужно найти такой range, чтобы сумма его элементов давала число-цель.
       elements = [1, -3, 4, 5]
       target = 9
       result = range(2, 4) # because elements[2] + elements[4] == target
       */
      public static void main(String[] args) {
            //testOne();
            testTwo();
      }

      /*    k = 9
          i:0   1  2  3
            1, -3, 4, 5
            *                   1 -> 0
            sum = 1, sum - k(1 - 9) = -8

          i:0   1  2  3
            1, -3, 4, 5         1 -> 0
                *              -2 -> 1
            sum = -2, sum - k (-2 - 9) = -11

          i:0   1  2  3
            1, -3, 4, 5         1 -> 0
                   *           -2 -> 1
                                2 -> 2
            sum = 2, sum - k (2 - 9) = -7

          i:0   1  2  3
            1, -3, 4, 5         1 -> 0
                      *        -2 -> 1
                                2 -> 2
            sum = 7, sum - k (7 - 9) = -2, -2 is exist in map -> so result is -> from i: 2 to i:3

       */
      private static void testOne() {
            int[] elements = {1, -3, 4, 5};
            int k = 9;
            int[] expectedResult = {4,5};

            System.out.println(Arrays.toString(getSubArr(elements, k)));
      }

      private static void testTwo() {
            int[] elements = {4, 1,-5, 8, -14, 2, 4, 3};
            int k = -5;
            int[] expectedResult = {-5, 8, -14, 2, 4};

            System.out.println(Arrays.toString(getSubArr(elements, k)));
      }


      private static int [] getSubArr(int[] elem, int target) {
            HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
            int currSum = 0;
            int indexFrom = 0;
            int indexTo = 0;
            for (int i = 0; i < elem.length; i++) {
                  int currNum = elem[i];
                  currSum = currSum + currNum;

                  if (currSum == target) { //if curr sum = target -> return result
                        indexTo = i;
                        break;
                  }

                  int remainder = currSum - target; // calculate remainder

                  if (prefixSumMap.containsKey(remainder)) {
                        int remainderLastIndex = prefixSumMap.get(remainder);
                        int currSumFirstIndex = remainderLastIndex + 1;
                        indexFrom = currSumFirstIndex;
                        indexTo = i;
                        break;
                  }

                  prefixSumMap.put(currSum,i);
            }

            int[] result = new int[indexTo - indexFrom + 1];

            for ( int k = 0, i = indexFrom; i <= indexTo; i++, k++) {
                  result[k] = elem[i];

            }
            return result;
      }


}
