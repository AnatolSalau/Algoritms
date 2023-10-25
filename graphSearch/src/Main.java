import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
      //https://www.baeldung.com/java-graphs
      public static void main(String[] args) {
            /**
             * 10 11 12
             * 15 16 17
             * 20 21 22
             */

      }
      public static class Graph {
            private static final int FIELD_WIDTH = 10;
            private static final int FIELD_HEIGHT = 10;

            GraphNode[][] nodes;
            GraphNode root;

            public Graph(GraphNode[][] nodes, GraphNode root) {
                  this.nodes = nodes;
                  this.root = root;
            }
      }

      public static class GraphNode {
            int value;
            ArrayList<GraphNode> neighbors;

            public GraphNode(int value, GraphNode... neighbors) {
                  this.value = value;
                  neighbors = new ArrayList<>(Arrays.asList(neighbors)).toArray(new GraphNode[0]);

            }
      }
}
