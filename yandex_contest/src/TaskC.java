import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskC {
      /**
       * Дан упорядоченный по неубыванию массив целых 32-разрядных чисел.
       * Требуется удалить из него все повторения.
       */
      public static void main(String[] args) {
            int[] numbers = {-9, -8, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9, 10, 11};
            //int[] numbers = {0};
            System.out.println("Array before : " + Arrays.toString(numbers));
            //int[] byStream = removeDuplicatesByStream(numbers);
            //int[] bySet = removeDuplicatesBySet(numbers);
            int[] byLoop = removeDuplicatesByLoop(numbers);
            //System.out.println("removeDuplicatesByStream : " + Arrays.toString(byStream));
            //System.out.println("removeDuplicatesBySet : " + Arrays.toString(bySet));
            System.out.println("removeDuplicatesByLoop : " + Arrays.toString(byLoop));
      }

      static int[] removeDuplicatesByStream(int[] arr) {
            return Arrays.stream(arr)
                  .distinct()
                  .toArray();
      }

      static int[] removeDuplicatesBySet(int[] arr) {
            Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
            int[] result = set.stream().mapToInt(Integer::intValue).toArray();
            Arrays.sort(result);
            return result;
      }

      /*     i  :  0   1  2  3  4  5  6  7  8    9 10 11 12 13 14 15 16 17 18 19  20  21  22
            arr : -9, -8, 0, 0, 1, 1, 1, 2, 3,   3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9, 10, 11, 12
             0:   k    i  (k !=i)
             1:        k  i  (k !=i)
             2:           k  i  (k ==i)
             3:           k     i  (k !=i)
             4:              k(1)  i  (k ==i)
             5:              k(1)     i  (k ==i)
             6:              k(1)        i  (k !=i)
             7:                    k(2)     i  (k !=i) <-need to swap last
       */
      static int[] removeDuplicatesByLoop(int[] arr) {

            int left = 0;

            for (int i = 1; i < arr.length ; ) {
                 if (arr[i] != arr[left]) {
                       left ++;
                       arr[left] = arr[i];
                       i++;
                 } else {
                       i ++;
                 }
            }
            int[] result = new int[left+1];//last element in arr

            for (int i = 0; i < left+1; i++) {
                  result[i] = arr[i];
            }
            return result;
      }
}
