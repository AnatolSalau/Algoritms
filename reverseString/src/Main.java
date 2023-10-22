class Main
{
      // Метод обращения строки в Java с использованием массива символов
      public static String reverse(String str)
      {
            // возвращаем, если строка нулевая или пустая
            if (str == null || str.equals("")) {
                  return str;
            }

            // создаем массив символов и инициализируем его заданной строкой
            char[] c = str.toCharArray();

            for (int l = 0, h = str.length() - 1; l < h; l++, h--)
            {
                  // поменять местами значения в `l` и `h`
                  char temp = c[l];
                  c[l] = c[h];
                  c[h] = temp;
            }

            // преобразовать массив символов в строку и вернуться
            return String.copyValueOf(c);
      }

      public static void main(String[] args)
      {
            String str = "First second";

            // Строка неизменна
            str = reverse(str);

            System.out.println("Reversed string is: " + str);
      }
}