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

      /*    ababcbaca defegde hijhklij
           {a=8, b=5, c=7, d=14, e=15, f=11, g=13, h=19, i=22, j=23, k=20, l=21}
           The partition is "ababcbaca", "defegde", "hijhklij".
            [9,7,8]
            a b a b c b a c a
            partIndex = 0
            length = 0
            for
            char - Max(Map(char), partIndex) -> partIndex = max
            0(a) - 8 or 0 -> partIndex = 8, length = 0
            1(b) - 5 or 8 -> partIndex = 8, length = 1
            2(a) - 8 or 8 -> partIndex = 8, length = 2
            3(b) - 5 or 8 -> partIndex = 8, length = 3
            4(c) - 7 or 8 -> partIndex = 8, length = 4
            5(b) - 5 or 8 -> partIndex = 8, length = 5
            6(a) - 8 or 8 -> partIndex = 8, length = 6
            7(c) - 7 or 8 -> partIndex = 8, length = 7
            8(a) - 8 or 8 -> partIndex = 8, length = 8 ( i == partIndex, length to answer) length = 0
            9(d) - 14 or 9 -> partIndex = 14, length = 1
            10(e) - 15 or 14 -> partIndex = 15, length = 2
            11(f) - 11 or 15 -> partIndex = 15, length = 3
            12(e) - 15 or 15 -> partIndex = 15, length = 4
            13(g) - 13 or 15 -> partIndex = 15, length = 5
            14(d) - 14 or 15 -> partIndex = 15, length = 6
            15(e) - 15 or 15 -> partIndex = 15, length = 6 ( i == partIndex, length to answer) length = 0
       */
      static List<Integer> getPartitionIndexes(String str) {

            char[] chars = str.toCharArray();

            HashMap<Character, Integer> lastPositionMap = new HashMap<>();

            //to fill lastPositionMap
            for (int i = 0; i < chars.length; i++) {
                  Character currentCharacter = chars[i];
                  lastPositionMap.put(currentCharacter, i);
            }

            List<Integer> result = new ArrayList<>();

            System.out.println(lastPositionMap);

            int currPartitionIndex = 0;
            int partitionLength = 0;
            for (int i = 0; i < chars.length; i++) {
                  Character currentCharacter = chars[i];
                  int val = lastPositionMap.get(currentCharacter).intValue();
                  currPartitionIndex = val > currPartitionIndex ? val : currPartitionIndex;
                  partitionLength ++;
                  if (i == currPartitionIndex) {
                        result.add(partitionLength);
                        partitionLength = 0;
                  }
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
