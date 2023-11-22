import java.util.*;

public class MedianTwoHeap {
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
            testOne();
      }
      static List<Double> getMedians(int[] numbers, int k) {
            List<Double> result = new ArrayList<>();

            PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());//maxHeap
            PriorityQueue<Integer> rightHeap = new PriorityQueue<>();//minHeap

            int start = 0;
            for (int i = 0; i < numbers.length; i++) {
                  int end = i;
                  int length = end - start + 1;


                  if (length >= 2 && length <= k) {
                        if (length == 2 ) {// initialize heaps with start values
                              int leftElement = numbers[start];
                              int rightElement = numbers[end];
                              if (leftElement < rightElement) {
                                    leftHeap.add(leftElement);
                                    rightHeap.add(rightElement);
                              } else {
                                    leftHeap.add(rightElement);
                                    rightHeap.add(leftElement);
                              }
                        } else {
                              int leftHeapMax = leftHeap.peek();
                              int rightHeapMin = rightHeap.peek();
                              System.out.println();

                              int newElem = numbers[end];
                              //balance size of heaps
                              int maxLeftSize = 0;
                              int maxRightSize = 0;

                              if (k % 2 == 0) {
                                    maxLeftSize = k/2;
                                    maxRightSize = maxLeftSize;
                              } else {
                                    maxLeftSize = k/2 + 1;
                                    maxRightSize = k/2;
                              }
                              int startElem = numbers[start];
                              if (newElem <= leftHeapMax) {
                                    leftHeap.add(newElem);

                                    if (leftHeap.size() > maxLeftSize) leftHeap.remove(startElem);
                              } else {
                                    rightHeap.add(newElem);
                                    if (rightHeap.size() > maxRightSize) {
                                          Integer minInRightHeap = rightHeap.poll();
                                          leftHeap.add(minInRightHeap);
                                          if (leftHeap.size() > maxLeftSize) leftHeap.remove(startElem);
                                    }
                              }
                        }
                  }
                  System.out.println();

                  if (length >= k) start ++;
            }

            return null;

      }
      static void testOne() {
            int[] numbers = {1,2,3,4,2,3,1,4,2};
            double[] expected = {2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000};
            int k = 4;
            System.out.println(Arrays.toString(numbers));
            System.out.println("Expected : " + Arrays.toString(expected));
            List<Double> medians = getMedians(numbers, k);
            System.out.println("Result : " + medians);
      }
}
