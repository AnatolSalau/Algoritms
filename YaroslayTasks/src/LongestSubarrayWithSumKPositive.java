import java.util.LinkedList;

public class LongestSubarrayWithSumKPositive {
      /**
       Given an array of integers nums and an integer k,
       return longest subarray whose sum equals to k.

       A subarray is a contiguous non-empty sequence of elements within an array.
       */
      public static void main(String[] args) {
            testOne();
      }
      /*
            1, 2, 1, 0, 1
            1 2 1 = 4 - length 3
            2 1 0 1 = 4 - length 4 -> right answer
       */
      static void testOne() {
            int[] nums = {1,2,1,0,1};
            int target = 4;
            int expectedLength = 4;
      }
      /*
            2 3 5   k=5
            2 3 = 5 - length 2 -> right answer
            5 = 5 - length 1
               se
            i0: 2  3  5 -> sum 2
               s   e
            i1: 2  3  5 -> sum 5, length 2 -> add to answer
                s     e
            i2: 2  3  5 -> sum 10, length 3 -> 10 more than 5 so move start pointer
                   s  e
            i3: 2  3  5 -> sum 8, length 2 -> 8 more than 5 so move start pointer
                      se
            i3: 2  3  5 -> sum 5, length 1 -> add to answer

       */
      static void testTwo() {
            int[] nums = {2, 3, 5};
            int target = 5;
            int expectedLength = 2;
      }
      /*
            two pointer realization
            1, 2, 1, 0, 1     k=4
               se
            0:  1  2  1  0  1 -> sum 1
                s  e
            1:  1  2  1  0  1 -> sum 3 ->
                s     e
            2:  1  2  1  0  1 -> sum 4, length 3
                s        e
            3:  1  2  1  0  1 -> sum 4, length 4 -> add to answer
                s           e
            4:  1  2  1  0  1 -> sum 5, length 5 -> 5 more than 4 so move start point
                   s        e
            5:  1  2  1  0  1 -> sum 4, length 4 -> 4 add to answer

       */
      LinkedList<Integer> getLongestSubArr(int[] nums, int target) {
            LinkedList<Integer> result = new LinkedList<>();



            return result;
      }
}
