package task5;

import java.util.Arrays;

public class CheckInCheckOutIntersections {
      /**
       *
       */
      public static void main(String[] args) {
            testThree();
      }

      static void testThree() {
            int[][] numbers = {{1, 2}, {1, 3}, {2, 4}, {2, 3},};
            int expectedResult = 3;
            System.out.println(Arrays.deepToString(numbers));
            int qtyIntersections = getQtyIntersections(numbers);
            System.out.println(Arrays.deepToString(numbers));
            System.out.println("Result : " + qtyIntersections);
            System.out.println("ExpectedResult : " + expectedResult);
      }
      static int getQtyIntersections(int[][] numbers) {
            quickSortMultipleArr(numbers, 0, numbers.length - 1);
            int countIntersections = 0;
            int maxDayLeft = 0;
            for (int i = 1; i < numbers.length; i++) {
                  int lastDayLeftRange = numbers[i - 1][1];
                  int firstDayRightRange = numbers[i][0];
                  maxDayLeft = Math.max(maxDayLeft, lastDayLeftRange);
                  if (maxDayLeft > firstDayRightRange) countIntersections++;
            }

            return countIntersections;
      }
      static void quickSortMultipleArr(int[][] numbers, int startIndex, int endIndex) {
            if(startIndex >= endIndex) return;

            int pivotIndex = partition(numbers, startIndex, endIndex);

            quickSortMultipleArr(numbers,startIndex,pivotIndex - 1);
            quickSortMultipleArr(numbers,pivotIndex +1,endIndex);
      }

      static int partition(int[][] numbers, int startIndex, int endIndex) {
            int i = startIndex - 1;

            int pivot = numbers[endIndex][0];

            for (int j = startIndex; j <= endIndex - 1; j++) {

                  if (numbers[j][0] < pivot) {
                        i++;
                        int temp0 = numbers[i][0];
                        int temp1 = numbers[i][1];
                        numbers[i][0] = numbers[j][0];
                        numbers[i][1] = numbers[j][1];
                        numbers[j][0] = temp0;
                        numbers[j][1] = temp1;
                  }
            }
            i ++;
            int temp0 = numbers[endIndex][0];
            int temp1 = numbers[endIndex][1];
            numbers[endIndex][0] = numbers[i][0];
            numbers[endIndex][1] = numbers[i][1];
            numbers[i][0] = temp0;
            numbers[i][1] = temp1;
            return i;
      }
}
