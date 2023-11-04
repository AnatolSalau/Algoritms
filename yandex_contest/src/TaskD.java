public class TaskD {
      /**
       Дано целое число n. Требуется вывести все правильные скобочные последовательности длины 2 ⋅ n,
       упорядоченные лексикографически (см. https://ru.wikipedia.org/wiki/Лексикографический_порядок).

       В задаче используются только круглые скобки.

       Желательно получить решение, которое работает за время,
       пропорциональное общему количеству правильных скобочных последовательностей в ответе,
       и при этом использует объём памяти, пропорциональный n.
       */
      static void balancedBracket(String result,
                           int size,
                           int open,
                           int close)
      {

            if (close == size)
            {
                  // When get the result of parentheses in given size
                  System.out.println(result);
                  return;
            }
            if (open < size)
            {
                  // Add open parentheses
                  balancedBracket(result + "(",
                        size,
                        open + 1,
                        close);
            }
            if (open > close)
            {
                  // Add close parentheses
                  balancedBracket(result + ")",
                        size,
                        open,
                        close + 1);
            }
      }
      public static void main(String[] args)
      {
            // This is a size of balanced parentheses
            int size = 4;
            int open = 0;
            int close = 0;

            balancedBracket("", size, open, close);
      }
}
