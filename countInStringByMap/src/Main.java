import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
      public static void main(String[] args) {
            // ITVDN.com 5 из ТОП 20 тестовых заданий на интервью для Java разработчика

            String str1 = "Current";
            quantityWords(str1);
            String str2 = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";
            quantityChars(str2);
      }

      /**
       * O(N log2N)
       */
      static void quantityWords(String str) {
            String[] words = str.split(" ");
            HashMap<String,Integer> quantity = new HashMap<String,Integer>();
            for (int i=0; i< words.length; i++) {
                  if (quantity.containsKey(words[i])) {
                        int counter = quantity.get(words[i]);
                        quantity.put(words[i], counter+1);
                  }
                  else {
                        quantity.put(words[i], 1);
                  }
            }
            System.out.println(quantity);
      }

      static void quantityChars(String str) {
            String[] words = str.split("");
            HashMap<String,Integer> quantity = new HashMap<String,Integer>();
            for (int i=0; i< words.length; i++) {
                  if (quantity.containsKey(words[i])) {
                        int counter = quantity.get(words[i]);
                        quantity.put(words[i], counter+1);
                  }
                  else {
                        quantity.put(words[i], 1);
                  }
            }
            System.out.println(quantity);
      }
}
