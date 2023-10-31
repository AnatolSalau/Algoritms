import java.util.Arrays;
/**
 * O n*lon(n)
 */
public class QuickSort {
      public static void main(String[] args) {
            int[] array = {8, 2, 5, 3, 9, 4, 7, 6, 1};

            System.out.println("After before : " + Arrays.toString(array));

            quickSort(array, 0, array.length - 1);

            System.out.println("After after : " + Arrays.toString(array));
      }

      private static void quickSort(int[] array, int startIndex, int endIndex) {
            if(endIndex<= startIndex) return; //base case

            int pivotIndex = partition(array,startIndex, endIndex);

            quickSort(array,startIndex,pivotIndex - 1);
            quickSort(array,pivotIndex +1,endIndex);
      }

      private static int partition(int[] array, int startIndex, int endIndex) {
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
