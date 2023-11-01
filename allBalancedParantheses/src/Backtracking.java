/*
  Java Program
  Print all combinations of balanced parentheses
  https://kalkicode.com/print-combinations-balanced-parentheses
*/
public class Backtracking
{
      void balancedBracket(String result,
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
            Backtracking task = new Backtracking();
            // This is a size of balanced parentheses
            int size = 4;
            task.balancedBracket("", size, 0, 0);
      }
}