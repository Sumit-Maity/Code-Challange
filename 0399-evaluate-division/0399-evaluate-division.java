import java.util.*;

class Solution {

    static class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(new Pair(v, val));
            graph.get(v).add(new Pair(u, 1.0 / val));
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                ans[i] = -1.0;
            } else if (src.equals(dest)) {
                ans[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(src, dest, graph, visited, 1.0);
            }
        }

        return ans;
    }

    private double dfs(String curr, String dest,
                       Map<String, List<Pair>> graph,
                       Set<String> visited,
                       double product) {

        if (curr.equals(dest))
            return product;

        visited.add(curr);
        for (Pair neighbor : graph.get(curr)) {
            if (!visited.contains(neighbor.node)) {
                double result = dfs(neighbor.node, dest, graph,
                                    visited, product * neighbor.value);

                if (result != -1.0)
                    return result;
            }
        }
        return -1.0;
    }
}