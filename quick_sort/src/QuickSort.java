import java.util.Arrays;

public class QuickSort {
      public static void main(String[] args) {
            int[] arr = {4, 5, 2, 3};
      }

      private static void doSort(int[] arr, int low, int high) {
            //Выход из рекурсии
            if (arr.length == 0 || low >= high) return;

            //Выбираем опорный элемент
            //Индекс середины
            int middle = low + (high - low) / 2;
            //элемент сравнения
            int border = arr[middle];

            //разделяем на подмассивы, сравниваем и меняем местами
            int i = low;
            int j = high;

            while (i <= j) {

            }
      }
}
