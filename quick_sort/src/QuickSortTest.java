import java.util.Arrays;


public class QuickSortTest {
      public static void main(String[] args) {
            int[] array = {1,9, 5, 2, 8, -1, -9 };
            System.out.println("After before : " + Arrays.toString(array));
            quickSort(array, 0, array.length - 1);
            System.out.println("After after : " + Arrays.toString(array));
      }

      static void quickSort(int[] array, int startIndex, int endIndex) {
            if (endIndex <= startIndex) return; //exit from recursion

            int pivotIndex = partition(array, startIndex, endIndex);

            quickSort(array,0,pivotIndex - 1);
            quickSort(array, pivotIndex +1,endIndex);
      }

      static int partition(int[] array, int startIndex, int endIndex) {
            int pivot = array[endIndex];

            int i = startIndex - 1;

            for (int j = startIndex; j <= endIndex - 1; j++) {
                  if(array[j] < pivot) {
                        i++;
                        int temp = array[j];
                        array[j] = array[i];
                        array[i] = temp;
                  }

            }
            //swap last element
            i++;
            int temp = array[i];
            array[i] = array[endIndex];
            array[endIndex] = temp;

            return i;
      }

}
