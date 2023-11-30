package task14;

import java.util.*;

public class Task14TwoPointer {
      /**
             Given two integer arrays nums1 and nums2, return an array of their intersection.
             Each element in the result must appear as many times as it shows in both arrays
             and you may return the result in any order.

             Example 1:
             Input: nums1 = [1,2,2,1], nums2 = [2,2]
             Output: [2,2]

             Example 2:
             Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
             Output: [4,9]
             Explanation: [9,4] is also accepted.
       */
      public static void main(String[] args) {
            test1();
            test2();
      }

      public int[] intersect(int[] nums1, int[] nums2) {
            int length1 = nums1.length;
            int length2 = nums2.length;
            int[] ans = new int[Math.min(length1,length2)];
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int i = 0, j = 0, k = 0;

            while (i < length1 && j < length2) {
                  if (nums1[i] < nums2[j]) {
                        i++;
                  } else if (nums1[i] > nums2[j]) {
                        j++;
                  } else {
                        ans[k] = nums1[i];
                        i++;
                        k++;
                        j++;
                  }
            }
            return Arrays.copyOfRange(ans,0,k);
      }

      /*
            1,2,2,1     -> 1 1 2 2
            2,2         -> 2 2

            i
            1 1 2 2 ->  i(1) < j(2) -> i++
            j
            2 2
            k
            0 0 0 0

              i
            1 1 2 2 ->  i(1) < j(2) -> i++
            j
            2 2
            k
            0 0 0 0

                i                         k
            1 1 2 2 ->  i(2) == j(2) -> 2 0 0 0, i++, j++, k++
            j
            2 2
            k
            0 0 0 0

                  i             i                         k
            1 1 2 2 ->  i(2) == j(2) -> 2 2 0 0, i++, j++, k++
              j
            2 2
              k
            2 0 0 0
       */
      static void test1() {
            Task14TwoPointer twoPointer = new Task14TwoPointer();

            int[]nums1 = {1,2,2,1};
            int[]nums2 = {2,2};
            String expectedResult = "[2,2]";
            System.out.println(Arrays.toString(twoPointer.intersect(nums1,nums2 )));
            System.out.println("Exp : " + expectedResult);
      }

      /*
            4,9,5       -> 4 5 9
            9,4,9,8,4   -> 4 4 8 9 9
            i
            4 5 9       -> i(4) == j(4) -> to answer
            j
            4 4 8 9 9
            k
            4 0 0 0 0

              i
            4 5 9       -> i(5) > j(4) -> j++
              j
            4 4 8 9 9
              k
            4 0 0 0 0

              i
            4 5 9       -> i(5) < j(8) -> i++
                j
            4 4 8 9 9
              k
            4 0 0 0 0

                i
            4 5 9       -> i(9) > j(8) -> j++
                j
            4 4 8 9 9
              k
            4 0 0 0 0

                i
            4 5 9       -> i(9) = j(9) -> add to ans
                  j
            4 4 8 9 9
              k
            4 0 0 0 0

       */
      static void test2() {
            Task14TwoPointer twoPointer = new Task14TwoPointer();
            int[]nums1 = {4,9,5};
            int[]nums2 = {9,4,9,8,4};
            String expectedResult = "[4,9]";
            System.out.println(Arrays.toString(twoPointer.intersect(nums1,nums2 )));
            System.out.println("Exp : " + expectedResult);
      }
}
