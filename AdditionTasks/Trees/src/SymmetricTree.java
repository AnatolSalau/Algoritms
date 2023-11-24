import java.util.Stack;

public class SymmetricTree {
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
       * Given the root of a binary tree, check whether it is a mirror of itself
       * (i.e., symmetric around its center).
       */
      public static void main(String[] args) {
            test1();
            test2();
      }

      static boolean isSymmetricTree(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();

            TreeNode left = root.left;
            TreeNode right = root.right;

            stack.push(left);
            stack.push(right);

            while (!stack.isEmpty()) {
                  TreeNode pollRight = stack.pop();
                  TreeNode pollLeft= stack.pop();

                  if (pollRight == null && pollLeft == null) continue;

                  if (pollLeft == null && pollRight != null) return false;

                  if (pollLeft != null && pollRight == null) return false;

                  if (pollLeft.val != pollRight.val) return false;



                  stack.push(pollLeft.left);
                  stack.push(pollRight.right);
                  stack.push(pollLeft.right);
                  stack.push(pollRight.left);

            }
            return true;
      }
      static void test1() {
            TreeNode root1LeftLeft = new TreeNode(2);
            TreeNode root1LeftRight = new TreeNode(3);

            TreeNode root1RightLeft = new TreeNode(3);
            TreeNode root1RightRight = new TreeNode(2);

            TreeNode root1Left = new TreeNode(2, root1LeftLeft, root1LeftRight);
            TreeNode root1Right = new TreeNode(2, root1RightLeft, root1RightRight);

            TreeNode root1 = new TreeNode(1, root1Left,root1Right);

            System.out.println(isSymmetricTree(root1));
      }

      static void test2() {
            TreeNode root1LeftRight = new TreeNode(3);
            TreeNode root1Left = new TreeNode(2, null, root1LeftRight);

            TreeNode root1RightRight = new TreeNode(3);
            TreeNode root1Right = new TreeNode(2, null,root1RightRight);
            TreeNode root1 = new TreeNode(1, root1Left, root1Right);

            System.out.println(isSymmetricTree(root1));
      }

}
