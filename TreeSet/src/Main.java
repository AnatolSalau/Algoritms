import java.util.TreeSet;

public class Main {
      public static void main(String[] args) {
            TreeSet<Integer> set = new TreeSet<>();

            set.add(9);
            set.add(8);
            set.add(5);
            set.add(7);
            set.add(1);
            set.add(2);
            set.add(9);
            set.add(9);

            while (!set.isEmpty()) {
                  Integer first = set.pollFirst();
                  System.out.println("first is = " + first);
            }
            System.out.println();
            set.add(9);
            set.add(8);
            set.add(5);
            set.add(7);
            set.add(1);
            set.add(2);
            set.add(9);
            set.add(9);

            while (!set.isEmpty()) {
                  Integer last = set.pollLast();
                  System.out.println("first is = " + last);
            }
      }
}
