import java.util.Stack;

public class ValidParentheses {
      /**
             Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
             determine if the input string is valid.

             An input string is valid if:

             Open brackets must be closed by the same type of brackets.
             Open brackets must be closed in the correct order.
             Every close bracket has a corresponding open bracket of the same type.

             Example 1:
             Input: s = "()"
             Output: true

             Example 2:
             Input: s = "()[]{}"
             Output: true

             Example 3:
             Input: s = "(]"
             Output: false
       */
      public static void main(String[] args) {
            test1();
            test2();
            test3();
      }
      static void test1() {
            String str = "()";
            boolean expectedResult = true;
            ValidParentheses validParentheses = new ValidParentheses();
            boolean result = validParentheses.isValidParentheses(str);
            System.out.println(result);
      }

      static void test2() {
            String str = "()[]{}";
            boolean expectedResult = true;
            ValidParentheses validParentheses = new ValidParentheses();
            boolean result = validParentheses.isValidParentheses(str);
            System.out.println(result);
      }

      static void test3() {
            String str = "(]";
            boolean expectedResult = true;
            ValidParentheses validParentheses = new ValidParentheses();
            boolean result = validParentheses.isValidParentheses(str);
            System.out.println(result);
      }
      /*
            ()[]{}
                  ( | )
                  ) |
                  [ | ]
                  ] |

       */
      boolean isValidParentheses(String str) {
            char[] characters = str.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < characters.length; i++) {
                  char c = characters[i];

                  if(c == '(') {
                        stack.add(')');
                        continue;
                  }
                  if(c == '[') {
                        stack.add(']');
                        continue;
                  }
                  if(c == '{') {
                        stack.add('}');
                        continue;
                  }

                  if (stack.isEmpty()) return false;

                  if (stack.pop() != c) return false;
            }
            return true;
      }
}
