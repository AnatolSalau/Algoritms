import java.util.Arrays;

public class BubbleSort {
      public static void main(String[] args) {
            int[] arr = {4, 5, 2, 3};
            //1.1 (4 5 2 3) -> (4 5 2 3)
            //1.2 (4 5 2 3) -> (2 5 4 3)
            //1.3 (2 5 4 3) -> (2 5 4 3)

            //2.1 (2 5 4 3) -> (2 4 5 3)
            //2.2 (2 4 5 3) -> (2 3 5 4)

            //3.3 (2 3 5 4) -> (2 3 4 5)

            System.out.println("arr after : " + Arrays.toString(arr));
            doSort(arr);
            System.out.println("arr before : " + Arrays.toString(arr));
      }


      private static void doSort(int[] arr) {
            for (int i = 0; i < arr.length-1; i++){
                  for (int j = i+1; j < arr.length; j++){
                        System.out.println("arr (iteration : " + i +"): " + Arrays.toString(arr));
                        System.out.println("i : " + arr[i]);
                        System.out.println("j : " + arr[j]);
                        if (arr[ i] > arr[ j]) {
                              int t = arr[ i];
                              arr[ i] = arr[ j];
                              arr[ j] = t;
                        }
                  }
            }
      }
}
