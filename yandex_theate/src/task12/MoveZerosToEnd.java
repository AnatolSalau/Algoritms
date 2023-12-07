package task12;

import java.util.Arrays;

public class MoveZerosToEnd {
      /**
       Перенести нули в конец массива, сохранив порядок остальных элементов

       [1,0,8,9] → [1,8,9,0]
       */
      public static void main(String[] args) {
            testOne();
            testTwo();
      }
      /*
        for
          i:0  1  2  3
            1, 0, 8, 9        count = 0
            i
            curr = 1 -> arr[0] = arr[0] -> 1, 0, 8, 9, count ++

          i:0  1  2  3
            1, 0, 8, 9        count = 1
               i
            curr = 0

          i:0  1  2  3
            1, 0, 8, 9        count = 1
                  i
            curr = 8-> arr[1] = arr[2] -> 1, 8, 8, 9, count ++

          i:0  1  2  3
            1, 0, 8, 9        count = 2
                     i
            curr = 9-> arr[2] = arr[3] -> 1, 8, 9, 9, count ++

            count = 3
         while
            arr[3] = 0
       */
      public static void testOne() {
            int[] nums = {1,0,8,9};
            int[] expectedResult = {1,8,9,0};
            System.out.println(Arrays.toString(nums));
            System.out.println(Arrays.toString(expectedResult));
            pushZerosToEnd(nums);
            System.out.println(Arrays.toString(nums));
            System.out.println();
      }
      /*
      for
        i:0  1  2  3  4  5  6
          0, 1, 0, 0, 8, 0, 9
          i
          count = 0, curr = 0,

        i:0  1  2  3  4  5  6
          0, 1, 0, 0, 8, 0, 9
             i
          count = 0, curr = 1, -> 1 1 0 0 8 0 9, count ++

        i:0  1  2  3  4  5  6
          1, 1, 0, 0, 8, 0, 9
                i
          count = 1, curr = 0

        i:0  1  2  3  4  5  6
          1, 1, 0, 0, 8, 0, 9
                   i
          count = 1, curr = 0

        i:0  1  2  3  4  5  6
          1, 1, 0, 0, 8, 0, 9
                      i
          count = 1, curr = 8, -> 1 8 0 0 8 0 9, count ++

        i:0  1  2  3  4  5  6
          1, 8, 0, 0, 8, 0, 9
                         i
          count = 2, curr = 8

        i:0  1  2  3  4  5  6
          1, 8, 0, 0, 8, 0, 9
                            i
          count = 2, curr = 9 -> 1 8 9 0 8 0 9, count ++

          while
          count = 3
          putt all 0 from i = 3 to end
       */
      public static void testTwo() {
            int[] nums = {0,1,0,0,8,0,9};
            int[] expectedResult = {1,8,9,0,0,0,0};
            System.out.println(Arrays.toString(nums));
            System.out.println(Arrays.toString(expectedResult));
            pushZerosToEnd(nums);
            System.out.println(Arrays.toString(nums));
            System.out.println();
      }

      static void pushZerosToEnd(int arr[])
      {
            int count = 0;

            for (int i = 0; i < arr.length; i++) {
                  int curr = arr[i];
                  if (curr != 0) {
                        arr[count] = arr[i];
                        count++;
                  }
            }

            while (count < arr.length) {
                  arr[count] = 0;
                  count ++;
            }
      }
}
