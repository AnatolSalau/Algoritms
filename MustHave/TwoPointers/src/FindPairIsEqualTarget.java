import java.util.ArrayList;
import java.util.List;

public class FindPairIsEqualTarget {
      /**
       * Given a sorted array A {2, 3, 5, 8, 9, 10, 11 } return indexes elements which sum equals target.
       * target = 17
       */
      public static void main(String[] args) {
            int[] arr = {2, 3, 5, 7, 8, 9, 10, 11 };
            int target = 17;
            FindPairIsEqualTarget findPairIsEqualTarget = new FindPairIsEqualTarget();
            List<Integer> indexes = findPairIsEqualTarget.findIndexes(arr, target);
            System.out.println(indexes);
      }

      /*
            2 3 5 8 9 10 11 target = 17
            l            r  curr = 13
            2 3 5 8 9 10 11 target = 17
              l          r  curr = 14
            2 3 5 8 9 10 11 target = 17
                l         r curr = 16
            2 3 5 8 9 10 11 target = 17
                  l       r curr = 19
            2 3 5 8 9 10 11 target = 17
                  l    r    curr = 18
            2 3 5 8 9 10 11 target = 17
                  l r       curr = 17
       */
      List<Integer> findIndexes(int[] arr, int target) {
            int leftIndex = 0;
            int rightIndex = arr.length - 1;
            List<Integer> result = new ArrayList<>();

            while (leftIndex < rightIndex) {
                 int left = arr[leftIndex];
                 int right = arr[rightIndex];

                 if(left + right == target) {
                       result.add(leftIndex);
                       result.add(rightIndex);
                       leftIndex ++;
                       rightIndex --;
                 }
                  // if left + right < target, so we need to increase value
                  // wii do it by increasing left value
                 if (left + right < target) {
                        leftIndex++;
                 }

                 if (left + right > target) {
                       rightIndex--;
                 }
            }
            return result;
      }
}
