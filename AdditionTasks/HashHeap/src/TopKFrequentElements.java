import java.util.*;

public class TopKFrequentElements {
      /**
             Given an integer array nums and an integer k,
             return the k most frequent elements.
             You may return the answer in any order.

             Example 1:

             Input: nums = [1,1,1,2,2,3], k = 2
             Output: [1,2]

             Example 2:
             Input: nums = [1], k = 1
             Output: [1]
       */
      public static void main(String[] args) {
            test1();
      }

      static List<Integer> getMostFrequentElements(int[] nums, int k) {
            List<Integer> result = new LinkedList<>();
            Map<Integer,Integer> freqMap = new HashMap();
            TreeMap<Integer,Integer> qtyMap = new TreeMap<>();
            //fill freqMap
            for (int i = 0; i < nums.length; i++) {
                  int current = nums[i];
                  //add to freq map
                  if (freqMap.containsKey(current)) {
                        int val = freqMap.get(current);
                        int newVal = val + 1;
                        //add to qtyMap
                        if (qtyMap.containsKey(val)) {
                              Integer num = qtyMap.get(val);
                              qtyMap.remove(val);
                              qtyMap.put(newVal,current);
                        }

                        //add to freqMap
                        freqMap.put(current,newVal);

                  } else {
                        freqMap.put(current,1);
                        qtyMap.put(1,current);
                  }
            }

            for (int i = 0; i < k; i++) {
                  Map.Entry<Integer, Integer> currMin = qtyMap.pollLastEntry();
                  result.add(currMin.getValue());
            }
            return result;

      }

      static void test1() {
            int[] nums = {1,1,1,1,1,2,3,3};
            int k = 2;
            int[] expected = {1,3};
            System.out.println(Arrays.toString(nums));
            System.out.println("Expected : " + Arrays.toString(expected));
            List<Integer> mostFrequentElements = getMostFrequentElements(nums, k);
            System.out.println(mostFrequentElements);
      }

      static void test2() {
            int[] nums = {1};
            int k = 1;
            int[] expected = {1};
      }
}
