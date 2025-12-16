package ayush.Graph;
//Number of distinct island
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LEC16 {
   public static int countDistinctIslands(int[][] grid)
   {
       int n = grid.length;
       int m = grid[0].length;
       boolean [][]vis = new boolean[n][m];
       HashSet<ArrayList<String>> st = new HashSet<>();
       for(int i=0;i<n;i++)
       {
           for(int j=0;j<m;j++)
           {
               if(!vis[i][j] && grid[i][j]==1)
               {
                   ArrayList<String> list = new ArrayList<>();
                   dfs(grid,vis,i,j,list,i,j);
                   st.add(list);
               }
           }
       }
      return st.size();
   }
   private static void dfs(int [][]grid,boolean [][]vis,int row,int col ,ArrayList<String>list,int row0,int col0)
   {
       int n = grid.length;
       int m = grid[0].length;
       vis[row][col]= true;
       list.add(toString(row-row0,col-col0));
       for(int d=-1;d<=1;d++)
       {
           for(int e=-1;e<=1;e++)
           {
               if(d!=0 && e!=0)
                   continue;
               int nr = row+d;
               int nc = col+e;
               if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid[nr][nc]==1)
               {
                   dfs(grid,vis,nr,nc,list,row0,col0);
               }
           }
       }
   }
   private  static String toString(int row ,int col)
   {
       return Integer.toString(row) + " " + Integer.toString(col);
   }
    public static void main(String[] args) {
       int [][] grid = {{1, 1, 0, 0, 0},
               {1, 1, 0, 0, 0},
               {0, 0, 0, 1, 1},
               {0, 0, 0, 1, 1}};
        System.out.println(countDistinctIslands(grid));
    }
}
