package task11;

import java.util.HashMap;
import java.util.Map;

/**
       Для заданной строки s и целого числа k вернуть длину самой длинной подстроки s,
       содержащей не более k различных символов.

       Input: s = "eceba", k = 2
       Output: 3 [ece]
 */
public class Main {

      public static void main(String[] args) {
            testOne();
            testTwo();
      }

      public static int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (k == 0 || s == null || s.length() == 0) {return 0;}// check border conditions

            if (s.length() < k) {return s.length();}// check border conditions

            Map<Character, Integer> freqMap = new HashMap<>();

            int left = 0;// left index
            int maxLength = 0;// max length

            for (int right = 0; right < s.length(); right++) { // right - right index
                  char currChar = s.charAt(right);

                  //fill freqMap
                  freqMap.put(currChar, freqMap.getOrDefault(currChar, 0) + 1);

                  // if freqMap contain extra character -> remove it from map
                  while (freqMap.size() > k) {
                        char leftChar = s.charAt(left);

                        if (freqMap.containsKey(leftChar)) {
                              //decrease left character quantity
                              freqMap.put(leftChar, freqMap.get(leftChar) - 1);

                              //remove character from freqMap if his quantity is 0
                              if (freqMap.get(leftChar) == 0) {
                                    freqMap.remove(leftChar);
                              }
                        }
                        left++; // move left pointer forward
                  }

                  int currLength = right - left + 1;

                  // if curr length more than maxLength -> save it
                  maxLength = Math.max(maxLength, currLength);
            }
            return maxLength;
      }

      public static void testOne() {
            String s = "aabbcc";
            int k = 2;
            int expectedResult = 4;
            System.out.println(lengthOfLongestSubstringKDistinct(s,k));
            System.out.println("Expected result : " + expectedResult);
            System.out.println();
      }

      public static void testTwo() {
            String s = "eceba";
            int k = 2;
            int expectedResult = 3;
            System.out.println(lengthOfLongestSubstringKDistinct(s,k));
            System.out.println("Expected result : " + expectedResult);
            System.out.println();
      }
}

