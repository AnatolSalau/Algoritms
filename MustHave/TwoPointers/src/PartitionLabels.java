import java.util.*;

public class PartitionLabels {
      /**
       * https://www.youtube.com/watch?v=eWbxbDjrwMU&t=5s&ab_channel=ANDREADI
       You are given a string s. We want to partition the string
       into as many parts as possible so that each letter appears in at most one part.

       Note that the partition is done so that after concatenating
       all the parts in order, the resultant string should be s.

       Return a list of integers representing the size of these parts.
       */

      public static void main(String[] args) {
            testOne();
      }

      static List<Integer> getPartitionIndexes(String str) {
            List<Integer> result = new ArrayList<>();
            char[] chars = str.toCharArray();
            HashMap<Character, Integer> lastPositionMap = new HashMap<>();

            int currPartitionIndex = 0;
            //to fill lastPositionMap
            for (int i = 0; i < chars.length; i++) {
                  Character currentCharacter = chars[i];
                  if (!lastPositionMap.containsKey(currentCharacter)) {
                        currPartitionIndex = i;

                  }
                  lastPositionMap.put(currentCharacter, i);
            }

            return result;
      }
      /**
       Input: s = "ababcbacadefegdehijhklij"
       Output: [9,7,8]
       Explanation:
       The partition is "ababcbaca", "defegde", "hijhklij".
       This is a partition so that each letter appears in at most one part.
       A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

       */
      private static void testOne() {
            String s = "ababcbacadefegdehijhklij";
            int[] rightAnswer = {9, 7, 8};
            List<Integer> partitionIndexes = getPartitionIndexes(s);
            System.out.println("Test one");
            System.out.println("Right answer : " + Arrays.toString(rightAnswer));
            System.out.println("My answer : " + partitionIndexes);
      }

      /**
       Example 2:

       Input: s = "eccbbbbdec"
       Output: [10]
       */
      private static void testTwo() {
            String s = "eccbbbbdec";
            int[] rightAnswer = {10};
      }

}
