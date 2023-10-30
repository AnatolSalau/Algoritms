import java.security.InvalidParameterException;

public class Main {
      /**
       Дана строка, состоящая из букв A-Z:
       * "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB"
       * Нужно написать функцию RLE, которая на выходе даст строку вида:
       * "A4B3C2XYZD4E3F3A6B28"
       * И сгенерирует любую ошибку, если на вход пришла невалидная строка.
       *
       * Пояснения:
       * 1. Если символ встречается 1 раз, он остается без изменений
       * 2. Если символ повторяется более 1 раза, к нему добавляется количество
       повторений
       */
      public static void main(String[] args) {
            String input = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";
            //countCharAtStringWhile(input);
            //countCharAtStringFor(input);
            System.out.println(countChartAtStrMyOwn(input));
      }

      private static void countCharAtStringWhile(String input) throws InvalidParameterException {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (i < input.length()) {
                  char currentCharacter = input.charAt(i);
                  int count = 1;
                  while (i < input.length() - 1) {
                        if (!Character.isAlphabetic(input.charAt(i))) {
                              throw new InvalidParameterException("Invalid character");
                        }
                        if (input.charAt(i + 1) == currentCharacter) {
                              count++;
                              i++;
                        } else {
                              break;
                        }
                  }
                  stringBuilder.append(currentCharacter).append(count);
                  i++;
            }
            System.out.println(stringBuilder.toString());
      }

      private static void countCharAtStringFor(String input) throws InvalidParameterException {
            StringBuilder stringBuilder = new StringBuilder();
            int count = 1;

            for (int i = 0; i < input.length(); i++) {
                  char currentCharacter = input.charAt(i);
                  if (!Character.isAlphabetic(currentCharacter) || Character.isLowerCase(currentCharacter)) {
                        throw new InvalidParameterException("Invalid character");
                  }

                  for (int j = i; j < input.length()-1; j++) {
                        if (input.charAt(j + 1) == currentCharacter) {
                              count++;
                              i++;
                        } else {
                              break;
                        }
                  }

                  stringBuilder.append(currentCharacter).append(count);
                  count = 1;
            }
            System.out.println(stringBuilder.toString());
      }

      private static String countChartAtStrMyOwn(String input) {
            StringBuilder stringBuilder = new StringBuilder();
            int count = 1;
            for (int i = 0; i < input.length(); i++) {
                  char current = input.charAt(i);
                  for (int j = i; j < input.length()-1; j++) {
                        char next = input.charAt(j + 1);
                        if (current == next) {
                              count ++;
                              i++;
                        } else {
                              break;
                        }
                  }
                  stringBuilder.append(current).append(count);
                  count = 1;
            }
            return stringBuilder.toString();
      }
}
