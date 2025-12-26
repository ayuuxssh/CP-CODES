package ayush.Graph;

import java.lang.reflect.Array;
import java.util.Arrays;
//BellmanFord Algorithm for finding the shortest path if graph contains negative cycle or  negative edges
public class LEC41 {
    public static int [] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;
        for (int i = 0; i < V; i++) {
            for (int[] it : edges) {
                int u = it[0];
                int v = it[1];
                int w = it[2];
                if (dist[u] != (int) 1e8 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        //For negative cycle
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int w = it[2];
            if (dist[u] != (int) 1e8 && dist[u] + w < dist[v]) {
                int [] arr= new int[1];
                arr[0]=-1;
                return arr;
            }
        }
            return dist;

    }
    public static void main(String[] args) {
       int V = 4;
       int [][]edges = {{0, 1, 4}, {1, 2, -6},{2, 3, 5}, {3, 1, -2}};
       int src = 0;
        System.out.println(Arrays.toString(bellmanFord(V,edges,src)));
    }
}
