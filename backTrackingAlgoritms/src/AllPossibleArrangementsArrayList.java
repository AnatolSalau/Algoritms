import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPossibleArrangementsArrayList {
      public static void main(String[] args) {
            List<Character> characters = new ArrayList<>();
            List<Character> mutations = new ArrayList<>();
            characters.add('A');
            characters.add('B');
            characters.add('C');
            long start = System.nanoTime();
            printAllCombinations(characters, mutations, 0);
            long end = System.nanoTime();
            System.out.println("Execution time = " + (end - start));
      }

      static void printAllCombinations(List<Character> characters, List<Character> mutation, int depth) {
            //exit from recursion
            if (characters.size() == 0) {
                  System.out.println("Mutation : " + mutation);
                  return;
            }

            for (int i = 0; i <  characters.size() ; i++ ) {
                  Character currChar = characters.get(i);

                  List<Character> left = characters.subList(0, i);

                  List<Character> right = characters.subList(i+1, characters.size());

                  List<Character> newCharacters = new ArrayList<>();
                  newCharacters.addAll(left);
                  newCharacters.addAll(right);

                  List<Character> newMutation = new ArrayList<>();
                  newMutation.addAll(mutation);
                  newMutation.add(currChar);

                  depth++;

                  printAllCombinations(newCharacters, newMutation, depth);
            }
      }

}
