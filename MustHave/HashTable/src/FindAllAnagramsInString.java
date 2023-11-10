import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInString {
      /**
       * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
       *
       * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

       * Example 1:
       * Input: s = "cbaebabacd", p = "abc"
       * Output: [0,6]
       * Explanation:
       * The substring with start index = 0 is "cba", which is an anagram of "abc".
       * The substring with start index = 6 is "bac", which is an anagram of "abc".
       *
       * Example 2:
       * Input: s = "abab", p = "ab"
       * Output: [0,1,2]
       * Explanation:
       * The substring with start index = 0 is "ab", which is an anagram of "ab".
       * The substring with start index = 1 is "ba", which is an anagram of "ab".
       * The substring with start index = 2 is "ab", which is an anagram of "ab".
       */

      List<Integer> findAllAnagramsPowerMethod(String text, String sample) {
            List<Integer> result = new LinkedList<>();
            for (int i = 0; i< text.length(); i++) {
                  int left = i;
                  int right = i + sample.length();
                  if (right > text.length()) {
                        return result;
                  }
                  String substring = text.substring(left, right);
                  if(isAnagram(substring, sample)) {
                        result.add(left);
                  };
            }
            return result;
      }

      boolean isAnagram(String str1, String str2) {
            if (str1.length() != str2.length()) return false;

            HashMap<Character, Integer> str1Map = getCharQuantityMap(str1);
            HashMap<Character, Integer> str2Map = getCharQuantityMap(str2);

            if (str1Map.equals(str2Map)) {
                  return true;
            }
            return false;
      }

      HashMap<Character, Integer> getCharQuantityMap(String str) {
            char[] strArr = str.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (Character character : strArr) {
                  if(map.containsKey(character)) {
                        Integer val = map.get(character);
                        val++;
                        map.put(character,val);
                  } else {
                        map.put(character,1);
                  }
            }
            return map;
      }

      public static void main(String[] args) {
            FindAllAnagramsInString findAllAnagramsInString = new FindAllAnagramsInString();
            findAllAnagramsInString.test1();
            findAllAnagramsInString.test2();
            boolean isAnagram = findAllAnagramsInString.isAnagram("abc", "cba");
            System.out.println(isAnagram);
      }

      void test1() {
            String text = "cbaebabacd";
            String sample = "abc";
            List<Integer> result = findAllAnagramsPowerMethod(text, sample);
            System.out.println(result);
      }

      void test2() {
            String text = "abab";
            String sample = "ab";
            List<Integer> result = findAllAnagramsPowerMethod(text, sample);
            System.out.println(result);
      }
}
