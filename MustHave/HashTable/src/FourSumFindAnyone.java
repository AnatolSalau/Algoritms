import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FourSumFindAnyone {
      /**
             Input: array = {10, 2, 3, 4, 5, 9, 7, 8}, X = 23
             Output: 3 5 7 8
             Explanation: Sum of output is equal to 23, i.e. 3 + 5 + 7 + 8 = 23.

             Input: array = {1, 2, 3, 4, 5, 9, 7, 8}, X = 16
             Output: 1 3 5 7
             Explanation: Sum of output is equal to 16, i.e. 1 + 3 + 5 + 7 = 16.
       */
      public static void main(String[] args) {

      }

      Map<Integer, ArrayList<Integer>> mapAllSumPairIndexes(int[] arr) {
            Map<Integer, ArrayList<Integer>> result = new HashMap<>();
            //run through all pairs
            for (int i = 0; i < arr.length - 1; i++) {
                  for (int j = i+1; j < arr.length; j++) {
                        int sum = arr[i] + arr[j];

                  }
            }
            return null;
      }
}
