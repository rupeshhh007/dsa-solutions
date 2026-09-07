class Pair {
    String element;
    double val;

    public Pair(String e, double v) {
        this.element = e;
        this.val = v;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, List<Pair>> map = new HashMap<>();

        for (int i = 0; i < values.length; i++) {

            String numer = equations.get(i).get(0);
            String denom = equations.get(i).get(1);
            double div = values[i];

            map.putIfAbsent(numer, new ArrayList<>());
            map.putIfAbsent(denom, new ArrayList<>());

            map.get(numer).add(new Pair(denom, div));
            map.get(denom).add(new Pair(numer, 1.0 / div));

        }

        int n = queries.size();
        double[] ans = new double[n];

        for (int i = 0; i < n; i++) {

            List<String> query = queries.get(i);

            String numerator = query.get(0);
            String denominator = query.get(1);

            if (!map.containsKey(numerator) || !map.containsKey(denominator))
                ans[i] = -1.0;

            else if (numerator.equals(denominator)) {
                ans[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(numerator, denominator, visited, map, 1.0);
            }

        }
        return ans;
    }

    private double dfs(String numerator, String denominator, Set<String> visited, HashMap<String, List<Pair>> map,
            double currentAns) {
        if (visited.contains(numerator)) {
            return -1.0;
        }

        visited.add(numerator);

        if (numerator.equals(denominator)) {
            return currentAns;
        }

        for(Pair pair : map.get(numerator)){
           double result =  dfs (pair.element, denominator,visited,map,currentAns*pair.val);
             if (result != -1.0) {
        return result;
    }
        }
        return -1.0;

    }
}
