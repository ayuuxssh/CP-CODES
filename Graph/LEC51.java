package ayush.Graph;

import java.util.ArrayList;
import java.util.List;
//Number of islands using DSU (Online queries)
public class LEC51 extends DisjointSet{
    LEC51(int n) {
        super(n);
    }

    public  static List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        boolean [][]vis = new boolean[rows][cols];
        List<Integer>ans = new ArrayList<>();
        int count =0;
        LEC51 ds = new LEC51(rows*cols);
        for(int []it:operators)
        {
            int row =it[0];
            int col = it[1];

            if(!vis[row][col])
            {
                vis[row][col]=true;
                count++;

                for(int d=-1;d<=1;d++)
                {
                    for(int e=-1;e<=1;e++)
                    {
                        if(d!=0 && e!=0)
                            continue;
                        int nr = row+d;
                        int nc = col+e;

                        if(nr>=0 && nr<rows && nc>=0 && nc<cols && vis[nr][nc]==true )
                        {
                            if(ds.UltParent(cols*row+col)!=ds.UltParent(cols*nr+nc))
                            {
                                count--;
                                ds.unionBySize(cols*row+col,cols*nr+nc);
                            }
                        }
                    }
                }
            }
            ans.add(count);
        }

        return ans;

    }

    public static void main(String[] args) {
        int n = 4;
        int m = 5;
      int   k = 4;
        int [][]A = {{1,1},{0,1},{3,3},{3,4}};
        System.out.println(numOfIslands(n,m,A));
    }
}

