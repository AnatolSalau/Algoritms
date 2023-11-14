import java.util.Arrays;

public class MergeIntervals {
      /**
             Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
             and return an array of the non-overlapping intervals that cover all the intervals in the input.

             Example 1:
             Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
             Output: [[1,6],[8,10],[15,18]]
             Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

             Example 2:
             Input: intervals = [[1,4],[4,5]]
             Output: [[1,5]]
             Explanation: Intervals [1,4] and [4,5] are considered overlapping.
       */
      public static void main(String[] args) {
            test3();
      }

      static void test1() {
            int[][] arrays = {{1,3},{2,6},{8,10},{15,18}};
            int[][] expectedResult = {{1,6},{8,10},{15,18}};
      }

      static void test2() {
            int[][] arrays = {{1,4},{4,5}};
            int[][] expectedResult = {{1,5}};
      }

      static void test3() {
            int[][] arrays = {{2,6},{8,10},{8,9},{9,11},{15,18},{2,4},{16, 17},{1,3}};
            int[][] expectedResult = {{1,6}, {8,11}, {15,18}};
            MergeIntervals mergeIntervals = new MergeIntervals();
            System.out.println("Interfals before sort : " + Arrays.deepToString(arrays));
            mergeIntervals.sortIntervalsQuick(arrays,0,arrays.length - 1);
            System.out.println("Interfals after sort : " + Arrays.deepToString(arrays));

      }

      private void sortIntervalsBubble(int[][] intervals) {
            for (int i = 0; i < intervals.length - 1; i++) {
                  for (int j = i + 1; j < intervals.length ; j++) {
                        if (intervals[i][0] > intervals[j][0]) {
                              int[] temp = new int[2];
                              temp[0] = intervals[j][0];
                              temp[1] = intervals[j][1];
                              intervals[j][0] = intervals[i][0];
                              intervals[j][1] = intervals[i][1];
                              intervals[i][0] = temp[0];
                              intervals[i][1] = temp[1];
                        }
                  }
            }
      }

      private void sortIntervalsQuick(int[][] array, int leftInd, int rightInd){
            if (rightInd <= leftInd) return;

            int pivotInd = particion(array,leftInd, rightInd);
            sortIntervalsQuick(array,leftInd,pivotInd - 1);
            sortIntervalsQuick(array, pivotInd +1, rightInd);
      }

      private int particion(int[][] array, int leftInd, int rightInd) {
            int pivot = array[rightInd][0];
            int i = leftInd - 1;

            for (int j = leftInd; j <=rightInd - 1 ; j++) {
                  if (array[j][0] < pivot) {
                        i++;
                        int[] temp = new int[2];

                        temp[0] = array[j][0];
                        temp[1] = array[j][1];

                        array[j][0] = array[i][0];
                        array[j][1] = array[i][1];

                        array[i][0] = temp[0];
                        array[i][1] = temp[1];
                  }
            }
            i++;
            int[] temp = new int[2];
            temp[0] = array[rightInd][0];
            temp[1] = array[rightInd][1];
            array[rightInd][0] = array[i][0];
            array[rightInd][1] = array[i][1];
            array[i][0] = temp[0];
            array[i][1] = temp[1];
            return i;
      }
}
