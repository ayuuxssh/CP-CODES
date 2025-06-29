package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC10 {
    //Memoization
    public static int minpath(int [][]grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int [][]dp = new int[m][n];
        for(int[]row:dp)
            Arrays.fill(row,-1);
        return  minpathsum(grid,m-1,n-1,dp);
    }
    private static int minpathsum(int [][]grid,int m ,int n,int[][]dp)
    {
        if(m==0 && n==0)
        {
            dp[m][n]= grid[m][n];
            return dp[m][n];
        }
if(dp[m][n]!=-1)
    return dp[m][n];
        int left =Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(m>0) {
            left = grid[m][n] + minpathsum(grid, m - 1, n,dp);
        }
        if(n>0) {
            right = grid[m][n] + minpathsum(grid, m, n - 1,dp);
        }
        dp[m][n]= Math.min(left,right);
        return dp[m][n];
    }
//Tabulation
public static int minpath1(int [][]grid)
{
    int m = grid.length;
    int n = grid[0].length;
    int [][]dp = new int[m][n];
    for(int[]row:dp)
        Arrays.fill(row,-1);

for(int i=0;i<m;i++) {
    for (int j = 0; j < n; j++) {

        if (i == 0 && j == 0) {
            dp[i][j] = grid[i][j];
        }
else {
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            if (i > 0)
                left = grid[i][j] + dp[i - 1][j];
            if (j > 0) {
                right = grid[i][j] + dp[i][j - 1];
            }


            dp[i][j] = Math.min(left, right);
        }
    }
}
        return dp[m-1][n-1];
    }
    //space optimisation
    public static int minpath2(int [][]grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int []dp = new int[n];
            Arrays.fill(dp,0);

        for(int i=0;i<m;i++) {
            int [] temp = new int[n];
            Arrays.fill(temp,0);
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    temp[j] = grid[i][j];
                }
                else {
                    int left = Integer.MAX_VALUE;
                    int right = Integer.MAX_VALUE;
                    if (i > 0)
                        left = grid[i][j] + dp[j];
                    if (j > 0) {
                        right = grid[i][j] + temp[j - 1];
                    }


                    temp[j] = Math.min(left, right);
                }
            }
            dp= temp;
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int [][]arr ={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minpath2(arr));
    }
}
