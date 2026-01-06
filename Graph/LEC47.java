package ayush.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Krushkal Algorithm


public class LEC47 extends DisjointSet {
    LEC47(int n) {
        super(n);
    }

    public  static int spanningTree(int V, int[][] edges) {
        Arrays.sort(edges,(a, b)->(a[2]-b[2]));
        int n =edges.length;
        LEC47 ds = new LEC47(V);
        int sum =0;
        for(int i=0;i<n;i++)
        {
            int x = edges[i][0];
            int y =edges[i][1];
            int wt = edges[i][2];
            if(ds.UltParent(x)!=ds.UltParent(y))
            {
                sum+=wt;
                ds.unionBySize(x,y);
            }
        }
        return sum;

    }

    public static void main(String[] args) {
      int  V = 3, E = 3;
        int [][] Edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        System.out.println(spanningTree(V,Edges));
    }
}
