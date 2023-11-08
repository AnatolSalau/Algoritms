public class SubarraySumEqualsK {
      /**
       Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

       A subarray is a contiguous non-empty sequence of elements within an array.

       Example 1:

       Input: nums = [1,1,1], k = 2
       Output: 2
       Example 2:

       Input: nums = [1,2,3], k = 3
       Output: 2
       */
      public static void main(String[] args) {
            int[] nums1 = {1,2,3};
            int k1 = 3;
            System.out.println(getNumberOfSubarray(nums1,k1));
            int[] nums2 = {1,1,1};
            int k2 = 2;
            System.out.println(getNumberOfSubarray(nums2,k2));

            int[] nums3 = {1,2,2,3,2};
            int k3 = 5;
            System.out.println(getNumberOfSubarray(nums3,k3));
      }
      /*
            {1, 2, 3} k = 3
            count = 0
            1     1
            12    3 count = 1
            123   6

            2     2
            23    5

            3     3 count = 2
       */
      static int getNumberOfSubarray(int[] arr, int k) {
            int count = 0;

            for (int i = 0; i < arr.length; i++) {
                  int summ = 0;
                  for (int j = i; j < arr.length; j++) {
                        summ += arr[j];
                        if (summ == k) count ++;
                  }
            }
            return count;
      }
}
