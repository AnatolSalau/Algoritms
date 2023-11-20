import java.util.Arrays;

public class ContainerWithMostWater {
      /**
       * You are given an integer array height of length n.
       * There are n vertical lines drawn such that the two endpoints
       * of the ith line are (i, 0) and (i, height[i]).
       *
       * Find two lines that together with the x-axis form a container,
       * such that the container contains the most water.
       *
       * Return the maximum amount of water a container can store.
       *
       * Example 1:
       * Notice that you may not slant the container.
       *
       * Input: height = [1,8,6,2,5,4,8,3,7]
       * Output: 49
       * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
       * In this case, the max area of water (blue section) the container can contain is 49.
       *
       * Example 2:
       *
       * Input: height = [1,1]
       * Output: 1
       */
      public static void main(String[] args) {
            arrayWithNineValuesTest();
            arrayWithTwoValuesTest();
            voidArrayTest();
      }

      /**
       * 0
       */
      static int maximumWater(int[] heights) {
            int maxSquare = 0;

            int leftIndex = 0;
            int rightIndex = heights.length - 1;

            while (leftIndex <rightIndex) {
                  int left = heights[leftIndex];
                  int right = heights[rightIndex];
                  int width = rightIndex - leftIndex;
                  int height = left < right ? left : right;
                  int currSquare = width * height;

                  if (currSquare > maxSquare) {
                        maxSquare = currSquare;
                  }
                  if (left < right) {
                        leftIndex++;
                  } else {
                        rightIndex--;
                  }
            }
            return maxSquare;
      }

      /*          0 1 2 3 4 5 6 7 8
                  1,8,6,2,5,4,8,3,7
           i:0    l               r    1*7= 7
           i:1      l             r    7*7= 49
           i:2      l           r      3*6= 18
           i:3      l         r        8*5= 40
           i:4        l     r          4*3= 12
           i:5        l   r            5*2= 10
           i:6        l r              2*1= 2
       */
      static int maximumWaterTest(int[] heights) {
            int lI = 0;
            int rI = heights.length - 1;

            int maxSquare = 0;

            while (lI < rI) {
                  int leftH = heights[lI];
                  int rightH = heights[rI];

                  int minH = leftH < rightH ? leftH : rightH;
                  int width = rI - lI;
                  int currSquare = width * minH;

                  if (currSquare > maxSquare) maxSquare = currSquare;

                  if (lI < rI) {
                        lI++;
                  } else {
                        rI--;
                  }
            }
            return maxSquare;
      }

      static void arrayWithNineValuesTest() {
            int[] heights = {1,8,6,2,5,4,8,3,7};
            int square = maximumWaterTest(heights);
            int expected = 49;
            System.out.println("Array : " + Arrays.toString(heights));
            System.out.println("Square : " + square);
      }

      static void arrayWithTwoValuesTest() {
            int[] heights = {1,1};
            int square = maximumWater(heights);
            System.out.println("Array : " + Arrays.toString(heights));
            System.out.println("Square : " + square);
      }

      static void voidArrayTest() {
            int[] heights = new int[10];
            int square = maximumWater(heights);
            System.out.println("Array : " + Arrays.toString(heights));
            System.out.println("Square : " + square);
      }
}
