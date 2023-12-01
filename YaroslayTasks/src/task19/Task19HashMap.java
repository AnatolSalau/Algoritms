package task19;

import java.util.*;

public class Task19HashMap {
      /**
       * Вернуть все дубликаты которые встречаются среди первого или второго
       * массива.
       * Дубликатами считаются числа, которые находятся либо в одинаковых,
       * либо в разных массивах.
       * Дубликаты должны быть возвращены в том же порядке в котором они
       * встречаются сначала в первом массиве, затем во втором
       * Например:
       * a = [4, 4, 3, 9, 8]
       * b = [2, 1, 2, 9]
       * Ожидаемый результат:
       * [4, 4, 9, 2, 2, 9]
       */
      public static void main(String[] args) {
            testOne();
      }

      private static void testOne() {
            int[] nums1 = {4, 4, 3, 9, 8};
            int[] nums2 = {2, 1, 2, 9};
            int[] expectedResult = {4, 4, 9, 2, 2, 9};
            Task19HashMap task19 = new Task19HashMap();
            List<Integer> allDublicates = task19.getAllDublicates(nums1, nums2);
            System.out.println("Result : " + allDublicates);
            System.out.println("Expect : " + Arrays.toString(expectedResult));
      }

      private List<Integer> getAllDublicates(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> freqMap = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                  int curr = nums1[i];
                  if (freqMap.containsKey(curr)) {
                        Integer val = freqMap.get(curr);
                        val += 1;
                        freqMap.put(curr, val);
                  } else {
                        freqMap.put(curr, 1);
                  }
            }
            for (int i = 0; i < nums2.length; i++) {
                  int curr = nums2[i];
                  if (freqMap.containsKey(curr)) {
                        Integer val = freqMap.get(curr);
                        val += 1;
                        freqMap.put(curr, val);
                  } else {
                        freqMap.put(curr, 1);
                  }
            }
            for(Integer key : freqMap.keySet().toArray(Integer[]::new)) {
                  if (freqMap.get(key) == 1) {
                        freqMap.remove(key);
                  }
            }

            List<Integer> result = new LinkedList<>();
            for (int i = 0; i < nums1.length; i++) {
                  int curr = nums1[i];
                  if (freqMap.containsKey(curr)) {
                        Integer val = freqMap.get(curr);
                                    result.add(curr);
                                    val -= 1;
                                    freqMap.put(curr,val);
                  }
            }

            for (int i = 0; i < nums2.length; i++) {
                  int curr = nums2[i];
                  if (freqMap.containsKey(curr)) {
                        Integer val = freqMap.get(curr);
                                    result.add(curr);
                                    val -= 1;
                                    freqMap.put(curr,val);
                  }
            }
            return result;
      }
}
