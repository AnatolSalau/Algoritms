import java.util.ArrayList;
import java.util.Arrays;

public class Main {
      public static void main(String[] args) {
            String text =   "aabaabaaaaaabaabaabaabbaaab";
            String sample = "aabaab";

            System.out.println(Arrays.toString(searchNaive(text, sample).toArray()));
      }

      /**
       * O (n*m), n - length text, m - length sample
       */
      static ArrayList<Integer> searchNaive(String text, String sample) {
            ArrayList<Integer> foundPositions = new ArrayList<>();
            for (int i = 0; i < text.length(); i++) {
                  int j = 0; // current
                  // index in sample
                  while (
                        j < sample.length() // while in sample
                        && i + j < text.length() // while in text
                        && sample.charAt(j) == text.charAt(i + j)//while sample == text part
                  ) {
                        j++;
                  }
                  if (j == sample.length()) {
                        foundPositions.add(i); //add index
                  }
            }
            return foundPositions;
      }
}
