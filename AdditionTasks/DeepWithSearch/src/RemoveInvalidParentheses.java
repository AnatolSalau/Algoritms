import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Stack;

public class RemoveInvalidParentheses {
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
            test2();
            //test3();
      }
      /*
                |
            ()())() -> ()()()
             |
            ()())() -> (())()
       */

      public static void solution(String str, int mra, HashSet<String> ans) {
            if(mra == 0) {
                  int mrNow = getMin(str);
                  if(mrNow == 0) {
                        if(!ans.contains(str)) {
                              System.out.println(str);
                              ans.add(str);
                        }
                  }
                  return;
            }
            for (int i = 0; i < str.length(); i++) {
                  String left = str.substring(0,i);
                  String right = str.substring(i + 1);
                  solution(left+right,mra - 1,ans);
            }
      }

      public static int getMin(String str) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                  char ch = str.charAt(i);
                  if( ch =='(') {
                      stack.push(ch);
                  }
                  else if( ch ==')' ) {
                        if (stack.size() == 0) {
                              stack.push(ch);
                        }
                        else if (stack.peek() == ')') {
                              stack.push(ch);
                        }
                        else if (stack.peek() == '(') {
                              stack.pop();
                        }
                  }
            }

            return  stack.size();
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
            solution(str,getMin(str), new HashSet<>());
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
            solution(str,getMin(str), new HashSet<>());
            System.out.println();
      }

      static void test3() {
            String str = ")(";
            String[] expected = {""};
            System.out.println(str);
            System.out.println("Expected : " + Arrays.toString(expected));
            solution(str,getMin(str), new HashSet<>());
            System.out.println();
      }
}
