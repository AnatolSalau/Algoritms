public class DeepSearchRecursive {
      /**
       * Calculate sum of all tree's nodes
       */
      public static void main(String[] args) {
            Tree root =
                  new Tree(20,
                        new Tree(7,
                              new Tree(4, null, new Tree(6)), new Tree(9)),
                        new Tree(35,
                              new Tree(31, new Tree(28), null),
                              new Tree(40, new Tree(38), new Tree(52))));
            System.out.println(root);
            System.out.println("Summ all elements = " + root.calculateSumRecursive());
      }

      static class Tree {
            int value;
            Tree left; //left children
            Tree right; // right children

            public Tree(int value) {
                  this.value = value;
                  this.left = null;
                  this.right = null;
            }

            public Tree(int value, Tree left, Tree right) {
                  this.value = value;
                  this.left = left;
                  this.right = right;
            }

            public int calculateSumRecursive() {
                  int sum = value;
                  if(left != null) {
                        sum += left.calculateSumRecursive();
                  }
                  if(right !=null) {
                        sum += right.calculateSumRecursive();
                  }
                  return sum;
            }
            @Override
            public String toString() {
                  return "Tree{" +
                        "value=" + value +
                        ", left=" + left +
                        ", right=" + right +
                        '}';
            }
      }
}


