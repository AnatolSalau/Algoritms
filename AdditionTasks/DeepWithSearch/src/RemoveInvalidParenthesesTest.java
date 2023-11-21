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
            test1();
            test2();
            test3();

      }

      static public Set<String> getAllValidParentheses(String string) {
            Set<String> result = new HashSet<>();
            allVariationParentheses(string, getQtyWrongParentheses(string), result);
            return result;
      }

      static void allVariationParentheses(String str, int qtyWrongParenthesesAllowed, Set<String> result) {
            if (qtyWrongParenthesesAllowed == 0) {
                  int qtyWrongParenthesesNow = getQtyWrongParentheses(str);
                  if (qtyWrongParenthesesNow == 0 && !result.contains(str)) {
                        result.add(str);
                  }
                  return;
            }
            for (int i = 0; i < str.length(); i++) {
                  String left = str.substring(0, i);
                  String right = str.substring(i+1);
                  String newStr = left + right;
                  allVariationParentheses(newStr, qtyWrongParenthesesAllowed - 1, result);
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
            Set<String> allValidParentheses = getAllValidParentheses(str);
            System.out.println(allValidParentheses);
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
            Set<String> allValidParentheses = getAllValidParentheses(str);
            System.out.println(allValidParentheses);
            System.out.println();
      }

      static void test3() {
            String str = ")(";
            String[] expected = {""};
            System.out.println(str);
            System.out.println("Expected : " + Arrays.toString(expected));
            Set<String> allValidParentheses = getAllValidParentheses(str);
            System.out.println(allValidParentheses);
            System.out.println();
      }
}
