import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        bfs(image, sr, sc, image[sr][sc], color);
        // Alternatively, you can use DFS:
        // dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void bfs(int[][] image, int i, int j, int oldColor, int color){
        image[i][j] = color;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int newI = curr[0] + dir[0];
                int newJ = curr[1] + dir[1];
                if(isValid(image, newI, newJ, oldColor)){
                    image[newI][newJ] = color;
                    q.offer(new int[] {newI, newJ});
                }
            }
        }
    }

    private void dfs(int[][] image, int i, int j, int oldColor, int color){
        if(!isValid(image, i, j, oldColor)) return;
        image[i][j] = color;
        dfs(image, i+1, j, oldColor,color);
        dfs(image, i-1, j, oldColor, color);
        dfs(image, i, j-1, oldColor, color);
        dfs(image, i, j+1, oldColor, color);           
    }

    private boolean isValid(int[][] image, int i, int j, int oC){
        int m = image.length;
        int n = image[0].length;
        return i >= 0 && i<m && j>=0 && j<n && image[i][j] == oC;
    }

    public static void main(String[] args) {
        FloodFill solution = new FloodFill();
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;
        int[][] result = solution.floodFill(image, sr, sc, color);
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
    
}
