package task8;

import java.util.*;

public class Task8 {
      /**
       Your distributeEvenly function will take an array as an argument and needs to return a new array with the values distributed evenly.

       Example 1:
       Argument: ['one', 'one', 'two', 'two', 'three', 'three', 'four', 'four']
       Result: ['one', 'two', 'three', 'four', 'one', 'two', 'three', 'four']

       Example 2:
       Argument: ['one', 'one', 'one', 'one', 'one', 'two', 'three']
       Result: [ 'one', 'two', 'three', 'one', 'one', 'one', 'one' ]
       */
      /*
            const distributeEvenly = (array) => {
              const map = new Map();
              const res = [];

              for(x of array) {
                if(!map.has(x)) {
                  map.set(x, 0);
                }
                map.set(x, map.get(x) + 1)
              }

              while(map.size > 0) {
                for(let [k, v] of map) {
                  res.push(k);
                  map.set(k, v - 1);
                  if(v - 1 == 0){
                    map.delete(k);
                  }
                }
              }

              return res;
            };
       */
      public static void main(String[] args) {
            test1();
            test2();
            test3();
      }

      public static String[] distributeEvenly(String[] arr) {
            Map<String,Integer> countsMap = new LinkedHashMap<>();
            //add qty of words in countsMap
            for (String str : arr) {
                  countsMap.put(str, 1 + countsMap.getOrDefault(str, 0));
            }

            List<String> result = new ArrayList<>();
            //run loop for while map is not empty
            while ( !countsMap.isEmpty() ) {
                  //run one time through countMap
                  for (String key : countsMap.keySet().toArray(String[]::new)) {
                        result.add(key);
                        int curQty = countsMap.get(key);
                        if (  curQty > 1 ) { // if qty more than 1 to minus qty
                              countsMap.put(key, curQty - 1);
                        }
                        else { // remove from qtyMap when qty is 1
                              countsMap.remove(key);
                        }
                  }
            }
            return result.toArray(String[]::new);
      }

      static void test1() {
            String[] arr = {"one", "one", "two", "two", "three", "three", "four", "four"};
            System.out.println(Arrays.toString(arr));
            String[] results = distributeEvenly(arr);
            System.out.println(Arrays.toString(results));
            System.out.println("Expected result : " + "'one', 'two', 'three', 'four', 'one', 'two', 'three', 'four'");
            System.out.println();
      }

      static void test2() {
            String[] arr = {"one", "one", "one", "one", "one", "two", "three"};
            System.out.println(Arrays.toString(arr));
            String[] results = distributeEvenly(arr);
            System.out.println(Arrays.toString(results));
            System.out.println("Expected result : " + "'one', 'two', 'three', 'one', 'one', 'one', 'one'");
      }

      static void test3() {
            String[] arr = {"1","1","1","2","2","3"};
            System.out.println(Arrays.toString(arr));
            String[] results = distributeEvenly(arr);
            System.out.println(Arrays.toString(results));
            System.out.println("Expected result : " + "1, 2, 3, 1, 2, 1");
      }
}
