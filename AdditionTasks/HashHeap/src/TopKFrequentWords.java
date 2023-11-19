import java.util.*;

public class TopKFrequentWords {
      /**
       Top K Frequent Words

       Given an array of strings words and an integer k, return the k most frequent strings.

       Return the answer sorted by the frequency from highest to lowest.
       Sort the words with the same frequency by their lexicographical order.

       Example 1:

       Input: words = ["i","love","leetcode","i","love","coding"], k = 2
       Output: ["i","love"]
       Explanation: "i" and "love" are the two most frequent words.
       Note that "i" comes before "love" due to a lower alphabetical order.
       Example 2:

       Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
       Output: ["the","is","sunny","day"]
       Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
       */
      public static void main(String[] args) {
            testOne();
      }
      List<String> getMostFrequentStrings(int k, String... strArr) {

            HashMap<String, Integer> freqMap = new HashMap<>();

            for (String string : strArr) {
                  if (freqMap.containsKey(string)) {
                        Integer val = freqMap.get(string);
                        val ++;
                        freqMap.put(string, val);
                  } else {
                        freqMap.put(string, 1);
                  }
            }

            TreeMap<Integer, List<String>> maxFreqMap = new TreeMap<>();

            Set<Map.Entry<String, Integer>> entries = freqMap.entrySet();

            for (Map.Entry<String, Integer> entry : entries) {
                  String string = entry.getKey();
                  Integer count = entry.getValue();
                  if (maxFreqMap.containsKey(count)) {
                        List<String> strings = maxFreqMap.get(count);
                        strings.add(string);
                        maxFreqMap.put(count, strings);
                  } else {
                        List<String> strings = new ArrayList<>();
                        strings.add(string);
                        maxFreqMap.put(count, strings);
                  }
            }

            List<String> strings = maxFreqMap.get(k);


            return strings;
      }
      static void testOne() {
            String[] str = {"i","love","leetcode","i","love","coding"};
            int k = 2;
            TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
            List<String> mostFrequentStrings = topKFrequentWords.getMostFrequentStrings(k, str);
            System.out.println(mostFrequentStrings);
      }
}
