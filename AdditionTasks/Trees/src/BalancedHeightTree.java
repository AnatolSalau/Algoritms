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
            test1();
            test2();
      }

      static int getMaxHeightOfTree(TreeNode node) {
            TreeNode leftRoot = node.left;
            TreeNode rightRoot = node.right;

            if (leftRoot == null && rightRoot == null) {
                  return 0;
            }

            int leftHeight = getHeightOfMaxHeight(leftRoot, 0);
            int rightHeight = getHeightOfMaxHeight(rightRoot, 0);

            int maxHeight = Math.max(leftHeight, rightHeight);

            return maxHeight;
      }

     static int getHeightOfMaxHeight(TreeNode node, int height) {
            //exit from recursion
            if (node == null) return height;
            //direct way of recursion
            int newHeight = height;
            newHeight++;

           int leftHeight = getHeightOfMaxHeight(node.left, newHeight);
           int rightHeight = getHeightOfMaxHeight(node.right, newHeight);
            //revers way of recursion
            return Math.max(leftHeight, rightHeight);
      }

      static int getMaxHeightOfIsBalanced(TreeNode node, int height) {
            //exit from recursion
            if (node == null) return height;
            //direct way of recursion
            int newHeight = height;
            newHeight++;

            int leftHeight = getMaxHeightOfIsBalanced(node.left, newHeight);
            int rightHeight = getMaxHeightOfIsBalanced(node.right, newHeight);

            int deviation = Math.abs(leftHeight - rightHeight);
            // if difference more than 1 return -1
            if (deviation > 1) return -1;
            //if difference less than 1 - to return max height
            return Math.max(leftHeight, rightHeight);
      }
     static boolean isBalanced(TreeNode node) {

           if (node == null) return true;

           TreeNode leftRoot = node.left;
           TreeNode rightRoot = node.right;

           if (leftRoot == null && rightRoot == null) {
                 return true;
           }

           int leftDeviation = getMaxHeightOfIsBalanced(leftRoot, 0);
           int rightDeviation = getMaxHeightOfIsBalanced(rightRoot, 0);

           //revers way of recursion

           if (leftDeviation == -1 || rightDeviation == -1) return false;

           int maxDeviation = Math.abs (leftDeviation - rightDeviation);

           // max deviation between leftRoot and rightRoot more 1 return false
           return maxDeviation <= 1;
      }

      static void test1() {
            TreeNode root2RightLeft = new TreeNode(15, null, null);
            TreeNode root2RightRight = new TreeNode(7, null, null);

            TreeNode root2Left = new TreeNode(9, null, null);
            TreeNode root2Right = new TreeNode(20, root2RightLeft,root2RightRight);

            TreeNode root2 = new TreeNode(3,root2Left, root2Right);
            System.out.println(getMaxHeightOfTree(root2));
            System.out.println("isBalanced " + isBalanced(root2));
            System.out.println("Expected : true");
      }

      static void test2() {
            TreeNode n30 = new TreeNode(30, null, null);
            TreeNode n31= new TreeNode(31, null, null);

            TreeNode n20 = new TreeNode(20, n30, n31);
            TreeNode n21 = new TreeNode(21, null, null);

            TreeNode n10 = new TreeNode(10, n20,n21);
            TreeNode n11 = new TreeNode(11, null,null);

            TreeNode root00 = new TreeNode(00,n10, n11);
            System.out.println(getMaxHeightOfTree(root00));
            System.out.println("isBalanced " + isBalanced(root00));
            System.out.println("Expected : false");
      }
}
