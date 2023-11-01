import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskC {
      /**
       * Дан упорядоченный по неубыванию массив целых 32-разрядных чисел.
       * Требуется удалить из него все повторения.
       */
      public static void main(String[] args) {
            int[] numbers = {-9, -8, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9, 10, 11, 12};
            //int[] numbers = {0};
            System.out.println("Array before : " + Arrays.toString(numbers));
            int[] byStream = removeDuplicatesByStream(numbers);
            int[] bySet = removeDuplicatesBySet(numbers);
            int[] byLoop = removeDuplicatesByLoop(numbers);
            System.out.println("removeDuplicatesByStream : " + Arrays.toString(byStream));
            System.out.println("removeDuplicatesBySet : " + Arrays.toString(bySet));
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

      /*     i  :  0   1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19  20  21  22
            arr : -9, -8, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9, 10, 11, 12
              K :  0
     after swap : -9
       */
      static int[] removeDuplicatesByLoop(int[] arr) {
            int k = 0;

            for (int i = 0; i < arr.length - 1; i++) {
                  if (arr[i+1] > arr[i]) {
                        k++;
                  }
                  if (arr[i + 1] == arr[i]) {
                        arr[k] = arr[i+1];
                  }
            }
            //create new arr with size k
            int[] result = new int[k];
            //put elements from old arr to new arr
            for (int i = 0; i < k; i++) {
                  result[i] = arr[i];
            }
            return result;
      }
}
