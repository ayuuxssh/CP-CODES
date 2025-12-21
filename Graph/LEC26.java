package ayush.Graph;

import java.util.*;

public class LEC26 {
    public  static String findOrder(String[] words) {
        int n = words.length;
        Map<Character, Set<Character>> adj = new HashMap<>();
        // Map to store indegree: Key -> count
        Map<Character, Integer> indegree = new HashMap<>();

        // 1. Initialize maps for every unique character found
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.putIfAbsent(c, 0);
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        // 2. Build the Graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // Edge Case: Prefix Logic (e.g., "apple" before "app" is invalid)
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    char u = w1.charAt(j);
                    char v = w2.charAt(j);

                    // Add edge u -> v only if it doesn't exist
                    if (!adj.get(u).contains(v)) {
                        adj.get(u).add(v);
                        indegree.put(v, indegree.get(v) + 1);
                    }
                    break; // Stop after first difference
                }
            }
        }

        // 3. Kahn's Algorithm (BFS)
        Queue<Character> q = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!q.isEmpty()) {
            char u = q.poll();
            result.append(u);

            if (adj.containsKey(u)) {
                for (char v : adj.get(u)) {
                    indegree.put(v, indegree.get(v) - 1);
                    if (indegree.get(v) == 0) {
                        q.offer(v);
                    }
                }
            }
        }

        // 4. Cycle Detection
        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }

        public static void main(String[] args) {
           String []words = {"ab", "cd", "ef", "ad"};
            System.out.println(findOrder(words));
    }
}
