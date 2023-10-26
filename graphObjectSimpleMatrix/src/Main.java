import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
      public static void main(String[] args) {
            Node node0 = new Node(0, new int[]{1,3,4});
            Node node1 = new Node(1, new int[]{0,2,3,4});
            Node node2 = new Node(2, new int[]{1,3,4});
            Node node3 = new Node(3, new int[]{0,1,2});
            Node node4 = new Node(4, new int[]{0,1,2});

            Graph graph = new Graph(node0,node1,node2,node3,node4);
            System.out.println("Graph as matrix");
            System.out.println(graph.toString());

      }

      static class Node {
            int id;
            int[] neighborsId;

            public Node(int id, int[] neighbors) {
                  this.id = id;
                  this.neighborsId = neighbors;
            }
      }

      static class Graph {
            private boolean adjMatrix[][];
            private int numVertices;

            public Graph(Node... nodes) {
                  this.numVertices = nodes.length;
                  this.adjMatrix = new boolean[nodes.length][nodes.length];

                  for (Node node : nodes) {
                        for (int neighbour : node.neighborsId) {
                              adjMatrix[node.id][neighbour] = true;
                        }
                  }
            }

            @Override
            public String toString() {
                  StringBuilder s = new StringBuilder();
                  for (int i = 0; i < numVertices; i++) {
                        s.append(i + ": ");
                        for (boolean j : adjMatrix[i]) {
                              s.append((j?1:0) + " ");
                        }
                        s.append("\n");
                  }
                  return s.toString();
            }
      }
}
