import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
      public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                  this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                  this.val = val;
                  this.left = left;
                  this.right = right;
            }
      }

      /**
       * Given the roots of two binary trees p and q,
       * write a function to check if they are the same or not.
       *
       * Two binary trees are considered the same if they are structurally identical,
       * and the nodes have the same value.
       */
      public static void main(String[] args) {
            test1();
            test2();
            test3();
      }

      static boolean isEqualBinaryTree(TreeNode rootOne, TreeNode rootTwo) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(rootOne);
            queue.add(rootTwo);

            while (!queue.isEmpty()) {
                  TreeNode pollOne = queue.poll();
                  TreeNode pollTwo = queue.poll();

                  if (pollOne == null && pollTwo == null) continue;


                  if (pollOne == null && pollTwo != null) return false;


                  if (pollTwo == null && pollOne != null) return false;


                  if (pollOne.val != pollTwo.val)  return false;

                  queue.add(pollOne.left);
                  queue.add(pollTwo.left);

                  queue.add(pollOne.right);
                  queue.add(pollTwo.right);
            }

            return true;
      }

      static void test1() {
            TreeNode root1Left = new TreeNode(2);
            TreeNode root1Right = new TreeNode(3);

            TreeNode root1 = new TreeNode(1, root1Left,root1Right);

            TreeNode root2Left = new TreeNode(2);
            TreeNode root2Right = new TreeNode(3);

            TreeNode root2 = new TreeNode(1,root2Left, root2Right);
            System.out.println(isEqualBinaryTree(root1,root2));
      }

      static void test2() {
            TreeNode root1Left = new TreeNode(2);
            TreeNode root1 = new TreeNode(1, root1Left, null);

            TreeNode root2Right= new TreeNode(2);
            TreeNode root2 = new TreeNode(1, null, root2Right);
            System.out.println(isEqualBinaryTree(root1,root2));
      }

      static void test3() {
            TreeNode root1Left = new TreeNode(2);
            TreeNode root1Right = new TreeNode(3);

            TreeNode root1 = new TreeNode(1, root1Left,root1Right);

            TreeNode root2Left = new TreeNode(2);
            TreeNode root2Right = new TreeNode(3);

            TreeNode root2 = new TreeNode(1,root2Right, root2Left);
            System.out.println(isEqualBinaryTree(root1,root2));
      }
}
