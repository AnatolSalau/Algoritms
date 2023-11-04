import java.util.ArrayList;
import java.util.List;

public class AllCombinationThree {
      public static void main(String[] args) {
            List<Character> list = new ArrayList<>();
            list.add('(');
            list.add('(');
/*            list.add('(');
            list.add(')');*/
            list.add(')');
            list.add(')');

            List<Character> mutation = new ArrayList<>();

            List<Character> rightCombinations = new ArrayList<>();

            makeAllCombinations(list, mutation, rightCombinations, 0);
      }

      static void makeAllCombinations(List<Character> list, List<Character> mutation, List<Character> result, int depth ) {
            // exit from recursion
            if (list.size() == 0) {
                  System.out.println(mutation);
                  return;
            }
            if (mutation.size() != 0 ) {
                  if(isRegularBracketSequence(mutation) == false) {
                        return;
                  }
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

                  makeAllCombinations(newList, newMutation, result,depth);
            }
      }

      static boolean isRegularBracketSequence(List<Character> brackets) {
            // check first
            if (brackets.get(0) == ')') {
                  return false;
            }
            // check last
            if (brackets.get(brackets.size()-1) == '(') {
                  return false;
            }
            int count = 0;
            for (int i = 0; i<brackets.size(); i ++) {
                  if(brackets.get(i) == '(') count++;
                  if(brackets.get(i) == ')') count--;
            }
            if (count < 0) return false;
            return count == 0;
      }
}
