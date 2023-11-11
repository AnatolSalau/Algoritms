import java.util.ArrayList;

public class PermutationInStringArray {
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
            PermutationInStringArray permutationInStringArray = new PermutationInStringArray();
            String s1 = "abc", s2 = "eidbaooo";
            ArrayList<String> allPermutation = new ArrayList<>(permutationInStringArray.getFactorial(s1.length()));
            permutationInStringArray.getAllPermutation(s1, "", allPermutation );
            System.out.println(allPermutation);
            System.out.println(permutationInStringArray.isContainPermutation(s2,s1));
      }

      boolean isContainPermutation(String text, String sample) {
            if (sample.length() > text.length()) return false;
            ArrayList<String> allPermutation = new ArrayList<>();
            getAllPermutation(sample, "", allPermutation);
            for (int i = 0; i < text.length(); i++) {
                  int left = i;
                  int right = i + sample.length();
                  if (right > text.length()) return false;
                  String curr = text.substring(left, right);
                  if (allPermutation.contains(curr)) return true;
            }
            return false;
      }

      void getAllPermutation(String str, String permutation, ArrayList<String> result) {
            if (str.length() == 0) {
                  result.add(permutation);
                  return;
            }
            for (int i = 0; i < str.length(); i++) {
                  String left = str.substring(0, i);
                  String right = str.substring(i +1, str.length());
                  String newStr = left + right;

                  String currChar = String.valueOf(str.charAt(i));
                  String newPermutation = currChar + permutation;
                  getAllPermutation(newStr, newPermutation, result);
            }
      }

      int getFactorial(int number) {
            if (number <= 2) return number;
            return number * getFactorial(number - 1);
      }
}
