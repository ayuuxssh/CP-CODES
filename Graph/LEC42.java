package ayush.Graph;

import java.util.Arrays;
//Floyd Warshall Algorithm for finding the shortest the path
public class LEC42 {
    public static void floydWarshall(int[][] dist) {
        int n = dist.length;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                    if (dist[j][k] >= 1e8 - 1e3)
                        dist[j][k] = (int)1e8;
                }
            }
        }
        for(int [] it:dist)
        {
            System.out.println(Arrays.toString(it));
        }
    }
    public static void main(String[] args) {
       int [][] dist = {{0, 4, (int)1e8, 5, (int)1e8}, {(int)1e8, 0, 1, (int)1e8, 6},{2, (int)1e8, 0, 3, (int)1e8}, {(int)1e8, (int)1e8, 1, 0, 2}, {1, (int)1e8, (int)1e8, 4, 0}};
        floydWarshall(dist);
    }
}
