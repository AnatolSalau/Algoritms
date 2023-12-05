package task1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GetAllIntersection {
      /**
       Даны два массива: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]
       Надо вернуть [1, 2, 2, 3] (порядок неважен)
       */
      public static void main(String[] args) {
            testOne();
      }

      static List<Integer> getAllIntersections(int[] arr1, int[] arr2) {
            List<Integer> result = new LinkedList<>();
            HashMap<Integer, Integer> arr1FrequencyMap = new HashMap<>();

            for (int i = 0; i < arr1.length; i++) {
                  int curr = arr1[i];
                  if(arr1FrequencyMap.containsKey(curr)) {
                        Integer val = arr1FrequencyMap.get(curr);
                        val += 1;
                        arr1FrequencyMap.put(curr,val);
                  } else {
                        arr1FrequencyMap.put(curr,1);
                  }
            }

            for (int i = 0; i < arr2.length; i++) {
                  int curr = arr2[i];
                  if (arr1FrequencyMap.containsKey(curr)) {
                        Integer val = arr1FrequencyMap.get(curr);
                        for (int j = 0; j < val ; j++) {
                              result.add(curr);
                        }
                        arr1FrequencyMap.remove(curr);
                  }
            }

            return result;
      }
      static void testOne() {
            int[] arr1 = {1, 2, 3, 2, 0};
            int[] arr2 = {5, 1, 2, 7, 3, 2};
            List<Integer> allIntersections = getAllIntersections(arr1, arr2);
            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
            System.out.println(allIntersections);
      }
}
