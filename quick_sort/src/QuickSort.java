import java.util.Arrays;

public class QuickSort {

      public static void main(String[] args) {
            //int[] array = new int[]{64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
            int[] array = { 10, 7, 8, 9, 1};

            System.out.println("array before : " + Arrays.toString(array));

            quickSort(array, 0, array.length - 1);

            System.out.println("array after : " + Arrays.toString(array));
      }

      public static void quickSort(int[] arr, int beginIndex, int endIndex) {
            int beginNumber = arr[beginIndex];
            int endNumber = arr[endIndex];

            System.out.println("quickSort started : " + Arrays.toString(arr) +
                  ", beginIndex = " + beginIndex +
                  " (beginNumber " + beginNumber +
                  "), endIndex = " + endIndex +
                  " (endNumber " + endNumber +
                  ")");
            if (beginIndex < endIndex) {
                  int divideIndex = partition(arr, beginIndex, endIndex);
                  int divideNumber = arr[divideIndex];
                  System.out.println("beginIndex < endIndex, divideIndex = " + divideIndex +
                  ", (divideNumber " + divideNumber + ")");
                  quickSort(arr, beginIndex, divideIndex - 1);

                  quickSort(arr, divideIndex, endIndex);
            }
      }

      private static int partition(int[] arr, int beginIndex, int endIndex) {
            int rightIndex = endIndex;
            int leftIndex = beginIndex;

            int pivot = arr[beginIndex + (endIndex - beginIndex) / 2];

            int leftNumber = arr[leftIndex];
            int rightNumber = arr[rightIndex];

            System.out.println("partition started : " + Arrays.toString(arr) +
                  ", leftIndex = " + leftIndex +
                  " (leftNumber " + leftNumber +
                  "), rightIndex = " + rightIndex +
                  " (rightNumber " + rightNumber +
                  ")" +
                  ", pivotNumber = " + pivot);

            while (leftIndex <= rightIndex) {

                  while (arr[leftIndex] < pivot) {
                        leftIndex++;
                        System.out.println("leftIndex++, (leftIndex = " + leftIndex + ", leftNumber = " + arr[leftIndex] + ")");
                  }

                  while (arr[rightIndex] > pivot) {
                        rightIndex--;
                        System.out.println("rightIndex--, (rightIndex = " + rightIndex + ", rightNumber = " + arr[rightIndex] + ")");
                  }

                  if (leftIndex <= rightIndex) {
                        System.out.println("leftIndex <= rightIndex");
                        swap(arr, rightIndex, leftIndex);
                        leftIndex++;
                        rightIndex--;
                        System.out.println("leftIndex++, (leftIndex = " + leftIndex + ")");
                        System.out.println("rightIndex--, (rightIndex = " + rightIndex + ")");
                  }
            }
            return leftIndex;
      }

      private static void swap(int[] arr, int index1, int index2) {

            int index1Number = arr[index1];
            int index2Number = arr[index2];
            System.out.println("swap started : " + Arrays.toString(arr) +
                  ", index1 = " + index1 +
                  " (index1Number " + index1Number +
                  "), index2 = " + index2 +
                  " (index2Number " + index2Number + ")");
            int tmp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = tmp;
      }
}
