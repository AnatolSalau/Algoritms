import java.util.Arrays;

public class QuickSort2 {
      public static void main(String[] args) {
            //int[] array = new int[]{64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
            int[] array = { 4, 5, 7, 1, 8, 9};
            /*

             */
            System.out.println("array before : " + Arrays.toString(array));

            quickSort(array, 0, array.length - 1);

            System.out.println("array after : " + Arrays.toString(array));
      }

      public static void quickSort(int[] arr, int beginIndex, int endIndex) {
            System.out.println("sort started : beginIndex("+arr[beginIndex]+") = endIndex("+arr[endIndex]+") " + Arrays.toString(arr));
            if (beginIndex < endIndex) {
                  int divideIndex = partition(arr, beginIndex, endIndex);

                  quickSort(arr, beginIndex, divideIndex - 1);
                  quickSort(arr, divideIndex, endIndex);
            } else {
                  System.out.println("sort finished : beginIndex("+arr[beginIndex]+") = endIndex("+arr[endIndex]+"), array don't need to sort "+ Arrays.toString(arr));
            }
      }

      private static int partition(int[] arr, int beginIndex, int endIndex) {
            int rightIndex = endIndex;
            int leftIndex = beginIndex;

            int pivot = arr[beginIndex + (endIndex - beginIndex) / 2];

            System.out.println("    partition started : left("+arr[beginIndex]+") = right("+arr[endIndex]+"), pivot = " + pivot + " " + Arrays.toString(arr));
            while (leftIndex <= rightIndex) {

                  while (arr[leftIndex] < pivot) {
                        leftIndex++;
                  }

                  while (arr[rightIndex] > pivot) {
                        rightIndex--;
                  }

                  if (leftIndex <= rightIndex) {
                        if (leftIndex != rightIndex) {
                              System.out.println("left("+arr[leftIndex]+") <= right("+arr[rightIndex]+") swap started " +  Arrays.toString(arr));
                              swap(arr, rightIndex, leftIndex);
                        } else {
                              System.out.println("left("+arr[leftIndex]+") = right("+arr[rightIndex]+") swap is not needed " + Arrays.toString(arr));
                        }
                        leftIndex++;
                        rightIndex--;
                  }
            }
            return leftIndex;
      }

      private static void swap(int[] arr, int index1, int index2) {
            int tmp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = tmp;
      }
}
