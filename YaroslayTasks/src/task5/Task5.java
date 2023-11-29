package task5;

import java.util.Arrays;

public class Task5 {
      /**
             Дан массив каждый элемент массива это два числа первое число это день заезда
       второе день выезда нужно найти количество элементов у которых есть
       пересечения причем если одна пара 1-5 а вторая 5-1 то это не считается
       пересечением, а считается пересечением 1-5 и допустим 2-18.

       */
      public static void main(String[] args) {
            testOne();
            testTwo();
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
      /*
            [1, 5], [2, 18], [18, 19], [18, 19], [20, 23], [20, 22]
                l    r                                               1
                         l    r
                                   l    r                            1
                                             l    r
                                                       l    r        1
       */
      static int getQtyIntersections(int[][] numbers) {
            bubbleSortMultipleArr(numbers);
            int countIntersections = 0;
            for (int i = 1; i < numbers.length; i++) {
                  int lastDayLeftRange = numbers[i - 1][1];
                  int firstDayRightRange = numbers[i][0];
                  if (lastDayLeftRange > firstDayRightRange) countIntersections++;
            }

            return countIntersections;
      }

      static void bubbleSortMultipleArr(int[][] numbers) {
            for (int i = 0; i < numbers.length - 1; i++) {
                  for (int j = i; j < numbers.length; j++) {
                        if (numbers[i][0] > numbers[j][0]) {
                              int temp0 = numbers[j][0];
                              int temp1 = numbers[j][1];
                              numbers[j][0] = numbers[i][0];
                              numbers[j][1] = numbers[i][1];
                              numbers[i][0] = temp0;
                              numbers[i][1] = temp1;
                        }
                  }
            }
      }
}
