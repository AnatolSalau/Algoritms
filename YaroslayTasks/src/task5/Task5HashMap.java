package task5;

import java.util.Arrays;
import java.util.HashMap;

public class Task5HashMap {
      /**
       Делаем словари для быстроты

       Берём ключи заездов и отьездов

       Все в сет

       Повторы удаляеются

       Потом объединяем два сета

       Повторы удаляются

       Сортируем

       На выходе список
       */
      public static void main(String[] args) {
            testThree();
      }
      /*


       */
      static int getQtyIntersections(int[][] numbers) {
            HashMap<Integer, Integer> checkInFreqMap = new HashMap();
            HashMap<Integer, Integer> checkOutFreqMap = new HashMap();

            for (int i = 0; i < numbers.length; i++) {
                  int checkInDay = numbers[i][0];
                  int checkOutDay = numbers[i][1];

                  if (checkInFreqMap.containsKey(checkInDay)) {
                        Integer val = checkInFreqMap.get(checkInDay);
                        val++;
                        checkInFreqMap.put(checkInDay,val);
                  } else {
                        checkInFreqMap.put(checkInDay,1);
                  }

                  if (checkOutFreqMap.containsKey(checkOutDay)) {
                        Integer val = checkOutFreqMap.get(checkOutDay);
                        val++;
                        checkOutFreqMap.put(checkOutDay,val);
                  } else {
                        checkOutFreqMap.put(checkOutDay,1);
                  }
            }

            return 0;
      }

      static void testOne() {
            int[][] numbers = {{20, 23}, {20,22}, {18,19}, {1,5}, {2,18}, {18,19} };
            int expectedResult = 3;
            System.out.println(Arrays.deepToString(numbers));
            int qtyIntersections = getQtyIntersections(numbers);
            System.out.println(Arrays.deepToString(numbers));
            System.out.println("Result : " + qtyIntersections);
            System.out.println("ExpectedResult : " + expectedResult);
      }

      static void testTwo() {
            int[][] numbers = {{1, 5}, {2,18}};
            int expectedResult = 1;
            System.out.println(Arrays.deepToString(numbers));
            int qtyIntersections = getQtyIntersections(numbers);
            System.out.println(Arrays.deepToString(numbers));
            System.out.println("Result : " + qtyIntersections);
            System.out.println("ExpectedResult : " + expectedResult);
      }

      static void testThree() {
            int[][] numbers = {{1, 2}, {1, 3}, {2, 4}, {2, 3}};
            int expectedResult = 3;
            System.out.println(Arrays.deepToString(numbers));
            int qtyIntersections = getQtyIntersections(numbers);
            System.out.println(Arrays.deepToString(numbers));
            System.out.println("Result : " + qtyIntersections);
            System.out.println("ExpectedResult : " + expectedResult);
      }
}
