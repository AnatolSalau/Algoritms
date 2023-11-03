public class AllPossibleArrangementsABC {
      /**
       * O(N * N!)
       */
      public static void main(String[] args) {
           String str = "ABC";
            printAllPossibleArrangementsABC(str, "", 0);
      }

      /**
       * 3! = 1 * 2 * 3 = 6
       * 4! = 1 * 2 * 3 * 4 = 24
       * ABC
       *    1     2     3
            A     B     C     -> ABC
                  C     B     -> ACB
            B     A     C     -> BAC
                  C     A     -> BCA
            C     A     B     -> CAB
                  B     A     -> CBA
       */
      static void printAllPossibleArrangementsABC(String str, String mutation, int depth) {
            if (str.length() == 0) { //exit from recursion
                  System.out.println("ext from recursion (mutation) : " + mutation);
                  return;
            }
            for (int i = 0; i < str.length(); i++) {
                  String currChar = String.valueOf(str.charAt(i));
                  String pref = str.substring(0, i);
                  String suff = str.substring(i +1);
                  String newStr = pref + suff;
                  String newMutation = mutation + currChar;
                  int newDepth = depth +1;
                  printStep(i,depth,currChar,pref,suff,newStr,newMutation,newDepth);
                  printAllPossibleArrangementsABC(newStr, newMutation, newDepth);
            }
      }



      static void printStep(int i ,int depth, String currChar, String pref,
                            String suff, String newStr, String newMutation,
                            int newDepth) {
            System.out.println();
            System.out.println("i = " + i);
            System.out.println("depth = " + depth + " newDepth = " + newDepth);
            System.out.println("currChar = " + currChar);
            System.out.println("pref, str.substring(0," + i +")= " + pref);
            System.out.println("suff, str.substring(" + (i+1) +")= " + suff);
            System.out.println("newStr (suff + pref) = " + newStr);
            System.out.println("newMutation = " + newMutation);
            System.out.println();
      }
}

