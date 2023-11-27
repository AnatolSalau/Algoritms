import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LongestSubarrayWithSumKNegative {
      /**
       Given an array of integers nums and an integer k,
       return longest subarray whose sum equals to k.

       A subarray is a contiguous non-empty sequence of elements within an array.
       */
      public static void main(String[] args) {

      }
      /*
            3, 1,-5, 8, -14, 2, 4, 3     k= - 5

            3 -> 0
            4 -> 1


       */
      List<Integer> getLongestSubArray(int[] array, int k) {
            List<Integer> result = new LinkedList<>();
            return result;
      }
      static void testOne() {
           int[] nums = {3, 1,-5, 8, -14, 2, 4, 3};
           int k = -5;
           int expectedLength1 = 5;
           int[] expectedResult1 = {-5, 8, -14, 2, 4};
           int expectedLength2 = 4;
           int[] expectedResult2 = {-14, 2, 4, 3};
      }
}
