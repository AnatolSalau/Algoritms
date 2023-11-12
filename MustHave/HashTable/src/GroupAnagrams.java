import java.util.*;

public class GroupAnagrams {
      /**
             Given an array of strings strs, group the anagrams together.
             You can return the answer in any order.

             An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
             typically using all the original letters exactly once.

             Example 1:
             Input: strs = ["eat","tea","tan","ate","nat","bat"]
             Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

             Example 2:
             Input: strs = [""]
             Output: [[""]]

             Example 3:
             Input: strs = ["a"]
             Output: [["a"]]
       */
      public static void main(String[] args) {
            GroupAnagrams groupAnagrams = new GroupAnagrams();

            String[] arr1 = {"eat","tea","tan","ate","nat","bat"};
            String[] arr2 = {""};
            String[] arr3 = {"a"};
            List<List<String>> groupsOfAnagram1 = groupAnagrams.getGroupsOfAnagram(arr1);
            List<List<String>> groupsOfAnagram2 = groupAnagrams.getGroupsOfAnagram(arr2);
            List<List<String>> groupsOfAnagram3 = groupAnagrams.getGroupsOfAnagram(arr3);
            System.out.println(groupsOfAnagram1);
            System.out.println(groupsOfAnagram2);
            System.out.println(groupsOfAnagram3);
      }

      List<List<String>> getGroupsOfAnagram(String... arr) {
            Map<Map<Character,Integer>, List<String>> anagramStringMap = new HashMap();

            for (String str : arr) {
                  Map<Character, Integer> currMap = getCharQuantityMap(str);
                  if (anagramStringMap.containsKey(currMap)) {
                        List<String> val = anagramStringMap.get(currMap);
                        val.add(str);
                        anagramStringMap.put(currMap, val);
                  } else {
                        ArrayList<String> val = new ArrayList<>();
                        val.add(str);
                        anagramStringMap.put(currMap, val);
                  }
            }

            List<List<String>> result = new LinkedList<>();

            Set<Map.Entry<Map<Character, Integer>, List<String>>> entries = anagramStringMap.entrySet();

            for (Map.Entry<Map<Character, Integer>, List<String>> entry : entries) {
                  result.add(entry.getValue());
            }
            return result;
      }

       Map<Character,Integer> getCharQuantityMap(String str) {
             Map<Character,Integer> map = new HashMap<>();
             for (Character character : str.toCharArray()) {
                   if (map.containsKey(character)) {
                         Integer val = map.get(character);
                         val++;
                         map.put(character, val);
                   } else {
                         map.put(character, 1);
                   }
             }
             return map;
       }
}
