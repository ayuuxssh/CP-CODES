package ayush.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Course Schedule I and II
public class LEC24 {
    public  static boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];
        Arrays.fill(indegree, 0);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        Queue<Integer> q = new LinkedList<>();
        for (int[] it : prerequisites) {
            int u = it[0];
            int v = it[1];
            adj.get(v).add(u);
        }
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            count++;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }

        }
        if (count == V)
            return true;
        else {
            return false;
        }
    }
    public static void main(String[] args) {
       int numCourses = 2;
        int [][] prerequisites = {{1,0}};
        System.out.println(canFinish(numCourses,prerequisites));
    }
}
