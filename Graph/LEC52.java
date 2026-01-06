package ayush.Graph;

import java.util.HashSet;
//Making Larger Island
public class LEC52  extends DisjointSet{
    LEC52(int n) {
        super(n);
    }

    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        LEC52 ds= new LEC52(n*n);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {

                    for(int d=-1;d<=1;d++)
                    {
                        for(int e =-1;e<=1;e++)
                        {
                            if(d!=0 && e!=0)
                                continue;
                            int nr = i+d;
                            int nc = j+e;
                            if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==1)
                            {
                                ds.unionBySize(n*i+j,n*nr+nc);
                            }
                        }
                    }
                }

            }
        }
        int maxi =0 ;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    HashSet<Integer> st = new HashSet<>();
                    int count =1;

                    for(int d=-1;d<=1;d++)
                    {
                        for(int e =-1;e<=1;e++)
                        {
                            if(d!=0 && e!=0)
                                continue;
                            int nr = i+d;
                            int nc = j+e;
                            if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==1)
                            {
                                int par = ds.UltParent(nr*n+nc);
                                st.add(par);
                            }

                        }
                    }

                    for(Integer it:st)
                    {
                        count+=ds.Size.get(it);
                    }
                    maxi = Math.max(maxi,count);
                }
            }
        }
        if(maxi==0)
            return n*n;

        return maxi;
    }

    public static void main(String[] args) {
     int [][]   grid = {{1,0},{0,1}};
        System.out.println(largestIsland(grid));
    }

}


