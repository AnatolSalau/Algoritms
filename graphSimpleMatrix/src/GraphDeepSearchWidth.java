import java.util.ArrayList;
import java.util.Arrays;

public class GraphDeepSearchWidth {
      private final boolean[][] graphMatrix;
      private final int numVertices;

      public GraphDeepSearchWidth(int numVertices) {
            this.numVertices = numVertices;
            graphMatrix = new boolean[numVertices][numVertices];
      }

      public void addEdge(int i, int j) {
            graphMatrix[i][j] = true;
            graphMatrix[j][i] = true;
      }

      public void removeEdge(int i, int j) {
            graphMatrix[i][j] = false;
            graphMatrix[j][i] = false;
      }

      public boolean isEdge(int i, int j) {
            return graphMatrix[i][j];
      }

      public void searchInWidth(int numberVertexStart, int numberVertexFound) {
            QueueImpl<Integer> queue = new QueueImpl<>();
            ArrayList<Integer> visited = new ArrayList<>(); //visited vertexes

            queue.add(numberVertexStart); //add root in queue

            while (!queue.isEmpty()) {
                  Integer currentVertex = queue.remove();
                  visited.add(currentVertex);
                  if(currentVertex == numberVertexFound) { //search element
                        System.out.println("Path : " + visited); // print path
                        return;
                  }

                  boolean[] currentVertexMatrix = graphMatrix[currentVertex]; //all link with other vertexes
                  for (int i = 0; i<currentVertexMatrix.length; i++) {
                        if(currentVertexMatrix[i]) { //if links is true
                              if (!visited.contains(i)) { //if link isn't in visited -> add to queue
                                    queue.add(i);
                              }
                        }
                  }
            }
            System.out.println("Path : " + visited); // print path
      }
      @Override
      public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < numVertices; i++) {
                  s.append(i + ": ");
                  for (boolean j : graphMatrix[i]) {
                        s.append((j?1:0) + " ");
                  }
                  s.append("\n");
            }
            return s.toString();
      }

      public static void main(String[] args) {
            GraphDeepSearchWidth g = new GraphDeepSearchWidth(9);
            g.addEdge(0,1);
            g.addEdge(0,3);

            g.addEdge(1,0);

            g.addEdge(1,2);
            g.addEdge(1,4);

            g.addEdge(2,1);
            g.addEdge(2,5);

            g.addEdge(3,0);
            g.addEdge(3,6);

            g.addEdge(4,1);
            g.addEdge(4,7);

            g.addEdge(5,2);
            g.addEdge(5,8);

            g.addEdge(6,3);
            g.addEdge(6,7);

            g.addEdge(7,4);
            g.addEdge(7,6);
            g.addEdge(7,8);

            g.addEdge(8,5);
            g.addEdge(8,7);

            System.out.println(g.toString());
            g.searchInWidth(1,8);
      }
}
