import java.util.LinkedList;
import java.util.Queue;


// DFS doable but not optimal
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: collect initial rotten oranges & count fresh
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0; // no fresh orange initially

        // Directions: up, down, left, right
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int minutes = -1;

        // Step 2: BFS
        while (!q.isEmpty()) {
            int size = q.size();
            minutes++;  // each level = 1 minute
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];

                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; // rot the fresh one
                        fresh--;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }

    

    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        int result = solution.orangesRotting(grid);
        System.out.println("Minutes until all oranges rot: " + result); // Output: 4
    }
}
