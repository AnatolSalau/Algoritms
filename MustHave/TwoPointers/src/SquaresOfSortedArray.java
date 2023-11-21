import java.util.Arrays;

public class SquaresOfSortedArray {
      /**
       * Given an integer array nums sorted in non-decreasing order,
       * return an array of the squares of each number sorted in non-decreasing order.
       *
       * Example 1:
       * Input: nums = [-4,-1,0,3,10]
       * Output: [0,1,9,16,100]
       * Explanation: After squaring, the array becomes [16,1,0,9,100].
       * After sorting, it becomes [0,1,9,16,100].
       *
       * Example 2:
       * Input: nums = [-7,-3,2,3,11]
       * Output: [4,9,9,49,121]
       *
       *
       * Constraints:
       * 1 <= nums.length <= 104
       * -104 <= nums[i] <= 104
       * nums is sorted in non-decreasing order.
       *
       * Follow up: Squaring each element and sorting the new array is very trivial,
       * could you find an O(n) solution using a different approach?
       */
      public static void main(String[] args) {
            int[] nums1 = {-4, -1, 0, 3, 10};
            System.out.println("Right answer : ");
            System.out.println("[0, 1, 9, 16, 100]");
            int[] res1 = sortedSquares(nums1);
            System.out.println(Arrays.toString(res1));
            System.out.println();
            int[] nums2 = {-3,2,3,11};
            System.out.println("Right answer : ");
            System.out.println("[4,9,9,121]");
            int[] res2 = sortedSquares(nums2);
            System.out.println(Arrays.toString(res2));
      }

      /*
                  [-4, -1, 0, 3, 10]    [0, 0, 0, 0 , 0]
                   lo            hi
           i=length - 1

           i = 4:  lo= -4,       hi= 10
                  [-4, -1, 0, 3, 10]    [0, 0, 0, 0 , 100]
                   lo        hi
           i = 3:  lo= -4,       hi= 3
                  [-4, -1, 0, 3, 10]    [0, 0, 0, 16 , 100]
                       lo    hi
           i = 2:  lo= -1,       hi= 3
                  [-4, -1, 0, 3, 10]    [0, 0, 9, 16 , 100]
                       lo hi
           i = 1:  lo= -1,       hi= 0
                  [-4, -1, 0, 3, 10]    [0, 1, 9, 16 , 100]
                         lohi
           i = 0:  lo= 0,       hi= 0
                  [-4, -1, 0, 3, 10]    [0, 1, 9, 16 , 100]
                         lohi

       */
      /*
            [-7, -3, 3, 11]    [0, 0, 0 , 0]
             lo         hi
     i=length - 1

     i = 3:  lo= -7,       hi= 11
            [-7, -3, 3, 11]    [0, 0, 0, 121]
             lo      hi
     i = 2:  lo= -7,       hi= 3
            [-7, -3, 3, 11]    [0, 0, 49, 121]
                 lo hi
     i = 1:  lo= -3,       hi= 3
            [-7, -3, 3, 11]    [0, 9, 49, 121]
                 lohi
     i = 0:  lo= -3,       hi= -3
            [-7, -3, 3, 11]    [9, 9, 49, 121]
                 lohi

      */
      private static int[] sortedSquares(int[] arr) {
            int[] res = new int[arr.length];
            int left = 0;
            int right = arr.length - 1;
            for (int i = 0; i < arr.length ; i--) {
                  if (Math.abs(arr[left]) <= Math.abs(arr[right])) {
                        res[i] = arr[left] * arr[left];
                        left ++;
                  } else {
                        res[i] = arr[right] * arr [right];
                        right--;
                  }
            }
            return res;
      }

      private static int[] sortedSquaresTest(int[] arr) {
            int lI = 0;
            int rI = arr.length - 1;
            int[] result = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {

            }

            return  result;
      }

}
