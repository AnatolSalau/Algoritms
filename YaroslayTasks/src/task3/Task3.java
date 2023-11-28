package task3;

import java.util.*;

/**
       Дано бинарное дерево с выделенным корнем, в каждой вершине которого
       записано по одной букве A-Z.
       Две вершины считаются эквивалентными, если поддеревья этих вершин
       содержат одинаковое множество (т.е. без учета частот) букв.
       Нужно найти две эквивалентные вершины с максимальным суммарным
       размером поддеревьев.
 */
public class Task3 {
      public static class TreeNode {
            String name;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(String name) {
                  this.name = name;
            }

            TreeNode(String name, TreeNode left, TreeNode right) {
                  this.name = name;
                  this.left = left;
                  this.right = right;
            }
      }
      public static void main(String[] args) {
            TreeNode leftLeft = new TreeNode("C");
            TreeNode leftRight = new TreeNode("D");

            TreeNode rightLeftLeft = new TreeNode("C");
            TreeNode rightLeftRight = new TreeNode("C");
            TreeNode rightLeft = new TreeNode("C", rightLeftLeft, rightLeftRight);

            TreeNode rightRightLeft = new TreeNode("C");
            TreeNode rightRightRight = new TreeNode("D");
            TreeNode rightRight = new TreeNode("D", rightRightLeft, rightRightRight);

            TreeNode left = new TreeNode("B", leftLeft, leftRight);
            TreeNode right = new TreeNode("B", rightLeft, rightRight);

            TreeNode root = new TreeNode("A",left, right);

            getTwoEquivalentSubTree(root);
      }


      static TreeNode[] getTwoEquivalentSubTree(TreeNode root) {
            HashMap<Set<String>, Integer> setQuantityMap = new HashMap<>();
            System.out.println(setQuantityMap);
            fillSetQuantityMap(root.right, setQuantityMap);
            System.out.println(setQuantityMap);
            return null;
      }

      static void fillSetQuantityMap(TreeNode node, HashMap<Set<String>, Integer> setQuantityMap) {
            String name = node.name;
            Set<String> allNames = new HashSet<>();
            allNames.add(name);

            Queue<TreeNode> queue = new LinkedList<>();

            if (node.left != null) {
                  queue.add(node.left);
            }
            if (node.right != null) {
                  queue.add(node.right);
            }

            while (!queue.isEmpty()) {
                  TreeNode poll = queue.poll();
                  allNames.add(poll.name);
                  if (poll.left != null) {
                        queue.add(poll.left);
                  }
                  if (poll.right != null) {
                        queue.add(poll.right);
                  }
            }
            setQuantityMap.put(allNames, 0);
            if (node.left != null) {
                  fillSetQuantityMap(node.left, setQuantityMap);
            }
            if (node.right != null) {
                  fillSetQuantityMap(node.right, setQuantityMap);
            }
      }
}
