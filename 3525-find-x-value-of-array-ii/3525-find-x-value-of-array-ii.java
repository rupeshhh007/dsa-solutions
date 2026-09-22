import java.util.*;

class Solution {
    static class Node {
        int totalProd;
        int[] counts;

        Node(int k) {
            this.totalProd = 1;
            this.counts = new int[k];
        }
    }

    private int K;
    private Node[] tree;
    private int n;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.K = k;
        this.n = nums.length;
        this.tree = new Node[4 * n];
        
        build(nums, 1, 0, n - 1);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, idx, val);

            Node resNode = query(1, 0, n - 1, start, n - 1);
            result[i] = resNode.counts[x];
        }

        return result;
    }

    private void build(int[] nums, int node, int start, int end) {
        tree[node] = new Node(K);
        if (start == end) {
            int val = nums[start] % K;
            tree[node].totalProd = val;
            tree[node].counts[val] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        build(nums, 2 * node, start, mid);
        build(nums, 2 * node + 1, mid + 1, end);
        merge(tree[node], tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            int rem = val % K;
            Arrays.fill(tree[node].counts, 0);
            tree[node].totalProd = rem;
            tree[node].counts[rem] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        merge(tree[node], tree[2 * node], tree[2 * node + 1]);
    }

    private Node query(int node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        if (r <= mid) {
            return query(2 * node, start, mid, l, r);
        }
        if (l > mid) {
            return query(2 * node + 1, mid + 1, end, l, r);
        }
        Node leftRes = query(2 * node, start, mid, l, mid);
        Node rightRes = query(2 * node + 1, mid + 1, end, mid + 1, r);
        Node res = new Node(K);
        merge(res, leftRes, rightRes);
        return res;
    }

    private void merge(Node res, Node left, Node right) {
        res.totalProd = (left.totalProd * right.totalProd) % K;
        for (int i = 0; i < K; i++) {
            res.counts[i] = left.counts[i];
        }
        for (int i = 0; i < K; i++) {
            if (right.counts[i] > 0) {
                int nextRem = (left.totalProd * i) % K;
                res.counts[nextRem] += right.counts[i];
            }
        }
    }
}
