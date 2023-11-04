import java.util.*;

public class AllCombinationThree {
      public static void main(String[] args) {
            List<Character> list = new ArrayList<>();
            list.add('(');
            list.add('(');
            list.add('(');
            list.add(')');
            list.add(')');
            list.add(')');

            List<Character> mutation = new ArrayList<>();

            Set<List<Character>> rightCombinations = new LinkedHashSet<>();

            makeAllCombinations(list, mutation, rightCombinations, 0);

            System.out.println(rightCombinations);
      }

      static void makeAllCombinations(List<Character> list, List<Character> mutation, Set<List<Character>> result, int depth ) {
            // exit from recursion
            if (list.size() == 0) {
                  if (isRegularBracketExpression(mutation)) {
                        result.add(mutation);
                  }
                  return;
            }

            for (int i = 0;i < list.size() ; i++) {
                  Character currChar = list.get(i);

                  List<Character> leftSubList = list.subList(0, i);
                  List<Character> rightSublist = list.subList(i + 1, list.size());

                  List<Character> newList = new ArrayList<>();
                  newList.addAll(leftSubList);
                  newList.addAll(rightSublist);

                  List<Character> newMutation = new ArrayList<>();
                  newMutation.addAll(mutation);
                  newMutation.add(currChar);

                  depth++;

                  if(!newMutation.isEmpty() && newMutation.get(0) == '(') {
                        makeAllCombinations(newList, newMutation, result,depth);
                  }
            }
      }

      static boolean isRegularBracketExpression (List<Character> bracketsList) {
            if(bracketsList.isEmpty() || bracketsList.get(0) == ')' || bracketsList.get(bracketsList.size() - 1) == '(') return false;

            int count = 0;
            for (int i = 0; i < bracketsList.size(); i++) {
                  if(bracketsList.get(i) == '(') {
                        count++;
                  } else {
                        count--;
                  }
            }
            if (count < 0) return false;
            return count == 0;
      }

}
