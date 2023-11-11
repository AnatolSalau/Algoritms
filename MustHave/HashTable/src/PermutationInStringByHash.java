import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PermutationInStringByHash {
      /**
       Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

       In other words, return true if one of s1's permutations is the substring of s2.

       Example 1:

       Input: s1 = "ab", s2 = "eidbaooo"
       Output: true
       Explanation: s2 contains one permutation of s1 ("ba").
       Example 2:

       Input: s1 = "ab", s2 = "eidboaoo"
       Output: false
       */

      public static void main(String[] args) {
            PermutationInStringByHash permutationInStringByHash = new PermutationInStringByHash();
            String sample = "bo", text = "eidbahoo";

            System.out.println(permutationInStringByHash.isContainPermutation(text,sample));

      }

      boolean isContainPermutation(String text, String sample) {
            Map<Character, Integer> sampleMap = getCharactersQuantityMap(sample);

            for (int i = 0; i < text.length(); i++) {
                  int left = i;
                  int right = i + sample.length();

                  if (right > text.length()) return false;

                  String curr = text.substring(left, right);

                  Map<Character, Integer> currMap = getCharactersQuantityMap(curr);

                  if (currMap.equals(sampleMap)) return true;
            }

            return false;
      }

      Map<Character, Integer> getCharactersQuantityMap(String str) {
            char[] chars = str.toCharArray();
            Map<Character, Integer> characterIntegerMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                  Character curr = chars[i];
                  if(characterIntegerMap.containsKey(curr)) {
                        Integer val = characterIntegerMap.get(curr);
                        val ++;
                        characterIntegerMap.put(curr, val);
                  } else {
                        characterIntegerMap.put(curr, 1);
                  }
            }
            return characterIntegerMap;
      }
}
