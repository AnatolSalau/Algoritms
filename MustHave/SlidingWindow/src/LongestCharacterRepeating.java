import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestCharacterRepeating {
      /**
       You are given a string s and an integer k.
       You can choose any character of the string and change it to any other uppercase English character.
       You can perform this operation at most k times.

       Return the length of the longest substring containing the same letter
       you can get after performing the above operations.

       Example 1:

       Input: s = "ABAB", k = 2
       Output: 4
       Explanation: Replace the two 'A's with two 'B's or vice versa.

       Example 2:

       Input: s = "AABABBA", k = 1
       Output: 4
       Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
       The substring "BBBB" has the longest repeating letters, which is 4.
       There may exists other ways to achieve this answer too.
       */
      public static void main(String[] args) {
            test1();
            test2();
            test3();
      }
      /*
                        0 1 2 3 4 5 6
                        a a b c c b b, k=2
                        se

                  i:0   a a b c c b b,
                       se
                        a->0
                        length = 1
                        slots( length - maxFreq = slots <= k ) 1 - 0 = 1 <= 2 -> e++

                  i:1   a a b c c b b,
                        s e
                        a->2
                        length = 2
                        slots( length - maxFreq = slots <= k ) 2 - 2 = 0 <= 2 -> e++

                  i:2   a a b c c b b,
                        s   e
                        a->2
                        b->1
                        length = 3
                        slots( length - maxFreq = slots <= k ) 3 - 2 = 1 <= 2 -> e++

                  i:3   a a b c c b b,
                        s     e
                        a->2
                        b->1
                        c->1
                        length = 4
                        slots( length - maxFreq = slots <= k ) 4 - 2 = 2 <= 2 -> e++

                  i:4   a a b c c b b,
                        s       e
                        a->2
                        b->1
                        c->2
                        length = 5
                        slots( length - maxFreq = slots <= k ) 5 - 2 = 3 <= 2 -> s++

                  i:5   a a b c c b b,
                          s     e
                        a->1
                        b->1
                        c->2
                        length = 4
                        slots( length - maxFreq = slots <= k ) 4 - 2 = 2 <= 2 -> e++

                  i:6   a a b c c b b,
                          s       e
                        a->1
                        b->2
                        c->2
                        length = 5
                        slots( length - maxFreq = slots <= k ) 5 - 2 = 2 <= 3 -> s++

                  i:6   a a b c c b b,
                            s     e
                        a->0
                        b->2
                        c->2
                        length = 4
                        slots( length - maxFreq = slots <= k ) 4 - 2 = 2 <= 2 -> e++

                  i:6   a a b c c b b,
                            s       e
                        a->0
                        b->3
                        c->2
                        length = 5
                        slots( length - maxFreq = slots <= k ) 5 - 3 = 2 <= 2 -> s++

                        maxLength is 5
                        return maxLength
       */
      static void test1() {
            String str = "aabccbb";
            int k = 2;
            int expected = 5;
            String longestRepeating = "bbbbb";
            LongestCharacterRepeating longestCharacterRepeating = new LongestCharacterRepeating();
            int result = longestCharacterRepeating.getMaxRepeatingOfElements(str, k);
            System.out.println(str);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expected);
            System.out.println();
      }
/*
                        0 1 2 3 4
                        a b b c b, k=1
                        se

                  i:0   a b b c b,
                       se
                        a->1
                        length = 1
                        slots( length - maxFreq = slots <= k ) 1 - 1 = 0 <= 1 -> e++

                  i:1   a b b c b,
                        s e
                        a->1
                        b->1
                        length = 2
                        slots( length - maxFreq = slots <= k ) 2 - 1 = 1 <= 1 -> e++

                  i:2   a b b c b,
                        s   e
                        a->1
                        b->2
                        length = 3
                        slots( length - maxFreq = slots <= k ) 3 - 2 = 1 <= 1 -> e++

                  i:3   a b b c b,
                        s     e
                        a->1
                        b->2
                        c->1
                        length = 4
                        slots( length - maxFreq = slots <= k ) 4 - 2 = 2 <= 1 -> s++

                  i:4   a b b c b,
                          s   e
                        a->0
                        b->2
                        c->1
                        length = 3
                        slots( length - maxFreq = slots <= k ) 3 - 2 = 1 <= 1 -> e++

                  i:5   a b b c b,
                          s     e
                        a->0
                        b->3
                        c->1
                        length = 4<-------------------------
                        slots( length - maxFreq = slots <= k ) 4 - 3 = 1 <= 1 -> s++
 */
      static void test2() {
            String str = "abbcb";
            int k = 1;
            int expected = 4;
            String longestRepeating = "bbbb";
            LongestCharacterRepeating longestCharacterRepeating = new LongestCharacterRepeating();
            int result = longestCharacterRepeating.getMaxRepeatingOfElements(str, k);
            System.out.println(str);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expected);
            System.out.println();
      }

      static void test3() {
            String str = "abccde";
            int k = 1;
            int expected = 3;
            String longestRepeating = "ccc";
            LongestCharacterRepeating longestCharacterRepeating = new LongestCharacterRepeating();
            int result = longestCharacterRepeating.getMaxRepeatingOfElements(str, k);
            System.out.println(str);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expected);
            System.out.println();
      }

      int getMaxRepeatingOfElements(String str, int k) {
            char[] chars = str.toCharArray();
            int result = 0;
            int leftIndex = 0;
            int rightIndex = 0;

            for (; leftIndex < chars.length;) {
                  if (rightIndex >= chars.length) return result;

                  HashMap<Character, Integer> freqMap = new HashMap<>();

                  for (int i = leftIndex; i <= rightIndex ; i++) {
                        char currChar = chars[i];
                        if (freqMap.containsKey(currChar)) {
                              Integer count = freqMap.get(currChar);
                              count ++;
                              freqMap.put(currChar,count);
                        } else {
                              freqMap.put(currChar,1);
                        }
                  }

                  int length = rightIndex - leftIndex + 1;
                  int maxFreq = getMaxFreq(freqMap);
                  int slots = length - maxFreq;

                  if (slots <= k) {
                        rightIndex++;
                        result = result > length ? result : length;

                  } else {
                        Character mostLefChar = chars[leftIndex];
                        leftIndex++;
                  }
            }
            return result;
      }

      private int getMaxFreq(HashMap<Character, Integer> freqMap) {
            int result = 0;
            Set<Map.Entry<Character, Integer>> entries = freqMap.entrySet();
            for (Map.Entry<Character, Integer> entry : entries) {
                  Integer value = entry.getValue();
                  if (value > result) result = value;
            }
            return result;
      }
}
