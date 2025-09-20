import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;

        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                provinces++;
                bfs(i, isConnected, visit);
                // Alternatively, you can use DFS:
                // dfs(i, isConnected, visit);
            }
        }
        return provinces;
    }

    private void bfs(int startNode, int[][] isConnected, boolean[] visit) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visit[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[node][i] == 1 && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    private void dfs(int node, int[][] isConnected, boolean[] visit) {
        visit[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces solution = new NumberOfProvinces();
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int result = solution.findCircleNum(isConnected);
        System.out.println("Number of Provinces: " + result); // Output: 2
    }

}
