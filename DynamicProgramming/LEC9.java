package ayush.DynamicProgramming;
import java.util.*;
public class LEC9 {
    //Memoization
    public static int uniquepathII(int[][]obstaclegrid)
    {
        int m = obstaclegrid.length;
        int n = obstaclegrid[0].length;
        int [][]dp = new int[m][n];
        for(int []row:dp)
            Arrays.fill(row,-1);
        return uniquepath(m-1,n-1,obstaclegrid,dp);
    }
    private static int uniquepath(int m ,int n ,int [][]obstaclegrid,int [][]dp)
    {
        if(m>=0 && n>=0 && obstaclegrid[m][n]==1)
        {
            dp[m][n]=0;
            return dp[m][n];
        }
        if(m==0 && n==0) {
            dp[m][n] = 1;
            return dp[m][n];
        }
        if(m<0 || n<0)
            return 0;
        if(dp[m][n]!=-1)
            return dp[m][n];
        int left = uniquepath(m-1,n,obstaclegrid,dp);
        int right = uniquepath(m,n-1,obstaclegrid,dp);
        dp[m][n] = left +right;
        return dp[m][n];
    }
    //Tabulation
    public static int uniquepathII1(int[][]obstaclegrid)
    {
        int m = obstaclegrid.length;
        int n = obstaclegrid[0].length;
        int [][]dp = new int[m][n];
        for(int []row:dp)
            Arrays.fill(row,-1);
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i>=0 && j>=0 && obstaclegrid[i][j]==1)
                {
                    dp[i][j]=0;
                }
                else if(i==0 && j==0)
                {
                    dp[i][j] =1;
                }
                else
                {
                    int left =0;int right=0;
                    if(i>0)
                    {
                        left = dp[i-1][j];
                    }
                    if(j>0)
                    {
                        right = dp[i][j-1];
                    }
                    dp[i][j]= left +right;
                }
            }
        }

        return dp[m-1][n-1];
    }
    //SPACE OPTIMISATION

    public static int uniquepathII2(int[][]obstacleGrid)
    {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int []dp = new int [n];
            Arrays.fill(dp,0);
        for(int i=0;i<m;i++)
        {
            int [] temp = new int[n];
            Arrays.fill(temp,0);
            for(int j=0;j<n;j++)
            {
                if(i>=0 && j>=0 && obstacleGrid[i][j]==1)
                {
                    temp[j]=0;
                }
                else if(i==0 && j==0)
                {
                    temp[j] =1;
                }
                else
                {
                    int left =0;int right=0;
                    if(i>0)
                    {
                        left = dp[j];
                    }
                    if(j>0)
                    {
                        right = temp[j-1];
                    }
                    temp[j]= left +right;
                }
            }
            dp= temp;
        }

        return dp[n-1];
    }
    public static void main(String[] args) {
int [][]grid ={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquepathII2(grid));
    }
}
