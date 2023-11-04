import java.util.*;

public class TaskG {
      /**
       * Не секрет, что некоторые программисты очень любят путешествовать.
       * Хорошо всем известный программист Петя тоже очень любит путешествовать,
       * посещать музеи и осматривать достопримечательности других городов.
       * Для перемещений между из города в город он предпочитает использовать машину.
       * При этом он заправляется только на станциях в городах, но не на станциях по пути.
       * Поэтому он очень аккуратно выбирает маршруты, чтобы машина не заглохла в дороге.
       * А ещё Петя очень важный член команды, поэтому он не может себе позволить путешествовать слишком долго.
       * Он решил написать программу, которая поможет ему с выбором очередного путешествия.
       * Но так как сейчас у него слишком много других задач, он попросил вас помочь ему.
       * Расстояние между двумя городами считается как сумма модулей разности по каждой из координат.
       * Дороги есть между всеми парами городов.
       *
       * Формат ввода
       * В первой строке входных данных записано количество городов n
       *  (2≤n≤1000). В следующих n строках даны два целых числа: координаты каждого города,
       * не превосходящие по модулю миллиарда. Все города пронумерованы числами от 1 до n
       * в порядке записи во входных данных.
       * В следующей строке записано целое положительное число k, не превосходящее двух миллиардов,
       * — максимальное расстояние между городами, которое Петя может преодолеть без дозаправки машины.
       * В последней строке записаны два различных числа — номер города, откуда едет Петя, и номер города, куда он едет.
       *
       * Формат вывода
       * Если существуют пути, удовлетворяющие описанным выше условиям, то выведите минимальное количество дорог,
       * которое нужно проехать, чтобы попасть из начальной точки маршрута в конечную. Если пути не существует, выведите -1.
       */
      public static void main(String[] args) {
            Map<Integer,List<Integer>> citiesCoordinates = new HashMap<>();
            citiesCoordinates.put(1, Arrays.asList(0, 0));
            citiesCoordinates.put(2, Arrays.asList(0, 2));
            citiesCoordinates.put(3, Arrays.asList(2, 2));
            citiesCoordinates.put(4, Arrays.asList(0, 2));
            citiesCoordinates.put(5, Arrays.asList(2, 2));
            citiesCoordinates.put(6, Arrays.asList(2, 1));
            citiesCoordinates.put(7, Arrays.asList(2, 1));

            generateMatrix(citiesCoordinates);
      }

      static int[][] generateMatrix(Map<Integer, List<Integer>> citiesCoordinates) {
            int[][] result = new int[citiesCoordinates.size() + 1][citiesCoordinates.size() + 1];
            for (int i = 1; i < result.length ; i++) {
                  for (int j = 1; j < result.length; j++) {
                        result[i][j] = Math.abs(citiesCoordinates.get(i).get(0) - citiesCoordinates.get(j).get(0)) + Math.abs(citiesCoordinates.get(i).get(1) - citiesCoordinates.get(j).get(1));
                  }
            }
            printMatrix(result);
            return null;
      }

      static void printMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                  System.out.println(Arrays.toString(matrix[i]));
            }
      }
}
