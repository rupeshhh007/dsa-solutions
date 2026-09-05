class Solution {
    public int maximumMinutes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // fireTime[r][c] = earliest time fire reaches (r,c)
        // -1 = fire never reaches this cell
        int[][] fireTime = new int[m][n];

        for (int r = 0; r < m; r++) {
            Arrays.fill(fireTime[r], -1);
        }

        Queue<int[]> q = new LinkedList<>();

        // All fire cells start at time 0
        int time = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    q.offer(new int[] { r, c });
                    fireTime[r][c] = 0;
                }
            }
        }

        // Multi-source BFS for fire
        while (!q.isEmpty()) {

            time++;

            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {

                int[] cell = q.poll();

                int currRow = cell[0];
                int currCol = cell[1];

                // DOWN
                if (currRow != m - 1
                        && grid[currRow + 1][currCol] == 0
                        && fireTime[currRow + 1][currCol] == -1) {

                    fireTime[currRow + 1][currCol] = time;
                    q.offer(new int[] { currRow + 1, currCol });
                }

                // RIGHT
                if (currCol != n - 1
                        && grid[currRow][currCol + 1] == 0
                        && fireTime[currRow][currCol + 1] == -1) {

                    fireTime[currRow][currCol + 1] = time;
                    q.offer(new int[] { currRow, currCol + 1 });
                }

                // UP
                if (currRow != 0
                        && grid[currRow - 1][currCol] == 0
                        && fireTime[currRow - 1][currCol] == -1) {

                    fireTime[currRow - 1][currCol] = time;
                    q.offer(new int[] { currRow - 1, currCol });
                }

                // LEFT
                if (currCol != 0
                        && grid[currRow][currCol - 1] == 0
                        && fireTime[currRow][currCol - 1] == -1) {

                    fireTime[currRow][currCol - 1] = time;
                    q.offer(new int[] { currRow, currCol - 1 });
                }
            }
        }

        int low = 0;
        int high = 1_000_000_000;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEscape(grid, fireTime, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;

    }

    private boolean canEscape(int[][] grid, int[][] fireTime, int wait) {

        int m = grid.length;
        int n = grid[0].length;
         // Check whether fire reaches start before/during our waiting
    if (fireTime[0][0] != -1 && wait >= fireTime[0][0]) {
        return false;
    }

        boolean[][] visited = new boolean[m][n];
        

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        visited[0][0] = true;

        int time = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];

                int[][] directions = {
                        { 1, 0 },
                        { -1, 0 },
                        { 0, 1 },
                        { 0, -1 }
                };

                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // outside grid
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    // wall
                    if (grid[nr][nc] == 2) {
                        continue;
                    }

                    // already visited
                    if (visited[nr][nc]) {
                        continue;
                    }

                    int arrivalTime = wait + time + 1;

                    // safehouse
                    if (nr == m - 1 && nc == n - 1) {
                        if (fireTime[nr][nc] == -1 || arrivalTime <= fireTime[nr][nc]) {
                            return true;
                        }
                    }

                    // normal cell
                    else {
                        if (fireTime[nr][nc] == -1 || arrivalTime < fireTime[nr][nc]) {
                            visited[nr][nc] = true;
                            q.offer(new int[] { nr, nc });
                        }
                    }
                }

            }

            time++;
        }

        return false;
    }
}