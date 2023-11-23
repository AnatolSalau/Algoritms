public class GuessGame {
      /**
       * You call a pre-defined API int guess(int num), which returns three possible results:
       *
       * -1: Your guess is higher than the number I picked (i.e. num > pick).
       * 1: Your guess is lower than the number I picked (i.e. num < pick).
       * 0: your guess is equal to the number I picked (i.e. num == pick).
       * Return the number that I picked.
       *
       * Example 1:
       *
       * Input: n = 10, pick = 6
       * Output: 6
       *
       * Example 2:
       *
       * Input: n = 1, pick = 1
       * Output: 1
       *
       * Example 3:
       *
       * Input: n = 2, pick = 1
       * Output: 1
       */
      public static void main(String[] args) {
            int i = guessNumber(10, 6);
            System.out.println("result : " + i);
      }

      public static int guessNumber(int n, int number) {
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                 nums[i] = i;
            }
            return search(nums, number,0, nums.length-1);
      }

      public static int search(int[] nums, int target, int startIndex, int endIndex) {
            if (startIndex <= endIndex) {
                  int middleIndex = (startIndex + endIndex) / 2;
                  int middleValue = nums[middleIndex];

                  if (middleValue == target) {
                        System.out.println("0");
                        return middleIndex;
                  }

                  if (target < middleValue) {
                        System.out.println("-1");
                        return search(nums, target, startIndex, middleIndex -1);
                  } else {
                        System.out.println("1");
                        return search(nums, target, middleIndex +1, endIndex);
                  }
            }
            return -99;
      }
}
