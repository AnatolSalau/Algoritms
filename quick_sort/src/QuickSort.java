import java.util.Arrays;

public class QuickSort {
      public static void main(String[] args) {
            int[] arr = {4, 5, 7, 1, 8, 9};
            quickSort(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));
            // 1 - 1 4 3 2 5
            // 5 - 1 4 3 2 5
            // 2 - 1 2 3 4 5
      }

      private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
            //exit from recursion
            if(leftIndex >= rightIndex) return;

            int pivotIndex = partition(arr, leftIndex, rightIndex);
            //run quickSort for left part of arr
            quickSort(arr, leftIndex, pivotIndex - 1);

            //run quickSort for right part of arr
            quickSort(arr, pivotIndex+1, rightIndex);
      }

      private static int partition(int[] arr, int leftIndex, int rightIndex) {
           int pivot = arr[rightIndex];
           int pointerIndex = leftIndex - 1;

            for (int i = leftIndex; i < rightIndex; i++) {
                  if(arr[i] < pivot) {
                       pointerIndex++;
                       swap(arr, pointerIndex, i);
                  }
            }
            //swap last element in arr
            swap(arr, pointerIndex + 1, rightIndex);
            int sout = arr[pointerIndex + 1];
            System.out.println("Return" + sout );
            return pointerIndex + 1;
      }

      private static void swap(int[] arr, int pointerIndex, int i) {
            int temp = arr[i];
            arr[i] = arr[pointerIndex];
            arr[pointerIndex] = temp;
      }
}
