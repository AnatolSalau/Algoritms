import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindowMedianMaximum {
      /**
       O(nklogk) - power metod
       */
      /**
       You are given an array of integers nums,
       there is a sliding window of size k which is moving from the very left of the array to the very right.
       You can only see the k numbers in the window. Each time the sliding window moves right by one position.

       Return the max sliding window.

       Example 1:

       Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
       Output: [3,3,5,5,6,7]
       Explanation:
       Window position                Max
       ---------------               -----
       [1  3  -1] -3  5  3  6  7       3
       1 [3  -1  -3] 5  3  6  7       3
       1  3 [-1  -3  5] 3  6  7       5
       1  3  -1 [-3  5  3] 6  7       5
       1  3  -1  -3 [5  3  6] 7       6
       1  3  -1  -3  5 [3  6  7]      7

       Example 2:

       Input: nums = [1], k = 1
       Output: [1]
       */

      public static void main(String[] args) {

            test1();
            test2();
      }

      /*
            2 3 3 5 7 10 - 4 (even length (3+5)/2 = median is 4

            1,3,-1,-3,5,3,6,7   k=3

            1 3 -1  sort->  -1 1 3 (max is 3)
            3  -1  -3 sort-> -3 -1 3 (max is 3)
            -1  -3  5 sort-> -3 -1 5 (max is 5)
            -3  5  3 sort-> -3 3 5 (max is 5)
            5  3  6 sort-> 3 5 6 (max is 6)
            3  6  7 sort-> 3 6 7 (max is 7)
      */
      static void test1() {
            int[] arr = {1,3,-1,-3,5,3,6,7};
            int k = 3;
            double[] expected = {3,3,5,5,6,7};
            System.out.println("Arr =" + Arrays.toString(arr));
            System.out.println("k =" + k);
            SlidingWindowMedianMaximum slidingWindowMedian = new SlidingWindowMedianMaximum();
            List<Double> result = slidingWindowMedian.getMediansList(arr, k);
            System.out.println("Expected result =" + Arrays.toString(expected));
            System.out.println("My result =" + result);
      }
      /*
            1 2 3 4 2 3 1 4 2  k=3

            1 2 3 sort-> 1 2 3 (max is 3)
            2 3 4 sort-> 2 3 4 (max is 4)
            3 4 2 sort-> 2 3 4 (max is 4)
            4 2 3 sort-> 2 3 4 (max is 4)
            2 3 1 sort-> 1 2 3 (max is 3)
            3 1 4 sort-> 1 3 4 (max is 4)
            1 4 2 sort-> 1 2 4 (max is 4)
       */
      static void test2() {
            int[] arr = {1,2,3,4,2,3,1,4,2};
            int k = 3;
            double[] expected = {3.00000,4.00000,4.00000,4.00000,3.00000,4.00000,4.00000};
            System.out.println("Arr =" + Arrays.toString(arr));
            System.out.println("k =" + k);
            SlidingWindowMedianMaximum slidingWindowMedian = new SlidingWindowMedianMaximum();
            List<Double> result = slidingWindowMedian.getMediansList(arr, k);
            System.out.println("Expected result =" + Arrays.toString(expected));
            System.out.println("My result =" + result);
      }


      List<Double> getMediansList(int[] arr, int k) {
            List<Double> result = new ArrayList<>();
            int[] medianArr = new int[k];
            for (int i = 0; i < arr.length; i++) {
                  int left = i;
                  int right = i + k;
                  if (right > arr.length) return result;
                  medianArr = getMedianArr(arr,left,right, k);
                  System.out.println(Arrays.toString(medianArr));
                  double median = getMedian(medianArr);
                  result.add(median);
            }
            return result;
      }

      int[] getMedianArr(int[] arr, int start, int finish, int k) {
            int[] result = new int[k];
            int i = 0;
            for ( ; start < finish; start++) {
                  result[i] = arr[start];
                  i++;
            }
            Arrays.sort(result);
            return result;
      }
      /*
             0 1 2 3, length = 4, length/2 = 2
             0 1 2 3 5, length = 5, length/2 = 2
       */
      double getMedian(int[] medianArr) {
            int result = 0;
            result = medianArr[medianArr.length-1];
            return result;
      }
}
