package task11;

import java.util.Arrays;
import java.util.Random;

public class Task11 {
      /**
       Необходимо outputSize раз взять случайным образом элементы из списка input и
       поместить
       * их в выходной список. Повторения допустимы.
       *
       *  input  - входной список
       *  outputSize - размер выходного списка
       *  result - выходной список со случайными элементами из входного списка
       */
      public static void main(String[] args) {
            int[] input = {1,2,3};
            int[] result = getRandomArr(input, 6);
            System.out.println(Arrays.toString(result));
      }

      static int[] getRandomArr(int[] input, int outputSize) {
            Random random = new Random();
            int[] result = new int[outputSize];

            for (int j = 0; j < result.length; j++) {
                  int randomInputIndex = random.nextInt(input.length);
                  result[j] = input[randomInputIndex];
            }

            return result;
      }
}
