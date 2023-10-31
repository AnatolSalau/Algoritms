import java.util.HashMap;

public class Main {
      public static void main(String[] args) {
            String str1 = "egg", str2 = "add"; //true
            /*
                  e -> a
                  g -> d
             */
            System.out.println(isIsomorfic(str1,str2));
            String str3 = "foo", str4 = "bar"; //false
            /*
                  f -> b
                  o -> a, r
             */
            System.out.println(isIsomorfic(str3,str4));
            String str5 = "paper", str6 = "title"; //true
            /*
                  p -> t
                  a -> i
                  e -> l
                  r -> e
             */
            System.out.println(isIsomorfic(str5,str6));
      }

      static boolean isIsomorfic(String str1, String str2) {
            //compare lengths
            if (str1.length() != str2.length()) {
                  return false;
            }
            HashMap<Character, Character> str1Map = new HashMap<>();
            HashMap<Character, Character> str2Map = new HashMap<>();

            char[] str1Chars = str1.toCharArray();
            char[] str2Chars = str2.toCharArray();

            for (int i = 0; i < str1.length(); i++) {
                  //check is contain first map this key with  value
                  if(str1Map.containsKey(str1Chars[i]) && str1Map.get(str1Chars[i]) != str2Chars[i]) {
                        return false;
                  }
                  //check is contain second map this key with value
                  if(str2Map.containsKey(str2Chars[i]) && str2Map.get(str2Chars[i]) != str1Chars[i]) {
                        return false;
                  }
                  str1Map.put(str1Chars[i], str2Chars[i]);
                  str2Map.put(str2Chars[i], str1Chars[i]);
            }
            return true;
      }
}
