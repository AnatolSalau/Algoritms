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
       * Notice that you may not slant the container.
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

      static void arrayWithNineValuesTest() {
            int[] heights = {1,8,6,2,5,4,8,3,7};
            int square = maximumWater(heights);
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
