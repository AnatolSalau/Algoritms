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
            //testOne();
            testTwo();
      }

      static List<Double> getMedians(int[] numbers, int k) {
            List<Double> result = new ArrayList<>();

            PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());//maxHeap
            PriorityQueue<Integer> rightHeap = new PriorityQueue<>();//minHeap
            boolean isInitialized = false;
            int start = 0;
            for (int i = 0; i < numbers.length; i++) {
                  int end = i;
                  int length = end - start + 1;

                  //count max lengths of heaps
                  int maxLeftSize = 0;
                  int maxRightSize = 0;

                  if (k % 2 == 0) {
                        maxLeftSize = k/2;
                        maxRightSize = maxLeftSize;
                  } else {
                        maxLeftSize = k/2 + 1;
                        maxRightSize = k/2;
                  }
                  //start element
                  int startElem = numbers[start];

                  // max and mim elements in heaps
                  int leftHeapMax = 0;
                  int rightHeapMin = 0;

                  //initialize heaps and add new elements
                  if (length >= 2 ) {
                        if (isInitialized == false ) {// initialize heaps with start values
                              int leftElement = numbers[start];
                              int rightElement = numbers[end];
                              if (leftElement < rightElement) {
                                    leftHeap.add(leftElement);
                                    rightHeap.add(rightElement);
                              } else {
                                    leftHeap.add(rightElement);
                                    rightHeap.add(leftElement);
                              }
                              isInitialized = true;
                        } else {
                              if (!leftHeap.isEmpty()) {
                                    leftHeapMax = leftHeap.peek();
                              }

                              if (!rightHeap.isEmpty()) {
                                    rightHeapMin = rightHeap.peek();
                              }

                              int newElem = numbers[end];

                              //add new item and balance heaps
                              if (newElem <= leftHeapMax) {
                                    leftHeap.add(newElem);
                              } else {
                                    rightHeap.add(newElem);
                                    if (rightHeap.size() > maxRightSize) {
                                          Integer minInRightHeap = rightHeap.poll();
                                          leftHeap.add(minInRightHeap);
                                    }
                              }

                              // balance heaps
                              while (rightHeap.size() < length / 2) {
                                    rightHeap.add(leftHeap.poll());
                              }

                              while (leftHeap.size() < length / 2) {
                                    leftHeap.add(rightHeap.poll());
                              }
                        }
                  }

                  //remove start element from right heap
                  //balance sizes heaps
                  // and move start index forward
                  if (length >= k) {
                        System.out.println("i : " + i + ", " + Arrays.toString(numbers) + ", k = " + k);
                        for (int j = start; j <= end; j++) {
                              System.out.print(numbers[j] + " ");
                        }

                        if (!leftHeap.isEmpty()) {
                              leftHeapMax = leftHeap.peek();
                        }

                        if (!rightHeap.isEmpty()) {
                              rightHeapMin = rightHeap.peek();
                        }
                        // calculate median value;
                        if (k % 2 == 0) {//k is even
                              double median = leftHeapMax + rightHeapMin /2;
                              result.add(median);
                        } else {// k is odd
                              double median = leftHeapMax;
                              result.add(median);
                        }

                        //remove elements
                        if (startElem <= leftHeapMax) {
                              leftHeap.remove(startElem);
                        } else {
                              rightHeap.remove(startElem);
                        }
                        start ++;
                  }
            }
            return result;
      }
      static void testOne() {
            int[] numbers = {1,2,3,4,2,3,1,4,2};
            double[] expected = {2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000};
            int k = 3;
            System.out.println(Arrays.toString(numbers));
            List<Double> medians = getMedians(numbers, k);
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Result   : " + medians);
      }

      static void testTwo() {
            int[] numbers = {1,3,-1,-3,5,3,6,7};
            double[] expected = {1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000};
            int k = 3;
            System.out.println(Arrays.toString(numbers));
            List<Double> medians = getMedians(numbers, k);
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Result   : " + medians);
      }
}
