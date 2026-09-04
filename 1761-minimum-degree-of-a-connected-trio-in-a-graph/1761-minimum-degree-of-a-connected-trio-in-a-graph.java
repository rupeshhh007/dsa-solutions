class Solution {
    public int minTrioDegree(int n, int[][] edges) {

        boolean[][] adj = new boolean[n + 1][n + 1];
        int[] degree = new int[n + 1];

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u][v] = true;
            adj[v][u] = true;

            degree[u]++;
            degree[v]++;
        }

        int ans = Integer.MAX_VALUE;

   
        for (int a = 1; a <= n; a++) {

            for (int b = a + 1; b <= n; b++) {

               
                if (!adj[a][b]) continue;

                for (int c = b + 1; c <= n; c++) {

           
                    if (adj[a][c] && adj[b][c]) {

                        int trioDegree =
                            degree[a] + degree[b] + degree[c] - 6;

                        ans = Math.min(ans, trioDegree);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}