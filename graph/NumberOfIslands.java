import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int cnt = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    // Alternatively, you can use DFS:
                    // dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void bfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: directions){
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(isValid(grid, x, y)){
                    q.offer(new int[] {x,y});
                    grid[x][y] = '0';
                }
            }
        }
    }

    private void dfs(char[][] grid, int i, int j) {
        if(!isValid(grid, i, j)) return;
        grid[i][j] = '0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

    private boolean isValid(char[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        return i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1';
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int result = solution.numIslands(grid);
        System.out.println("Number of Islands: " + result); // Output: 3
    }
}