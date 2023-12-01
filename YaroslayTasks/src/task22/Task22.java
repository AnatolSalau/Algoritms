package task22;

import java.util.HashMap;

public class Task22 {
      /**
       * Матрица должна быть валидна в соответствии с нижележащими правилами
       * 1) Каждая строка должна содержать цифру от 1 до 9 без повторений
       * 2) Каждая колонка должна содержать цифру от 1 до 9 без повторений
       * 3) Матрица может частично заполнена, пустые ячейки содержат '.'
       * 4) Значение ячейки валидно если это цифра от 1 до 9 или .
       * 5) Наличие букв в качестве значений недопустимо
       */
      public static void main(String[] args) {
            char[][] matrix = {
                    {'5', '3', '1', '.', '7', '.', '.', '.', '.'}
                  , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                  , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                  , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                  , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                  , {'7', '.', '.', '.', '.', '.', '.', '.', '6'}
                  , {'1', '6', '.', '.', '.', '.', '2', '8', '.'}
                  , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                  , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };
            System.out.println(validMatrix(matrix));
      }

      static boolean validMatrix(char[][] matrix) {
            return goThroughAllColumns(matrix) == goThroughAllLines(matrix);
      }

      static boolean goThroughAllLines(char[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                  HashMap<Character, Integer> characterFrequencyMap = getCharFreqMap();
                  char[] line = matrix[i];
                  for (int j = 0; j < line.length; j++) {
                        char curr = line[j];
                        if (!validateCharacter(curr, characterFrequencyMap)) return false;
                  }
            }
            return true;
      }

      static boolean goThroughAllColumns(char[][] matrix) {
                  for (int x = 0; x < matrix.length; x++) {
                        HashMap<Character, Integer> characterFrequencyMap = getCharFreqMap();
                        for (int y = 0; y < matrix.length; y++) {
                              char curr = matrix[y][x];
                              if (!validateCharacter(curr, characterFrequencyMap)) return false;
                        }
                  }
            return true;
      }

      static boolean validateCharacter(Character character, HashMap<Character, Integer> freqMap) {
            if (freqMap.containsKey(character)) {
                  int quantity = freqMap.get(character);
                  if (quantity >= 0) {
                        if (quantity != 1) return false;
                        quantity -= 1;
                        freqMap.put(character, quantity);
                  }
                  return true;
            } else {
                  return false;
            }
      }
      static HashMap<Character, Integer> getCharFreqMap() {
            HashMap<Character, Integer> characterFrequencyMap = new HashMap<>();
            characterFrequencyMap.put('1', 1);
            characterFrequencyMap.put('2', 1);
            characterFrequencyMap.put('3', 1);
            characterFrequencyMap.put('4', 1);
            characterFrequencyMap.put('5', 1);
            characterFrequencyMap.put('6', 1);
            characterFrequencyMap.put('7', 1);
            characterFrequencyMap.put('8', 1);
            characterFrequencyMap.put('9', 1);
            characterFrequencyMap.put('.', -1);
            return characterFrequencyMap;
      }

}
