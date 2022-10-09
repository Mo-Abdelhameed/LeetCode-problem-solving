package Hard.Graphs;

public class Making_A_Large_Island {

    static boolean[][] visited;
    static int islandSize = 0;
    public static int dfs(int[][] grid){
        int result = 0;
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]) {
                    islandSize = 0;
                    dfsRec(grid, i, j);
                    result = Math.max(result, islandSize);
                }
            }
        }
        return result;
    }

    public static void dfsRec(int[][] grid, int i, int j){
        visited[i][j] = true;
        islandSize++;
        if(i - 1 >= 0 && grid[i-1][j] == 1 && !visited[i-1][j])
            dfsRec(grid, i-1, j);
        if(i + 1 < grid.length && grid[i+1][j] == 1 && !visited[i+1][j])
            dfsRec(grid, i+1, j);
        if(j - 1 >= 0 && grid[i][j-1] == 1 &&!visited[i][j-1])
            dfsRec(grid, i, j-1);
        if(j + 1 < grid[0].length && grid[i][j+1] == 1 &&!visited[i][j+1])
            dfsRec(grid, i, j+1);
    }


    public static int largestIsland(int[][] grid) {
        int result = dfs(grid);
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    grid[i][j] = 1;
                    result = Math.max(result, dfs(grid));
                    grid[i][j] = 0;
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[][] grid = {{1,0},{0,1}};
        System.out.println(largestIsland(grid));
    }
}
