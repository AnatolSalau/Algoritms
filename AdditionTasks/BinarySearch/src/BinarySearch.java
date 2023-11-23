public class BinarySearch {
      /**
             Given an array of integers nums which is sorted in ascending order,
             and an integer target, write a function to search target in nums.
             If target exists, then return its index. Otherwise, return -1.

             You must write an algorithm with O(log n) runtime complexity.

             Example 1:

             Input: nums = [-1,0,3,5,9,12], target = 9
             Output: 4
             Explanation: 9 exists in nums and its index is 4

             Example 2:

             Input: nums = [-1,0,3,5,9,12], target = 2
             Output: -1
             Explanation: 2 does not exist in nums so return -1
       */
      public static void main(String[] args) {
            test1();
      }
      //
      public int getIndexBinary(int[] nums, int target, int leftIndex, int rightIndex) {
            if (leftIndex <= rightIndex) {
                  int leftValue = nums[leftIndex];
                  int rightValue = nums[rightIndex];
                  int middleIndex = leftIndex + rightIndex / 2;
                  int middleValue = nums[middleIndex];
                  if (target == middleValue) return  middleIndex;

                  if (target < middleValue) {
                        return getIndexBinary(nums,target,leftIndex,middleIndex - 1);
                  } else {
                        return getIndexBinary(nums,target,middleIndex + 1,rightIndex);
                  }
            }
            return -1;
      }
      static void test1() {
            int[] nums = {-1,0,3,5,9,12,20};
            int target = 9;
            int expected = 4;
            BinarySearch binarySearch = new BinarySearch();
            int result = binarySearch.getIndexBinary(nums, target, 0,nums.length - 1);
            System.out.println(result);
      }

      static void test2() {
            int[] nums = {-1,0,3,5,9,12};
            int target = 2;
            int expected = 4;
      }
}
