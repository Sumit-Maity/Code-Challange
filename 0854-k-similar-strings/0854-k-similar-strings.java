import java.util.*;

class Solution {
    public int kSimilarity(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s1);
        visited.add(s1);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String curr = queue.poll();

                if (curr.equals(s2)) {
                    return level;
                }
                int i = 0;
                while (curr.charAt(i) == s2.charAt(i)) {
                    i++;
                }

                char[] arr = curr.toCharArray();
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == s2.charAt(i) && arr[j] != s2.charAt(j)) {

                        swap(arr, i, j);
                        String next = new String(arr);

                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }

                        swap(arr, i, j); 
                    }
                }
            }
            level++;
        }
        return -1;
    }
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}