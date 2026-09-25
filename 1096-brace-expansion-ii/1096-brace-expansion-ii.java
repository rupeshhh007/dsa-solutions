import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(expression);
        Set<String> resultSet = new HashSet<>();

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.indexOf('{') == -1) {
                resultSet.add(current);
                continue;
            }

            int right = current.indexOf('}');
            int left = current.lastIndexOf('{', right);

            String before = current.substring(0, left);
            String after = current.substring(right + 1);
            String[] options = current.substring(left + 1, right).split(",");

            for (String option : options) {
                StringBuilder nextExpression = new StringBuilder();
                nextExpression.append(before).append(option).append(after);
                queue.offer(nextExpression.toString());
            }
        }

        List<String> sortedList = new ArrayList<>(resultSet);
        Collections.sort(sortedList);
        return sortedList;
    }
}
