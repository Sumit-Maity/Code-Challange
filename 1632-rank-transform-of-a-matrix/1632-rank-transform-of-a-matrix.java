import java.util.*;

class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int a, int b) {
            parent[find(a)] = find(b);
        }
    }

    public int[][] matrixRankTransform(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(matrix[i][j], k -> new ArrayList<>())
                        .add(new int[]{i, j});
            }
        }

        int[] rowRank = new int[m];
        int[] colRank = new int[n];
        int[][] ans = new int[m][n];

        for (int value : map.keySet()) {

            DSU dsu = new DSU(m + n);
            for (int[] cell : map.get(value)) {
                dsu.union(cell[0], cell[1] + m);
            }

            Map<Integer, List<int[]>> groups = new HashMap<>();

            for (int[] cell : map.get(value)) {
                int root = dsu.find(cell[0]);
                groups.computeIfAbsent(root, k -> new ArrayList<>()).add(cell);
            }

            Map<Integer, Integer> groupRank = new HashMap<>();
            for (int root : groups.keySet()) {
                int rank = 0;

                for (int[] cell : groups.get(root)) {
                    rank = Math.max(rank,
                            Math.max(rowRank[cell[0]], colRank[cell[1]]));
                }
                groupRank.put(root, rank + 1);
            }
            for (int root : groups.keySet()) {
                int rank = groupRank.get(root);

                for (int[] cell : groups.get(root)) {
                    ans[cell[0]][cell[1]] = rank;
                    rowRank[cell[0]] = rank;
                    colRank[cell[1]] = rank;
                }
            }
        }
        return ans;
    }
}