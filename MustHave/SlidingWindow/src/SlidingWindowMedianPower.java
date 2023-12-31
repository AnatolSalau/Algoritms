import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class SlidingWindowMedianPower {
      /**
       O(nklogk) - power metod
       */
      /**
             The median is the middle value in an ordered integer list.
             If the size of the list is even, there is no middle value.
             So the median is the mean of the two middle values.

             For examples, if arr = [2,3,4], the median is 3.
             For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
             You are given an integer array nums and an integer k.
             There is a sliding window of size k
             which is moving from the very left of the array to the very right.
             You can only see the k numbers in the window.
             Each time the sliding window moves right by one position.

             Return the median array for each window in the original array.
             Answers within 10^-5 of the actual value will be accepted.

             Example 1:
             Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
             Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
             Explanation:
             Window position                Median
             ---------------                -----
             [1  3  -1] -3  5  3  6  7       1
             1 [3  -1  -3] 5  3  6  7       -1
             1  3 [-1  -3  5] 3  6  7       -1
             1  3  -1 [-3  5  3] 6  7        3
             1  3  -1  -3 [5  3  6] 7        5
             1  3  -1  -3  5 [3  6  7]       6

             Example 2:
             Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
             Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
       */

      public static void main(String[] args) {

            test1();
            test2();
      }

      /*
            2 3 3 5 7 10 - 4 (even length (3+5)/2 = median is 4

            1,3,-1,-3,5,3,6,7   k=3

            1 3 -1  sort->  -1 1 3 (median is 1)
            3  -1  -3 sort-> -3 -1 3 (median is -1)
            -1  -3  5 sort-> -3 -1 5 (median is -1)
            -3  5  3 sort-> -3 3 5 (median is 3)
            5  3  6 sort-> 3 5 6 (median is 5)
            3  6  7 sort-> 3 6 7 (median is 6)
      */
      /*
            1,3,-1,-3,5,3,6,7   k=3 maxHeap     minHeap
            1 3 -1                  -1         13          (median is 1)
              3 -1 -3                  -3         -13          (median is -1)
                -1 -3 5                  -3         -15          (median is -1)
                   -3 5 3                  -3          35          (median is 3)
                      5 3 6                   3          56          (median is 5)
                        3 6 7                   3          67          (median is 6)
           1,3,-1,-3,5,3,6,7

           -1 1 3

       */
      static void test1() {
            int[] arr = {1,3,-1,-3,5,3,6,7};
            int k = 3;
            double[] expected = {1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000};
            System.out.println("Arr =" + Arrays.toString(arr));
            System.out.println("k =" + k);
            SlidingWindowMedianPower slidingWindowMedian = new SlidingWindowMedianPower();
            List<Double> result = slidingWindowMedian.getMediansList(arr, k);
            System.out.println("Expected result =" + Arrays.toString(expected));
            System.out.println("My result =" + result);
      }
      /*
            1 2 3 4 2 3 1 4 2  k=3

            1 2 3 sort-> 1 2 3 (median is 2)
            2 3 4 sort-> 2 3 4 (median is 3)
            3 4 2 sort-> 2 3 4 (median is 3)
            4 2 3 sort-> 2 3 4 (median is 3)
            2 3 1 sort-> 1 2 3 (median is 2)
            3 1 4 sort-> 1 3 4 (median is 3)
            1 4 2 sort-> 1 2 4 (median is 2)
       */
      static void test2() {
            int[] arr = {1,2,3,4,2,3,1,4,2};
            int k = 3;
            double[] expected = {2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000};
            System.out.println("Arr =" + Arrays.toString(arr));
            System.out.println("k =" + k);
            SlidingWindowMedianPower slidingWindowMedian = new SlidingWindowMedianPower();
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
            if (medianArr.length % 2 == 0) { // even number
                  result = (medianArr[medianArr.length/2] + medianArr[medianArr.length/2 - 1]) / 2;
            } else { //odd number
                  result = (medianArr[medianArr.length/2]);
            }
            return result;
      }
}
