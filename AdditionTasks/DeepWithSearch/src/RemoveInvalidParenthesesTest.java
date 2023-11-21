import java.util.*;

public class RemoveInvalidParenthesesTest {
      /**
       Given a string s that contains parentheses and letters,
       remove the minimum number of invalid parentheses to make the input string valid.

       Return a list of unique strings that are valid with the minimum number of removals.
       You may return the answer in any order.

       Example 1:

       Input: s = "()())()"
       Output: ["(())()","()()()"]

       Example 2:

       Input: s = "(a)())()"
       Output: ["(a())()","(a)()()"]

       Example 3:

       Input: s = ")("
       Output: [""]
       */
      public static void main(String[] args) {
            //test1();
            //test2();
            //test3();
            String str = ")(a)())()";
            int qtyWrongParentheses = getQtyWrongParentheses(str);
            System.out.println(str);
            System.out.println("qtyWrongParentheses = " + qtyWrongParentheses);
            String abc = "ABC";
            allVariationParentheses(abc, 1);
      }

      public List<String> getAllValidParentheses(String string) {
            List<String> result = new ArrayList<>();

            return result;
      }

      static void allVariationParentheses(String str, int qtyWrongParenthesesAllowed) {
            if (qtyWrongParenthesesAllowed == 0) {
                  System.out.println(str);
                  return;
            }
            for (int i = 0; i < str.length(); i++) {
                  String left = str.substring(0, i);
                  String right = str.substring(i+1);
                  String newStr = left + right;
                  allVariationParentheses(newStr, qtyWrongParenthesesAllowed - 1);
            }
      }

      static private int getQtyWrongParentheses(String string) {
            Stack<Character> stack = new Stack<>();
            char[] chars = string.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                  char curr = chars[i];
                  if (curr == '(') {
                        stack.push(curr);
                        continue;
                  }
                  if(curr == ')' ) {
                        if (!stack.isEmpty()) {
                              Character topPeek = stack.peek();
                              if (topPeek == '(') {
                                    stack.pop();
                                    continue;
                              }
                        }
                        stack.push(curr);
                  }

            }

            int result = stack.size();
            return result;
      }

      /*
                |
            ()())() -> ()()()
             |
            ()())() -> (())()
       */
      static void test1() {
            String str = "()())()";
            String[] expected = {"(())()","()()()"};
            System.out.println(str);
            System.out.println("Expected : " + Arrays.toString(expected));

            System.out.println();
      }
      /*
                 |
            (a)())() -> (a)()()
              |
            (a)())() -> (a())()
       */
      static void test2() {
            String str = ")(a)())()";
            String[] expected = {"(a())()","(a)()()"};
            System.out.println(str);
            System.out.println("Expected : " + Arrays.toString(expected));

            System.out.println();
      }

      static void test3() {
            String str = ")(";
            String[] expected = {""};
            System.out.println(str);
            System.out.println("Expected : " + Arrays.toString(expected));

            System.out.println();
      }
}
