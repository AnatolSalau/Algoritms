public class AllPossibleArrangements {
      /**
       * O(N * N!)
       */
      public static void main(String[] args) {
           String str = "ABC";
           printAllPossibleArrangementsABC(str, "");
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
      static void printAllPossibleArrangementsABC(String str, String mutation) {
            if (mutation.length() == 0) { //exit from recursion
                  System.out.println(mutation);
                  return;
            }
            String newStr = str.substring(0, str.length() - 1);
            System.out.println(newStr);
            printAllPossibleArrangementsABC(newStr);
      }

}
