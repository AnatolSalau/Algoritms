import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
            test1();
            System.out.println();
            test2();
            System.out.println();
            test3();
      }

      static void test1() {
            int[][] arrays = {{1,3},{2,6},{8,10},{15,18}};
            int[][] expectedResult = {{1,6},{8,10},{15,18}};
            MergeIntervals mergeIntervals = new MergeIntervals();
            System.out.println("Interfals before sort : " + Arrays.deepToString(arrays));
            mergeIntervals.sortIntervalsQuick(arrays,0,arrays.length - 1);
            System.out.println("Interfals after sort : " + Arrays.deepToString(arrays));
            List<List<Integer>> nonOverlappingIntervals = mergeIntervals.getNonOverlappingIntervals(arrays);
            System.out.println("Non overlapping arrays : " + nonOverlappingIntervals);
            System.out.println("Expected : " + Arrays.deepToString(expectedResult));
            System.out.println();
      }

      static void test2() {
            int[][] arrays = {{1,4},{4,5}};
            int[][] expectedResult = {{1,5}};
            MergeIntervals mergeIntervals = new MergeIntervals();
            System.out.println("Interfals before sort : " + Arrays.deepToString(arrays));
            mergeIntervals.sortIntervalsQuick(arrays,0,arrays.length - 1);
            System.out.println("Interfals after sort : " + Arrays.deepToString(arrays));
            List<List<Integer>> nonOverlappingIntervals = mergeIntervals.getNonOverlappingIntervals(arrays);
            System.out.println("Non overlapping arrays : " + nonOverlappingIntervals);
            System.out.println("Expected : " + Arrays.deepToString(expectedResult));
            System.out.println();
      }

      static void test3() {
            int[][] arrays = {{2,6},{8,10},{8,9},{9,11},{15,18},{2,4},{16, 17},{1,3}};
            int[][] expectedResult = {{1,6}, {8,11}, {15,18}};
            MergeIntervals mergeIntervals = new MergeIntervals();
            System.out.println("Interfals before sort : " + Arrays.deepToString(arrays));
            mergeIntervals.sortIntervalsQuick(arrays,0,arrays.length - 1);
            System.out.println("Interfals after sort : " + Arrays.deepToString(arrays));
            List<List<Integer>> nonOverlappingIntervals = mergeIntervals.getNonOverlappingIntervals(arrays);
            System.out.println("Non overlapping arrays : " + nonOverlappingIntervals);
            System.out.println("Expected : " + Arrays.deepToString(expectedResult));
            System.out.println();
      }
      /*    i=1                                                                           j=0
            [[1, 3], [2, 6], [2, 4], [8, 10], [8, 9], [9, 11], [15, 18], [16, 17]]      [[1, 3]]
            for :
            [[1, 3]]
                      i=1                                                                           j=1
            [[1, 3], [2, 6], [2, 4], [8, 10], [8, 9], [9, 11], [15, 18], [16, 17]]       [[1, 3], [2, 6]]

            [[1, 3], [2, 6]]
                              i=2                                                                  j=1
            [[1, 3], [2, 6], [2, 4], [8, 10], [8, 9], [9, 11], [15, 18], [16, 17]]       [[1, 3], [2, 6]]

            [[1, 3], [2, 6]]
                                      i=3                                                                  j=2
            [[1, 3], [2, 6], [2, 4], [8, 10], [8, 9], [9, 11], [15, 18], [16, 17]]       [[1, 3], [2, 6], [8, 10]]

            [[1, 3], [2, 6], [8, 10]]
                                               i=4                                                         j=2
            [[1, 3], [2, 6], [2, 4], [8, 10], [8, 9], [9, 11], [15, 18], [16, 17]]       [[1, 3], [2, 6], [8, 10]]
       */
      List<List<Integer>> getNonOverlappingIntervals(int[][] intervals) {
                  List<List<Integer>> result = new LinkedList<>();

                  result.add(new ArrayList<>(List.of(intervals[0][0], intervals[0][1])));

            for (int i = 1; i < intervals.length; i++) {
                  int rightStart = intervals[i][0];
                  int rightEnd = intervals[i][1];

                  int j = result.size() - 1;
                  int leftStart = result.get(j).get(0);
                  int leftEnd = result.get(j).get(1);

                  if (leftEnd >= rightStart) {
                        List<Integer> temp = new ArrayList<>();
                        int maxEnd = leftEnd > rightEnd ? leftEnd : rightEnd;
                        temp.add(leftStart);
                        temp.add(maxEnd);
                        result.remove(j);
                        result.add(temp);
                  } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(rightStart);
                        temp.add(rightEnd);
                        result.add(temp);
                  }

            }



            return result;
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
