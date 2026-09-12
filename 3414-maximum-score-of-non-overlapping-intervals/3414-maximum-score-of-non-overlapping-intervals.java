import java.util.*;

class Solution {
    private static class Interval {
        int left, right, weight, originalIndex;
        Interval(int left, int right, int weight, int originalIndex) {
            this.left = left;
            this.right = right;
            this.weight = weight;
            this.originalIndex = originalIndex;
        }
    }

    private static class State {
        long weight;
        List<Integer> indices;
        State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(intervals.get(i).get(0), intervals.get(i).get(1), intervals.get(i).get(2), i);
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a.left, b.left));

        int[] nextIdx = new int[n];
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n, ans = n;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (mid < n && arr[mid].left > arr[i].right) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            nextIdx[i] = ans;
        }

        State[][] dp = new State[n + 1][5];
        for (int j = 0; j <= 4; j++) {
            dp[n][j] = new State(0, new ArrayList<>());
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0; k <= 4; k++) {
                State best = dp[i + 1][k];
                long bestW = best.weight;
                List<Integer> bestList = best.indices;

                if (k > 0) {
                    State takeNext = dp[nextIdx[i]][k - 1];
                    long takeW = arr[i].weight + takeNext.weight;
                    List<Integer> takeList = new ArrayList<>();
                    takeList.add(arr[i].originalIndex);
                    takeList.addAll(takeNext.indices);
                    Collections.sort(takeList);

                    if (takeW > bestW) {
                        bestW = takeW;
                        bestList = takeList;
                    } else if (takeW == bestW) {
                        if (compareLists(takeList, bestList) < 0) {
                            bestList = takeList;
                        }
                    }
                }
                dp[i][k] = new State(bestW, bestList);
            }
        }

        List<Integer> resList = dp[0][4].indices;
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    private int compareLists(List<Integer> a, List<Integer> b) {
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            int cmp = Integer.compare(a.get(i), b.get(i));
            if (cmp != 0) return cmp;
        }
        return Integer.compare(a.size(), b.size());
    }
}
