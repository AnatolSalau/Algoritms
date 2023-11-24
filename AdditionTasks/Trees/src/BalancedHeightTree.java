public class BalancedHeightTree {

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
       * Given a binary tree, determine if it is
       * height-balanced
       *
       * A height balanced binary tree is a binary tree
       * in which the height of the left subtree and right subtree of any node
       * does not differ by more than 1 and both the left and right subtree are also height balanced
       */
      public static void main(String[] args) {

      }

      static boolean isHeightBalancedTree(TreeNode node) {
            TreeNode leftRoot = node.left;
            TreeNode rightRoot = node.right;


      }

      static void test1() {
            TreeNode root2RightLeft = new TreeNode(15, null, null);
            TreeNode root2RightRight = new TreeNode(7, null, null);

            TreeNode root2Left = new TreeNode(9, null, null);
            TreeNode root2Right = new TreeNode(20, root2RightLeft,root2RightRight);

            TreeNode root2 = new TreeNode(3,root2Left, root2Right);
            System.out.println(isHeightBalancedTree(root2));
            System.out.println("Expected : true");
      }

      static void test2() {
            TreeNode root2LeftLeftLeft = new TreeNode(4, null, null);
            TreeNode root2LeftLeftRight= new TreeNode(4, null, null);

            TreeNode root2LeftLeft = new TreeNode(15, root2LeftLeftLeft, root2LeftLeftRight);
            TreeNode root2LeftRight = new TreeNode(7, null, null);

            TreeNode root2Left = new TreeNode(2, root2LeftLeft,root2LeftRight);
            TreeNode root2Right = new TreeNode(2, null,null);

            TreeNode root2 = new TreeNode(1,root2Left, root2Right);
            System.out.println(isHeightBalancedTree(root2));
            System.out.println("Expected : false");
      }
}
