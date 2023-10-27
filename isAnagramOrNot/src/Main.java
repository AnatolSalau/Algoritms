import java.util.HashMap;
import java.util.Map;

public class Main {
      public static void main(String[] args) {
            System.out.println(isAnagram("фара ", "а рфа")); // true
            System.out.println(isAnagram("каркас", "краска")); // true
            System.out.println(isAnagram("север", "сервер")); // false, разная длина
            System.out.println(isAnagram("север", "ветер")); // false, разные буквы
      }
      static boolean isAnagram(String str1, String str2) {
            //check length
            if (str1.length() != str2.length()) {
                  return false;
            }
            var leftStat = getLetterStat(str1);
            var rightStat = getLetterStat(str2);
            return leftStat.equals(rightStat);
      }

      private static Map<Character, Integer> getLetterStat(String word) {
            var stat = new HashMap<Character, Integer>();
            for (int i = 0; i < word.length(); i++) {
                  char c = word.charAt(i);
                        if(stat.containsKey(c)) {
                              Integer count = stat.get(c);
                              count +=1;
                              stat.put(c,count);

                        } else {
                              stat.put(c,0);
                        }
                  //stat.put(c, stat.getOrDefault(c, 0) + 1);
            }
            return stat;
      }
}
