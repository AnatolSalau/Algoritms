import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class SolutionTwoHeap {
      Queue<Integer> minHeap;
      Queue<Integer> maxHeap;
      public SolutionTwoHeap(){
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
      }
      private void add(int num){
            //add element to the correct heap
            if(maxHeap.isEmpty() || maxHeap.peek() > num){
                  maxHeap.add(num);
            }else{
                  minHeap.add(num);
            }
            //balance heap
            balance();
      }
      private void balance(){
            if(maxHeap.size() > minHeap.size() + 1){
                  minHeap.add(maxHeap.poll());
            }else if(minHeap.size() > maxHeap.size()){
                  maxHeap.add(minHeap.poll());
            }
      }
      private void remove(int num){
            //remove element from the correct heap
            if(num <= maxHeap.peek()){
                  maxHeap.remove(num);
            }else{
                  minHeap.remove(num);
            }
            //balance heap
            balance();
      }
      private double findMedian(){
            if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
            if(minHeap.size() > maxHeap.size()) return minHeap.peek();
            return maxHeap.peek()/2.0 + minHeap.peek() /2.0;
      }
      public double[] medianSlidingWindow(int[] nums, int k) {
            int start = 0;
            double[] result = new double[nums.length - k + 1 ];

            for(int end=0; end < nums.length; end++) {
                  add(nums[end]);
                  int size = (end - start + 1);
                  if(size == k) {
                        result[start] = findMedian();
                        remove(nums[start]); // remove the start number as we move forward the next window size
                        start++; // move start window ahead
                  }
            }


            return result;
      }

      public static void main(String[] args) {
            SolutionTwoHeap solution = new SolutionTwoHeap();

            int[] arr = {1,2,3,4,2,3,1,4,2};
            int k = 3;
            double[] expected = {2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000};
            System.out.println("Arr =" + Arrays.toString(arr));
            System.out.println("k =" + k);
            double[] result = solution.medianSlidingWindow(arr, k);
            System.out.println("Expected result =" + Arrays.toString(expected));
            System.out.println("My result =" + Arrays.toString(result));
      }
}