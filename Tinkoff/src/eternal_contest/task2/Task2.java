package eternal_contest.task2;

/**
       * Ваня принес рулет и хочет порезать его на N равных частей.
       * Рулет можно разрезать только поперек.
       * Следовательно Костя сделает только N-1 разрезов
       *
       * Вася задумался - можно ли сделать меньше разрезов.
       * Если нож бесконечно - длинный.
       *
       * Оказывается можно: чтобы получить 4 куска - нужно сделать всего 2 разреза.
       * В начале на 2 половинки, а потом эти две половинки - одним разрезом на 4 куска.
       *
       * Вам дано число N. Каким минимальным числом можно обойтись?
       *
       * Ввод:
       * N - количество кусков
       *
       * Вывод:
       * одно число - минимальное число разрезов.
       *
       * Пример 1:
       * 6 частей требуется
       * 3 разреза надо
       *
       * Пример 2:
       * 5 частей требуется
       * 3 разреза надо
 */
public class Task2 {
      public static void main(String[] args) {

      }

      private static void testOne() {
            int piecesCount = 6;
            int expectedResult = 3;
      }

      private static void testTwo() {
            int piecesCount = 5;
            int expectedResult = 3;
      }

      private static void testThree() {
            int piecesCount = 4;
            int expectedResult = 2;
      }

      /*    1 2 3 |4 5 6 7
            - - - |- - - -    -> 1

            1 |2 |3
            - |- |-
            4 |5 |6 |7
            - |- |- |-        -> 1 + 2 + 1 = 4;
       */
      private static void testFour() {
            int piecesCount = 7;
            int expectedResult = 4;
      }
      /*
            1 2 3 | 4 5 6 | 7 8 9 |10 11     -> 3

            1 |2  |3
            4 |5  |6
            7 |8  |9
           10 |11                   -> 3 + 2 = 5
       */
            /*
            1 2 3  4 5 | 6  7 8 9 10 11     -> 1

            1 2 3 |4 5
            5 6 7 |8 9 10 11                    -> 1 + 1

            1 2 |3
            4 5 |
            5 6 |7
            8 9 |10 11                    -> 1+ 1+ 1

            1 |2
            4 |5
            5 |6
            8 |9
            3 |
            7 |
           10 |11                   -> 1 + 1 + 1 + 1 = 4

       */
      private static void testFive() {
            int piecesCount = 11;
            int expectedResult = 2;
      }
}


