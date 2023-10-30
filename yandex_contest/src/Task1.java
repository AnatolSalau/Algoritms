import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task1 {
      /**
       * Даны две строки строчных латинских символов: строка J и строка S.
       * Символы, входящие в строку J, — «драгоценности», входящие в строку S — «камни».
       * Нужно определить, какое количество символов из S одновременно являются «драгоценностями».
       * Проще говоря, нужно проверить, какое количество символов из S входит в J.
       */
      public static void main(String[] args) {
            String[] jewels = {"a", "b", "c", "d", "e", "f"};
            String[] stones = { "d", "e", "f"};

            int countOfStonesInJewelBySet = getCountOfStonesInJewelBySet(jewels, stones);
            System.out.println("countOfStonesInJewelBySet : " + countOfStonesInJewelBySet);

            int countOfStonesInJewelByArray = getCountOfStonesInJewelByArray(jewels, stones);
            System.out.println("countOfStonesInJewelByArray : " + countOfStonesInJewelByArray);
      }

      static int getCountOfStonesInJewelBySet(String[] jewels, String[] stones) {
            HashSet<String> jewelsSet = new HashSet<>(Arrays.asList(jewels));
            int count = 0;
            for (int i = 0; i < stones.length; i++) {
                  if (jewelsSet.contains(stones[i])) {
                        count++;
                  }
            }
            return count;
      }

      static int getCountOfStonesInJewelByArray(String[] jewels, String[] stones) {
            int count = 0;
            for (int i = 0; i < stones.length; i++) {
                  for (int j = 0; j < jewels.length; j++) {
                        if (stones[i].equals(jewels[j])) {
                              count++;
                        }
                  }

            }
            return count;
      }
}
