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

      }
      static void test1() {
            String str = "()";
            boolean expectedResult = true;
      }

      static void test2() {
            String str = "()[]{}";
            boolean expectedResult = true;
      }

      static void test3() {
            String str = "(]";
            boolean expectedResult = true;
      }

      boolean isValidParentheses(String str) {
            return true;
      }
}
