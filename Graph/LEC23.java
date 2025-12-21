package ayush.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//Cycle Detection using BFS(Kahn's Algorithm)
public class LEC23 {
    public  static boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];
        Arrays.fill(indegree, 0);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        Queue<Integer> q = new LinkedList<>();
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            adj.get(u).add(v);
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
        int count=0;
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
if(count ==V)
    return false;
return true;
    }
    public static void main(String[] args) {
        int  V = 4;
        int [][]edges = {{0, 1}, {1, 2}, {2, 0}, {2, 3}};
        System.out.println(isCyclic(V,edges));
    }
}
