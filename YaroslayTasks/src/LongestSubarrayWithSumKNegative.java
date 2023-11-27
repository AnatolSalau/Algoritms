import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LongestSubarrayWithSumKNegative {
      /**
       Given an array of integers nums and an integer k,
       return longest subarray whose sum equals to k.

       A subarray is a contiguous non-empty sequence of elements within an array.
       */
      public static void main(String[] args) {
            testOne();
      }
      /*                        *
            0  1  2  3   4   5  6  7
            4, 1,-5, 8, -14, 2, 4, 3     k= - 5


            4 -> 0
            5 -> 1
            0 -> 2
            8 -> 3
            -6 ->4
            -4 -> 5
            0 -> 6
            3 -> 3

       */
      List<Integer> getLongestSubArray(int[] array, int k) {
            List<Integer> result = new LinkedList<>();
            return result;
      }
      static void testOne() {
           int[] nums = {4, 1,-5, 8, -14, 2, 4, 3};
           int k = -5;
           int expectedLength1 = 5;
           int[] expectedResult1 = {-5, 8, -14, 2, 4};
           int expectedLength2 = 4;
           int[] expectedResult2 = {-14, 2, 4, 3};
            int result = lenOfLongSubarr(nums, k);
            System.out.println(result);
      }

      static int lenOfLongSubarr(int[] arr, int k)
      {     int n = arr.length;
            // HashMap to store (sum, index) tuples
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0, maxLen = 0;

            // traverse the given array
            for (int i = 0; i < n; i++) {

                  // accumulate sum
                  sum += arr[i];

                  // when subarray starts from index '0'
                  if (sum == k)
                        maxLen = i + 1;

                  // make an entry for 'sum' if it is
                  // not present in 'map'
                  if (!map.containsKey(sum)) {
                        map.put(sum, i);
                  }

                  // check if 'sum-k' is present in 'map'
                  // or not
                  if (map.containsKey(sum - k)) {

                        // update maxLength
                        if (maxLen < (i - map.get(sum - k)))
                              maxLen = i - map.get(sum - k);
                  }
            }

            return maxLen;
      }
}
