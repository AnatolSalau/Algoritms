import java.util.*;

public class FourSumFindAllUnique {
      /**
             Input: array = {10, 2, 3, 4, 5, 9, 7, 8}, X = 23
             Output: 3 5 7 8
             Explanation: Sum of output is equal to 23, i.e. 3 + 5 + 7 + 8 = 23.

             Input: array = {1, 2, 3, 4, 5, 9, 7, 8}, X = 16
             Output: 1 3 5 7
             Explanation: Sum of output is equal to 16, i.e. 1 + 3 + 5 + 7 = 16.
       */
      public static void main(String[] args) {
            test1();
            //test2();
            //test3();
      }

      /**
             Input: array = {10, 2, 3, 4, 5, 9, 7, 8}, X = 23
             Output: 3 5 7 8
             Explanation: Sum of output is equal to 23, i.e. 3 + 5 + 7 + 8 = 23.
       */
      /*
            5 -> [1, 2]
            6 -> [1, 3]
            7 -> [1, 4, 2, 3]
            8 -> [2, 4]
            9 -> [1, 6, 3, 4]
            10 -> [1, 7, 2, 6]
            11 -> [1, 5, 2, 7, 3, 6]
            12 -> [0, 1, 2, 5, 3, 7, 4, 6]
            13 -> [0, 2, 3, 5, 4, 7]
            14 -> [0, 3, 4, 5]
            15 -> [0, 4, 6, 7]
            16 -> [5, 6]
            17 -> [0, 6, 5, 7]
            18 -> [0, 7]
            19 -> [0, 5]
       */
      static void test1() {
            int [] arr1 = {10, 2, 3, 4, 5, 9, 7, 8};
            int target = 23;
            FourSumFindAllUnique fourSumFindAnyone = new FourSumFindAllUnique();
            Map<Integer, ArrayList<Integer>> integerArrayListMap = fourSumFindAnyone.getMapAllSumPairIndexes(arr1);
            fourSumFindAnyone.printMap(integerArrayListMap);
            List<List<Integer>> quadrupletsIsEqualTarget = fourSumFindAnyone.getQuadrupletsIsEqualTarget(arr1, integerArrayListMap, target);
            Set<List<Integer>> quadrupletsWithoutDublucates = fourSumFindAnyone.removeAllArrWithDublicates(quadrupletsIsEqualTarget);
            System.out.println("quadrupletsIsEqualTarget : ");
            System.out.println(quadrupletsIsEqualTarget);
            System.out.println("quadrupletsWithoutDublucates : ");
            fourSumFindAnyone.printArrElem(quadrupletsWithoutDublucates,arr1);
      }

      /**
             Input: nums = [1,0,-1,0,-2,2], target = 0
             Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
       */
      /*    Condition :
            i: 0 1  2 3  4 5
              [1,0,-1,0,-2,2]

            Result:
            i : 4  2 0 5   4  1 3 5    2 1 3 0
             [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

            0 -> [0, 2, 1, 3, 4, 5]
           -1 -> [0, 4, 1, 2, 2, 3]
            1 -> [0, 1, 0, 3, 2, 5]
           -2 -> [1, 4, 3, 4]
            2 -> [1, 5, 3, 5]
           -3 -> [2, 4]
            3 -> [0, 5]
       */
      static void test2() {
            int [] arr1 = {1,0,-1,0,-2,2};
            int target = 0;
            FourSumFindAllUnique fourSumFindAnyone = new FourSumFindAllUnique();
            Map<Integer, ArrayList<Integer>> integerArrayListMap = fourSumFindAnyone.getMapAllSumPairIndexes(arr1);
            fourSumFindAnyone.printMap(integerArrayListMap);
            List<List<Integer>> quadrupletsIsEqualTarget = fourSumFindAnyone.getQuadrupletsIsEqualTarget(arr1, integerArrayListMap, target);
            Set<List<Integer>> quadrupletsWithoutDublucates = fourSumFindAnyone.removeAllArrWithDublicates(quadrupletsIsEqualTarget);
            System.out.println("quadrupletsIsEqualTarget : ");
            System.out.println(quadrupletsIsEqualTarget);
            System.out.println("quadrupletsWithoutDublucates : ");
            fourSumFindAnyone.printArrElem(quadrupletsWithoutDublucates,arr1);
      }
      Map<Integer, ArrayList<Integer>> getMapAllSumPairIndexes(int[] arr) {
            Map<Integer, ArrayList<Integer>> result = new HashMap<>();
            //run through all pairs
            for (int i = 0; i < arr.length - 1; i++) {
                  for (int j = i+1; j < arr.length; j++) {
                        int sum = arr[i] + arr[j];
                        if (result.containsKey(sum)) {
                              ArrayList<Integer> valArr = result.get(sum);
                              valArr.add(i);
                              valArr.add(j);
                              result.put(sum,valArr);
                        } else {
                              ArrayList<Integer> valArr = new ArrayList<>();
                              valArr.add(i);
                              valArr.add(j);
                              result.put(sum, valArr);
                        }
                  }
            }
            return result;
      }
      /*

       */
      static  void test3() {
            int [] arr1 = {1, 2, 3, -1};
            int target = 5;
            FourSumFindAllUnique fourSumFindAnyone = new FourSumFindAllUnique();
            Map<Integer, ArrayList<Integer>> integerArrayListMap = fourSumFindAnyone.getMapAllSumPairIndexes(arr1);
            fourSumFindAnyone.printMap(integerArrayListMap);
            List<List<Integer>> quadrupletsIsEqualTarget = fourSumFindAnyone.getQuadrupletsIsEqualTarget(arr1, integerArrayListMap, target);
            Set<List<Integer>> quadrupletsWithoutDublucates = fourSumFindAnyone.removeAllArrWithDublicates(quadrupletsIsEqualTarget);
            System.out.println("quadrupletsIsEqualTarget : ");
            System.out.println(quadrupletsIsEqualTarget);
            System.out.println("quadrupletsWithoutDublucates : ");
            fourSumFindAnyone.printArrElem(quadrupletsWithoutDublucates,arr1);
      }
      /*
            [0, 1, 0, 4],
            [0, 1, 1, 2],
            [0, 1, 2, 3],
            [0, 2, 0, 2],
            [0, 2, 1, 3],
            [0, 2, 4, 5],
            [0, 3, 0, 4],
            [0, 3, 1, 2],
            [0, 3, 2, 3],
            [0, 4, 0, 1],
            [0, 4, 0, 3],
            [0, 4, 2, 5],
            [0, 5, 2, 4],
            [1, 2, 0, 1],
            [1, 2, 0, 3],
            [1, 2, 2, 5],
            [1, 3, 0, 2],
            [1, 3, 1, 3],
            [1, 3, 4, 5],
            [1, 4, 1, 5],
            [1, 4, 3, 5],
            [1, 5, 1, 4],
            [1, 5, 3, 4],
            [2, 3, 0, 1],
            [2, 3, 0, 3],
            [2, 3, 2, 5],
            [2, 4, 0, 5],
            [2, 5, 0, 4],
            [2, 5, 1, 2],
            [2, 5, 2, 3],
            [3, 4, 1, 5],
            [3, 4, 3, 5],
            [3, 5, 1, 4],
            [3, 5, 3, 4],
            [4, 5, 0, 2],
            [4, 5, 1, 3],
            [4, 5, 4, 5]]

       */
      List<List<Integer>> getQuadrupletsIsEqualTarget (int[] arr, Map<Integer, ArrayList<Integer>> mapAllSumPairIndexes, int target) {
            List<List<Integer>> allQuadruplets = new ArrayList<>();
            for (int i = 0; i < arr.length - 1; i++) {
                  for (int j = i+1; j < arr.length; j++) {
                        int sum = arr[i] + arr[j];
                        int remainder = target - sum;
                        if (mapAllSumPairIndexes.containsKey(remainder)) {
                              ArrayList<Integer> arrayList = mapAllSumPairIndexes.get(remainder);
                              for (int k = 0; k < arrayList.size(); k+=2) {
                                    ArrayList<Integer> result = new ArrayList<>();
                                    result.add(i);
                                    result.add(j);
                                    result.add(arrayList.get(k));
                                    result.add(arrayList.get(k+1));
                                    allQuadruplets.add(result);
                              }
                        }
                  }
            }
            return allQuadruplets;
      }

      Set<List<Integer>> removeAllArrWithDublicates(List<List<Integer>>  arrays) {
            Set<List<Integer>> result = new HashSet<>();

            for (List<Integer> arr : arrays) {
                  Set<Integer> integerSet = Set.copyOf(arr);
                  if (arr.size() == integerSet.size()) {
                        Collections.sort(arr);
                        result.add(arr);
                  }
            }
            return result;
      }

      void printMap(Map<Integer, ArrayList<Integer>> mapAllSumPairIndexes) {
            mapAllSumPairIndexes.entrySet().forEach(
                  (entry) -> {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                  }
            );
      }
      void  printArrElem(Set<List<Integer>> quadrupletsWithoutDublucates, int[] arr) {
            for (List<Integer> list : quadrupletsWithoutDublucates) {
                  for (Integer integer : list) {
                        System.out.print(arr[integer] + " ");
                  }
                  System.out.println();
            }
      }
}
