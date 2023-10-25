public class DeepSearchIterable {
      public static void main(String[] args) {
            DeepSearchIterable.Tree root =
                  new DeepSearchIterable.Tree(20,
                        new DeepSearchIterable.Tree(7,
                              new DeepSearchIterable.Tree(4, null, new DeepSearchIterable.Tree(6)), new DeepSearchIterable.Tree(9)),
                        new DeepSearchIterable.Tree(35,
                              new DeepSearchIterable.Tree(31, new DeepSearchIterable.Tree(28), null),
                              new DeepSearchIterable.Tree(40, new DeepSearchIterable.Tree(38), new DeepSearchIterable.Tree(52))));
            System.out.println(root);
            System.out.println("Summ all elements (calculateSumIterableInDepth) = " + root.calculateSumIterableInDepth());
            System.out.println("Summ all elements (calculateSumIterableInWidth) = " + root.calculateSumIterableInWidth());

      }

      static class Tree {
            int value;
            DeepSearchIterable.Tree left; //left children
            DeepSearchIterable.Tree right; // right children

            public Tree(int value) {
                  this.value = value;
                  this.left = null;
                  this.right = null;
            }

            public Tree(int value, DeepSearchIterable.Tree left, DeepSearchIterable.Tree right) {
                  this.value = value;
                  this.left = left;
                  this.right = right;
            }

            public int calculateSumIterableInDepth() {
                  StackImpl<Tree> stack = new StackImpl<>();
                  //add tree's root in stack
                  stack.push(this);
                  int sum = 0;
                  while (!stack.isEmpty()) {
                        Tree node = stack.pop();
                        sum += node.value;
                        //if there is a left child
                        if(node.left != null) {
                              stack.push(node.left);
                        }
                        //if there is a right child
                        if(node.right != null) {
                              stack.push(node.right);
                        }
                  }
                  return sum;
            }

            public int calculateSumIterableInWidth() {
                  QueueImpl<Tree> queue = new QueueImpl<>();
                  //add tree's root in stack
                  queue.add(this);
                  int sum = 0;
                  while (!queue.isEmpty()) {
                        Tree node = queue.remove();
                        sum += node.value;
                        //if there is a left child
                        if(node.left != null) {
                              queue.add(node.left);
                        }
                        //if there is a right child
                        if(node.right != null) {
                              queue.add(node.right);
                        }
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
