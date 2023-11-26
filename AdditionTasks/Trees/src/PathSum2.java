import java.util.LinkedList;
import java.util.List;

public class PathSum2 {
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
       Given the root of a binary tree and an integer targetSum,
       return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
       Each path should be returned as a list of the node values, not node references.

       A root-to-leaf path is a path starting from the root and ending at any leaf node.
       A leaf is a node with no children.

       Example 1 :
       Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
       Output: [[5,4,11,2],[5,8,4,5]]
       Explanation: There are two paths whose sum equals targetSum:
       5 + 4 + 11 + 2 = 22
       5 + 8 + 4 + 5 = 22

       Example 2 :
       Input: root = [1,2,3], targetSum = 5
       Output: []

       Example 3 :

       Input: root = [1,2], targetSum = 0
       Output: []
       */
      public static void main(String[] args) {
            testOne();
      }
      public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new LinkedList<>();
            List<Integer> pathSum = new LinkedList<>();
            getPath(root,0, pathSum, targetSum, result);
            return result;
      }

      List<Integer> getPath(TreeNode node, int previousVal, List<Integer> pathValues, int target, List<List<Integer>> result) {
            int val = node.val;

            pathValues.add(val);

            int currSum = val + previousVal;

            if (node.left != null) {
                  getPath(node.left, currSum, pathValues,target, result);
            }
            if (node.right != null) {
                  getPath(node.right, currSum, pathValues,target, result);
            }

            if (node.left == null && node.right == null) {
                  if (currSum == target) {
                        result.add(pathValues);
                        return pathValues;
                  }
                  pathValues.remove(val);
                  return pathValues;
            }
            pathValues.remove(val);
            return pathValues;
      }
      static void testOne() {
            TreeNode root1 = new TreeNode( 1, null, null);
            TreeNode root5 = new TreeNode( 5, null, null);
            TreeNode root2 = new TreeNode( 2, null, null);
            TreeNode root7 = new TreeNode( 7, null, null);
            TreeNode root4_2 = new TreeNode( 4, root5, root1);
            TreeNode root13 = new TreeNode( 13, null, null);
            TreeNode root11 = new TreeNode( 11, root7, root2);
            TreeNode root8 = new TreeNode( 8, root13, root4_2);
            TreeNode root4_1 = new TreeNode( 4, root11, null);
            TreeNode root = new TreeNode( 5, root4_1, root8);
            int target = 22;

            PathSum2 pathSum2 = new PathSum2();
            List<List<Integer>> result = pathSum2.pathSum(root, target);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + "[[5,4,11,2],[5,8,4,5]]");

      }
}
