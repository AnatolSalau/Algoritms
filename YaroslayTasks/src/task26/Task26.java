package task26;

import java.util.Stack;

public class Task26 {
      /**
             Напишите функцию, которая проверяет строку, состоящую из символов "(",")",
             "*", "+" на сбалансированность скобок.
             Примеры входа и выхода функции:
             Вход -> Выход
             ([]) -> true
             (() -> false
             [(]) -> false
             )( -> false
             [[[(([]))][]()]] -> true
       */
      public static void main(String[] args) {
            testOne();
            testTwo();
            testThree();
            testFour();
            testFiver();
      }
      static boolean isRightParenthesesSequence(String str) {
            char[] chars = str.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < chars.length; i++) {
                  char curr = chars[i];

                  if (curr == '(') {
                        stack.push(')');
                        continue;
                  }

                  if (curr == '[') {
                        stack.push(']');
                        continue;
                  }

                  if (stack.isEmpty()) return false;

                  if (curr == ')') {
                        Character pop = stack.pop();
                        if (pop == curr) continue;
                        else return false;
                  }

                  if (curr == ']') {
                        Character pop = stack.pop();
                        if (pop == curr) continue;
                        else return false;
                  }
            }
            return stack.isEmpty();
      }
      static void testOne() {
            String str = "([])";
            String expectedResul = "true";
            boolean answer = isRightParenthesesSequence(str);
            System.out.println(answer);
            System.out.println("Expected : " + expectedResul);
      }

      static private void testTwo() {
            String str = "(()";
            String expectedResul = "false";
            boolean answer = isRightParenthesesSequence(str);
            System.out.println(answer);
            System.out.println("Expected : " + expectedResul);
      }

      static private void testThree() {
            String str = "[(])";
            String expectedResul = "false";
            boolean answer = isRightParenthesesSequence(str);
            System.out.println(answer);
            System.out.println("Expected : " + expectedResul);
      }

      static private void testFour() {
            String str = ")(";
            String expectedResul = "false";
            boolean answer = isRightParenthesesSequence(str);
            System.out.println(answer);
            System.out.println("Expected : " + expectedResul);
      }

      static private void testFiver() {
            String str = "[[[(([]))][]()]]";
            String expectedResul = "true";
            boolean answer = isRightParenthesesSequence(str);
            System.out.println(answer);
            System.out.println("Expected : " + expectedResul);
      }
}
