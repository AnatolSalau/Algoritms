package task27;

public class Task27 {
      /**
            Реверс числа без использования строк
       */
      /**
       Алгоритм:

       1. Найдем остаток от деления на 10 исходного (первого) числа. Тем самым получим последнюю его цифру. Запомним ее.
       2. Присвоим эту цифру новому (второму) числу-"перевертышу".
       3. Разделим нацело на 10 первое число. Тем самым избавимся от последней цифры в нем.
       4.  Снова найдем остаток от деления на 10 того, что осталось от первого числа. Запомним цифру-остаток.
       5. Разделим нацело на 10 первое число. Избавимся от текущей последней цифры в нем.
       Умножим на 10 второе число. Тем самым увеличим его разрядность до двух и сдвинем первую цифру в более старший разряд.
       Добавим к полученному второму числу запомненную ранее цифру из первого числа.
       Будем повторять действия п. 4-7 пока первое число не уменьшится до нуля, т. е. пока не избавимся от всех его разрядов.
       */
      public static void main(String[] args) {
            testOne();
      }
      private static int getReverseNum(int num) {
            int newNum = num % 10; // get last character from number
            num = num / 10; // reduce the number by one ten

            while (num > 0) {
                  newNum = newNum * 10;
                  newNum += num % 10;
                  num = num / 10;
            }
            return newNum;
      }

      private static void testOne() {
            int num = 123;
            int expectedResult = 321;
            System.out.println(getReverseNum(num));
            System.out.println("Expected result = " + expectedResult);
      }
}
