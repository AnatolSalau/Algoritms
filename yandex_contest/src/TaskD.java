public class TaskD {
      /**
       Дано целое число n. Требуется вывести все правильные скобочные последовательности длины 2 ⋅ n,
       упорядоченные лексикографически (см. https://ru.wikipedia.org/wiki/Лексикографический_порядок).

       В задаче используются только круглые скобки.

       Желательно получить решение, которое работает за время,
       пропорциональное общему количеству правильных скобочных последовательностей в ответе,
       и при этом использует объём памяти, пропорциональный n.
       */

      public static void main(String[] args)
      {
            // This is a size of balanced parentheses
            int size = 4;
            int open = 0;
            int close = 0;

            printBalancedBracket("", size, open, close);
      }

      private static void printBalancedBracket(String result, int size, int open, int close) {
            if (close == size) {
                  System.out.println(result);
                  return;
            }

            if (open < size) {
                  printBalancedBracket(result + "(", size, open +1, close);
            }

            if(open > close) {
                  printBalancedBracket(result + ")", size, open , close+1);
            }
      }
}
