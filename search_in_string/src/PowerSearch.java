import java.util.ArrayList;
import java.util.List;

public class PowerSearch {
      /**
       * return start indexes of sample's enters
       */
      public static void main(String[] args) {
            String text =   "aabaabaaaaaabaabaabaabbaaab";
            String sample = "aabaab";

            System.out.println(powerSearch(text, sample));
      }
      /*    i = 0
            aabaabaaaaaabaabaabaabbaaab
            aabaab
                 i+j= 0 + 5 -> result.add(0)

                      i = 10
            aabaabaaaaaabaabaabaabbaaab
                      aabaab
                           i+j = 10 + 5 -> result.add(10)

           [0, 10, 13, 16]
       */
      public static List<Integer> powerSearch(String text, String sample) {
            char[] textChars = text.toCharArray();
            char[] sampleChars = sample.toCharArray();
           List<Integer> result = new ArrayList<>();
            for (int i = 0; i < textChars.length; i++) {
                  for (int j = 0; j < sampleChars.length; j++) {
                        //check we went beyond the array boundary or not
                        if (j + i >= textChars.length) return result;

                        if (textChars[j+i] != sampleChars[j]) {
                              break;
                        }
                        if (j == sampleChars.length - 1) {
                              result.add(i);
                        }
                  }
            }
            return result;
      }
}
