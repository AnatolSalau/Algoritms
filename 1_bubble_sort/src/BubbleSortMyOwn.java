import java.util.Arrays;

/**
 * Bubble sort O(N) worst o(N*N)
 */
public class BubbleSortMyOwn {
      public static void main(String[] args) {
            int[] arr = {10, 4, 1, 5, 2, -1, -1, 3, 10,};
            //1.1 (4 5 2 3) -> (4 5 2 3)
            //1.2 (4 5 2 3) -> (2 5 4 3)
            //1.3 (2 5 4 3) -> (2 5 4 3)

            //2.1 (2 5 4 3) -> (2 4 5 3)
            //2.2 (2 4 5 3) -> (2 3 5 4)

            //3.3 (2 3 5 4) -> (2 3 4 5)

      /*
            System.out.println("arr after : " + Arrays.toString(arr));
            doSort(arr);
            System.out.println("arr before : " + Arrays.toString(arr));
      */

            System.out.println("arr after : " + Arrays.toString(arr));
            doSortMyOwn(arr);
            System.out.println("arr before : " + Arrays.toString(arr));
      }

      private static void doSortMyOwn(int[] arr) {


      }
}
