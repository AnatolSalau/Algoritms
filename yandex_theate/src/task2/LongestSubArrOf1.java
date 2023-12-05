package task2;

public class LongestSubArrOf1 {
      /**
       Given a binary array nums, you should delete one element from it.

       Return the size of the longest non-empty subarray containing only 1's in the resulting array.
       Return 0 if there is no such subarray.

       Example 1:
                          2
       Input: nums = [1,1,0,1]
       Output: 3
       Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

       Example 2:
                              4
       Input: nums = [0,1,1,1,0,1,1,0,1]
       Output: 5
       Explanation: After deleting the number in position 4,
       [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

       Example 3:
       Input: nums = [1,1,1]
       Output: 2
       Explanation: You must delete one element.
       */
      public static void main(String[] args) {

      }
      /*            4
            0,1,1,1,0,1,1,0,1
            after deleting element on index 4
            expected 5 = [1,1,1,1,1].
       */
      /*    i:    0 1 2 3 4 5 6 7 8
            arr:  0,1,1,1,0,1,1,0,1

            i:    0 1 2 3 4 5 6 7 8
            arr:  0,1,1,1,0,1,1,0,1
                 lr
           countZeros = 1 -> r++
           resultLength = 0 (1 - 1)

            i:    0 1 2 3 4 5 6 7 8
            arr:  0,1,1,1,0,1,1,0,1
                  l r
           countZeros = 1 -> r++
           resultLength = 1 (2 - 1)

            i:    0 1 2 3 4 5 6 7 8
            arr:  0,1,1,1,0,1,1,0,1
                  l   r
           countZeros = 1 -> r++
           resultLength = 2 (3 - 1)

            i:    0 1 2 3 4 5 6 7 8
            arr:  0,1,1,1,0,1,1,0,1
                  l     r
           countZeros = 1 -> r++
           resultLength = 3 (4 - 1)

            i:    0 1 2 3 4 5 6 7 8
            arr:  0,1,1,1,0,1,1,0,1
                  l l     r == 0
           countZeros = 2 -> we need to move left pointer -> because l== 0 move to only one position -> l++ r++
           resultLength = 3 (4 - 1)

            i:    0 1 2 3 4 5 6 7 8
            arr:  0,1,1,1,0,1,1,0,1
                    l       r
           countZeros = 1 -> r++
           resultLength = 4 (5 - 1)

            i:    0 1 2 3 4 5 6 7 8
            arr:  0,1,1,1,0,1,1,0,1
                    l         r
           countZeros = 1 -> r++
           resultLength = 5 (6 - 1) -> max result

            i:    0 1 2 3 4 5 6 7 8
            arr:  0,1,1,1,0,1,1,0,1
                    l l l l l   r==0 -
           countZeros = 2 -> > move left -> because left == 1 mo when l will be 0 + 1 -> while [l] == 0, r++
           resultLength = 2 (3 - 1)

            i:    0 1 2 3 4 5 6 7 8
            arr:  0,1,1,1,0,1,1,0,1
                            l     r==0
           countZeros = 1 ->
           resultLength = 3 (4 - 1)
       */
      private static void test1() {
            int[] nums = {0,1,1,1,0,1,1,0,1};
            System.out.println("Expected result = 5");

      }

      private int gemLongestSubarray() {
            return 0;
      }
}
