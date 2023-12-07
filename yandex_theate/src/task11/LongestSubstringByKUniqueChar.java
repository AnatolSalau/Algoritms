package task11;

import java.util.HashMap;
import java.util.Map;

/**
       Для заданной строки s и целого числа k вернуть длину самой длинной подстроки s,
       содержащей не более k различных символов.

       Input: s = "eceba", k = 2
       Output: 3 [ece]
 */
public class LongestSubstringByKUniqueChar {

      public static void main(String[] args) {
            testOne();
            testTwo();
      }

      static int geMaxLengthSubstringWithKDistinctChar(String s, int k) {
            char[] charArr = s.toCharArray();
            HashMap<Character, Integer> charFreqMap = new HashMap<>();

            int maxWindowLength = 0;
            int l = 0;

            for (int r = 0; r < charArr.length; r++) {
                  char left = charArr[l];
                  char right = charArr[r];

                  //fill charFreqMap by right char
                  if (charFreqMap.containsKey(right)) {
                        Integer count = charFreqMap.get(right);
                        count++;
                        charFreqMap.put(right,count);
                  } else {
                        charFreqMap.put(right,1);
                  }

                  //check size of charFreqMap
                  while (charFreqMap.size() > k) {
                        Integer count = charFreqMap.get(left);
                        count --; // decrease count
                        charFreqMap.put(left,count);

                        if (count == 0) {
                              charFreqMap.remove(left); // remove if count == 0
                        }

                        l += 1;//increase left pointer
                        left = charArr[l]; // change left number when we increase pointer
                  }

                  int currWindowsLength = r - l + 1;
                  maxWindowLength = Math.max(currWindowsLength,maxWindowLength);
            }


            return maxWindowLength;
      }
      /*    k = 2, expected result = 4

          i:0 1 2 3 4 5
            a a b b c c       a -> 1, mapSize = 1, windowsLength = 1
           lr

          i:0 1 2 3 4 5
            a a b b c c       a -> 2, mapSize = 1, windowsLength = 2
            l r

          i:0 1 2 3 4 5
            a a b b c c       a -> 2, mapSize = 2, windowsLength = 3
            l   r             b -> 1

          i:0 1 2 3 4 5
            a a b b c c       a -> 2, mapSize = 2, windowsLength = 4
            l     r           b -> 2

          i:0 1 2 3 4 5
            a a b b c c       a -> 2, mapSize = 3 -> 3 > k(2) -> l++, and decrease count in map a->1,
            l l     r         b -> 2
                              c -> 1

          i:0 1 2 3 4 5
            a a b b c c       a -> 1, mapSize = 3 -> 3 > k(2) -> l++, and decrease count in map a->0, and delete a from map becouse count is 0
              l l     r       b -> 2
                              c -> 1
       */
      public static void testOne() {
            String s = "aabbcc";
            int k = 2;
            int expectedResult = 4;
            System.out.println(geMaxLengthSubstringWithKDistinctChar(s,k));
            System.out.println("Expected result : " + expectedResult);
            System.out.println();
      }
      /* k=2, expectedResult = 3
         i: 0  1  2  3  4
            e  c  e  b  a     e -> 1, mapSize = 1 <= k(2), windowsLength = 1
           lr

         i: 0  1  2  3  4
            e  c  e  b  a     e -> 1, mapSize = 2 <= k(2), windowsLength = 2
            l  r              c -> 1

         i: 0  1  2  3  4
            e  c  e  b  a     e -> 2, mapSize = 2 <= k(2), windowsLength = 3
            l     r           c -> 1

         i: 0  1  2  3  4
            e  c  e  b  a     e -> 2, mapSize = 3 > k(2) -> move l++, decrease count      e -> 1, mapSize = 3 ->
            l  l  l  r        c -> 1                                                      c -> 1
                              b -> 1                                                      b -> 1

         ->  3 > k(2) -> move l++, decrease count (count = 0 - delete from map) -> e -> 1, mapSize = 2

          i: 0  1  2  3  4
             e  c  e  b  a    e -> 1, mapSize = 2 > k(2) -> move l++
                   l     r    b -> 1
                              a -> 1
       */
      public static void testTwo() {
            String s = "eceba";
            int k = 2;
            int expectedResult = 3;
            System.out.println(geMaxLengthSubstringWithKDistinctChar(s,k));
            System.out.println("Expected result : " + expectedResult);
            System.out.println();
      }

}

