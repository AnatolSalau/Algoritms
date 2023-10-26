public class Graph {
      private final boolean[][] adjMatrix;
      private final int numVertices;

      public Graph(int numVertices) {
            this.numVertices = numVertices;
            adjMatrix = new boolean[numVertices][numVertices];
      }

      public void addEdge(int i, int j) {
            adjMatrix[i][j] = true;
            adjMatrix[j][i] = true;
      }


      public void removeEdge(int i, int j) {
            adjMatrix[i][j] = false;
            adjMatrix[j][i] = false;
      }

      public boolean isEdge(int i, int j) {
            return adjMatrix[i][j];
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
      public static void main(String args[])
      {
            Graph g = new Graph(5);

            g.addEdge(0, 4);
            g.addEdge(0, 1);
            g.addEdge(0, 3);

            g.addEdge(1, 0);
            g.addEdge(1, 2);
            g.addEdge(1, 3);
            g.addEdge(1, 4);

            g.addEdge(2, 4);
            g.addEdge(2, 1);
            g.addEdge(2, 3);

            g.addEdge(3, 0);
            g.addEdge(3, 1);
            g.addEdge(3, 2);

            g.addEdge(4, 0);
            g.addEdge(4, 1);
            g.addEdge(4, 2);

            System.out.print(g.toString());
        /* Outputs
            0: 0 1 0 1 1
            1: 1 0 1 1 1
            2: 0 1 0 1 1
            3: 1 1 1 0 0
            4: 1 1 1 0 0
          */
      }
}
