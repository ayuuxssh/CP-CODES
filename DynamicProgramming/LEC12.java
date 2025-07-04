package ayush.DynamicProgramming;
import java.util.*;
public class LEC12 {
    //Memoization
    public static int fallingsum(int [][]matrix)
    {
        int ans = Integer.MAX_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dp = new int[m][n];
        for(int []row:dp)
            Arrays.fill(row,-1);
        for(int j=0;j<n;j++)
        {
            int ans1 = minpath(m-1,j,matrix,dp);
            ans = Math.min(ans,ans1);
        }
        return ans;
    }
    private static int minpath(int i,int j,int [][]matrix,int [][]dp)
    {
        if(i<0 ||i>matrix.length-1 ||j<0 || j> matrix.length-1) {
            return (int)Math.pow(10,9);
        }
        if(i==0 ) {
            dp[i][j]= matrix[i][j];
            return dp[i][j];
        }
if(dp[i][j]!=-1)
{
    return dp[i][j];
}
        int left = matrix[i][j]+minpath(i-1,j-1,matrix,dp);
        int right = matrix[i][j]+minpath(i-1,j+1,matrix,dp);
        int down = matrix[i][j]+minpath(i-1,j,matrix,dp);
        dp[i][j]= Math.min(left,Math.min(right,down));
        return dp[i][j];
    }
    public static int fallingsum1(int [][]matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        for(int j=0;j<n;j++)
        {
            dp[0][j]= matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = (int)Math.pow(10,9);
                int right = (int)Math.pow(10,9);
                int down = (int)Math.pow(10,9);

                if( j>0 ) {
                    left =matrix[i][j] +dp[i - 1][j - 1];
                }
                if(j<n-1) {
                    right = matrix[i][j]+ dp[i - 1][j + 1];
                }
                    down =matrix[i][j]+dp[i-1][j];
                dp[i][j] = Math.min(left, Math.min(right, down));
            }
        }
        int max = dp[n-1][0];
        for(int i=1;i<n;i++)
        {
            max= Math.min(max,dp[n-1][i]);
        }
                return max;
    }
    //space optimisation
    public static int fallingsum2(int [][]matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prev= new int[n];
            Arrays.fill(prev, -1);
        for(int j=0;j<n;j++)
        {
            prev[j]= matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            int [] temp = new int [n];
            Arrays.fill(temp,-1);
            for (int j = 0; j < n; j++) {
                int left = (int)Math.pow(10,9);
                int right = (int)Math.pow(10,9);
                int down = (int)Math.pow(10,9);

                if( j>0 ) {
                    left =matrix[i][j] +prev[j - 1];
                }
                if(j<n-1) {
                    right = matrix[i][j]+ prev[j + 1];
                }
                down =matrix[i][j]+prev[j];
                temp[j] = Math.min(left, Math.min(right, down));
            }
            prev =temp;
        }
        int max = prev[0];
        for(int i=1;i<n;i++)
        {
            max= Math.min(max,prev[i]);
        }
        return max;
    }
    public static void main(String[] args) {
int [][]arr ={{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(fallingsum2(arr));
    }
}
