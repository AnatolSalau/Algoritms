import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
      /**
       Given an array of integers nums and an integer target,
       return indices of the two numbers such that they add up to target.

       You may assume that each input would have exactly one solution,
       and you may not use the same element twice.

       You can return the answer in any order.

       Example 1:
       Input: nums = [2,7,11,15], target = 9
       Output: [0,1]
       Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

       Example 2:
       Input: nums = [3,2,4], target = 6
       Output: [1,2]

       Example 3:
       Input: nums = [3,3], target = 6
       Output: [0,1]
       */
      public static void main(String[] args) {
            TwoSum twoSum = new TwoSum();
            twoSum.test1();
            twoSum.test2();
            twoSum.test3();
      }

      /*
            3,2,4 ,target = 6, result = [1,2]
      i  nums    indexes map.contain(target - numbers[i] )
       0     3 -> 0                  6 - 3 = 3
       1     2 -> 1                  6 - 2 = 4
       2     4 -> 2                  6 - 4 = 2 - 2 present in map so 4 + 2 = 6
       */
      /*
            [2,7,11,15] ,target = 9, result = [0,1]
      i   nums    indexes map.contain(target - numbers[i] )
      0      2 -> 0                  9 - 2 = 7
      1      7 -> 1                  9 - 7 = 2 - 2 present in map so 7 + 2 = 9
       */
      /*
            [3.3] ,target = 6, result = [0,1]
      i   nums    indexes map.contain(target - numbers[i] )
      0      3 -> 0                  6 - 3 = 3
      1      3 -> 1                  6 - 3 = 3 present in map so 3 + 3 = 6
       */

      int[] getIndicates(int[] numbers, int target) {
            int[] result = new int[2];
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                  int curr = numbers[i];
                  int remainder = target - curr;

                  if (map.containsKey(remainder)) { // check Does map contain remainder ?
                        result[0] = map.get(remainder); // if contains, we have right answer
                        result[1] = i;    // because (remainder + existing key from map) = target
                  } else {
                        map.put(curr, i);
                  }
            }
            return result;
      }

      void test1() {
            int[] numbers = {2,7,11,15};
            int target = 9;
            int[] result = getIndicates(numbers, target);
            System.out.println(Arrays.toString(result));
      }

      void test2() {
            int[] numbers = {3,2,4};
            int target = 6;
            int[] result = getIndicates(numbers, target);
            System.out.println(Arrays.toString(result));
      }

      void test3() {
            int[] numbers = {3,3};
            int target = 6;
            int[] result = getIndicates(numbers, target);
            System.out.println(Arrays.toString(result));
      }

}
