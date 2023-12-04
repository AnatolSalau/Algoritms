package task32;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Task32 {
      /**
       * Найти общее число в трёх коллекциях, не используя дополнительные структуры
       */
      public static void main(String[] args) {
            testOne();
      }

      static void testOne() {
            int[] arr1 = {3,2,1,10};
            int[] arr2 = {4,5,6,7,10};
            int[] arr3 = {8,9,10};
            int generalNumber = getGeneralNumber(arr1, arr2, arr3);
            System.out.println(generalNumber);
      }
      /*
            i
            1 2 3
            j
            3 4 5 6 7
            k
            3 4 5 6

              i
            1 2 3
            j
            3 4 5 6 7
            k
            3 4 5 6
       */
      static int getGeneralNumber(int[] arr1, int[] arr2, int[] arr3) {
            quickSort(arr1,0,arr1.length - 1);
            quickSort(arr2,0,arr2.length - 1);
            quickSort(arr3,0,arr3.length - 1);

            int max = 0;

            int i = 0;
            int j = 0;
            int k = 0;


            while (i < arr1.length && j< arr2.length && k < arr3.length) {
                  int num1 = arr1[i];
                  int num2 = arr2[j];
                  int num3 = arr3[k];

                  if (num1 == num2 && num2 == num3) return num1;

                  max = Math.max(num1,Math.max(num2, num3));

                  if (num1 <= max) {
                        i++;
                        continue;
                  }
                  if (num2 <= max) {
                        j++;
                        continue;
                  }
                  if (num3 <= max) {
                        k++;
                        continue;
                  }
            }
            return max;
      }

      static void quickSort(int[] array, int startIndex, int endIndex) {
            if(endIndex<= startIndex) return; //base case

            int pivotIndex = partition(array,startIndex, endIndex);

            quickSort(array,startIndex,pivotIndex - 1);
            quickSort(array,pivotIndex +1,endIndex);
      }

      static int partition(int[] array, int startIndex, int endIndex) {
            int pivot = array[endIndex];
            int i = startIndex - 1;

            for (int j = startIndex; j <= endIndex - 1; j++) {
                  if(array[j] < pivot) {
                        i++;
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                  }
            }
            i++;
            int temp = array[i];
            array[i] = array[endIndex];
            array[endIndex] = temp;

            return i;
      }
}
