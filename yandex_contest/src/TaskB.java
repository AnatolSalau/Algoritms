public class TaskB {
      /**
       * Требуется найти в бинарном векторе самую длинную последовательность единиц и вывести её длину.
       * Желательно получить решение, работающее за линейное время и при этом проходящее по входному массиву только один раз.
       */
      public static void main(String[] args) {
            // max ones length = 9
            int[] arr = {0,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,0,0,0,0};
            int[] arr1 = {1,1,1,1,1};
            //int maxOneLength = getMaxOneLength(arr);
            int maxOneLength = getMaxOneLengthTest(arr);
            System.out.println(maxOneLength);

      }

      static int getMaxOneLength(int[] arr) {
            int count = 0;
            int tempCount = 0;
            for (int i = 0; i < arr.length; i++) {
                  if (arr[i] == 1) {
                        tempCount ++;
                  }
                  if(arr[i] == 0 && tempCount > count) {
                        count = tempCount;
                        tempCount = 0;
                  }

            }

            if(tempCount > count) {
                  return  tempCount;
            }
            return count;
      }

      static int getMaxOneLengthTest(int[] arr) {
            int maxCount = 0;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                  if(arr[i] == 1) {
                        count++;
                  }
                  if (arr[i] == 0) {
                        maxCount = count > maxCount ? count : maxCount;
                        count = 0;
                  }
            }

            return maxCount;
      }
}
