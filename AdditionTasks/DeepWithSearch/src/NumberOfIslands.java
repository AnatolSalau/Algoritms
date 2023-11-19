import java.util.Arrays;

public class NumberOfIslands {
      /**
       Given an m x n 2D binary grid grid which represents
       a map of '1's (land) and '0's (water), return the number of islands.

       An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
       You may assume all four edges of the grid are all surrounded by water.

       Example 1:

       Input: grid = [
       ["1","1","1","1","0"],
       ["1","1","0","1","0"],
       ["1","1","0","0","0"],
       ["0","0","0","0","0"]
       ]
       Output: 1

       Example 2:

       Input: grid = [
       ["1","1","0""0","0""0","0"],
       ["1","1","0""0","0""0","0"],
       ["0","0","0""1","0""0","0"],
       ["0","0","0""0","0""1","1"]
       ]
       Output: 3
       */
      public static void main(String[] args) {
            //testOne();
            testTwo();
      }
      int getQuantityOfIslands(int[][] grid) {
            int quantityIslands = 0;
            int rowsHeight = grid.length;
            int columnsWidth = grid[0].length;

            for (int rowInd = 0; rowInd < rowsHeight; rowInd++) {
                  for (int colInd = 0; colInd < columnsWidth; colInd++) {
                        int curr = grid[rowInd][colInd];

                        if (curr == 1) {
                              quantityIslands ++;
                              markIslandAsVisitedByDFS(grid, rowInd, colInd);
                        }

                  }
            }

            return quantityIslands;
      }

      /*    +[R-1][C-1]    +[R-1][C]    +[R-1][C+1]

            +[R][C-1]        [R][C]     +[R][C+1]

            +[R+1][C-1]    +[R+1][C]    +[R+1][C+1]
       */
      void markIslandAsVisitedByDFS(int[][] grid, int rowInd, int colInd) {
            int rowsHeight = grid.length-1;
            int columnsWidth = grid[0].length-1;

            int R = rowInd;
            int C = colInd;

            grid[R][C] = 9;
            /*[R-1][C-1]*/
            if (R-1 >= 0 && R-1<= rowsHeight
                  && C-1 >= 0 && C-1 <= columnsWidth
                  && grid[R-1][C-1] != 9
                  && grid[R-1][C-1] != 0
            ) {markIslandAsVisitedByDFS(grid,R-1, C-1);}
            /*[R-1][C]*/
            if (R-1 >= 0 && R-1<= rowsHeight
                  && C >= 0 && C <= columnsWidth
                  && grid[R-1][C] != 9
                  && grid[R-1][C] != 0
            ) {markIslandAsVisitedByDFS(grid,R-1, C);}
            /*[R-1][C+1]*/
            if (R-1 >= 0 && R-1<= rowsHeight
                  && C+1 >= 0 && C+1 <= columnsWidth
                  && grid[R-1][C+1] != 9
                  && grid[R-1][C+1] != 0
            ) {markIslandAsVisitedByDFS(grid,R-1, C+1);}
            /*[R][C-1]*/
            if (R >= 0 && R<= rowsHeight
                  && C-1 >= 0 && C-1 <= columnsWidth
                  && grid[R][C-1] != 9
                  && grid[R][C-1] != 0
            ) {markIslandAsVisitedByDFS(grid,R, C-1);}
            /*[R][C+1]*/
            if (R >= 0 && R<= rowsHeight
                  && C+1 >= 0 && C+1 <= columnsWidth
                  && grid[R][C+1] != 9
                  && grid[R][C+1] != 0
            ) {markIslandAsVisitedByDFS(grid,R, C+1);}
            /*[R+1][C-1]*/
            if (R+1 >= 0 && R+1<= rowsHeight
                  && C-1 >= 0 && C-1 <= columnsWidth
                  && grid[R+1][C-1] != 9
                  && grid[R+1][C-1] != 0
            ) {markIslandAsVisitedByDFS(grid,R+1, C-1);}
            /*[R+1][C]*/
            if (R+1 >= 0 && R+1<= rowsHeight
                  && C >= 0 && C <= columnsWidth
                  && grid[R+1][C] != 9
                  && grid[R+1][C] != 0
            ) {markIslandAsVisitedByDFS(grid,R+1, C);}
            /*[R+1][C+1]*/
            if (R+1 >= 0 && R+1<= rowsHeight
                  && C+1 >= 0 && C+1 <= columnsWidth
                  && grid[R+1][C+1] != 9
                  && grid[R+1][C+1] != 0
            ) {markIslandAsVisitedByDFS(grid,R+1, C+1);}
      }
      void printGrid(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                  System.out.println(Arrays.toString(grid[i]));
            }
      }

      static void testOne() {
            int[][] grid = {
                  {1, 1, 1, 1, 0},
                  {1, 1, 0, 1, 0},
                  {1, 1, 0, 0, 0},
                  {0, 0, 0, 0, 0}
            };
            NumberOfIslands numberOfIslands = new NumberOfIslands();
            numberOfIslands.printGrid(grid);

            int quantityOfIslands = numberOfIslands.getQuantityOfIslands(grid);
            System.out.println("Quantity : " + quantityOfIslands);

      }

      static void testTwo() {
            int[][] grid = {
                  {1,1,0,0,0,0,0},
                  {1,1,0,0,0,0,0},
                  {0,0,0,1,0,0,0},
                  {0,0,0,0,0,1,1}
            };
            NumberOfIslands numberOfIslands = new NumberOfIslands();
            numberOfIslands.printGrid(grid);

            int quantityOfIslands = numberOfIslands.getQuantityOfIslands(grid);
            System.out.println("Quantity : " + quantityOfIslands);

      }
}
