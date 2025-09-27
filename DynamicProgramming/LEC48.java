package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC48 {
   public static int matrixMultiplication(int []arr)
   {
       int n = arr.length;
       int [][]dp = new int[n+1][n+1];
       for(int[]row:dp)
       Arrays.fill(row,-1);
       return matrixMultiplication(arr,1,n-1,dp);
   }
   private static int matrixMultiplication(int[]arr,int i,int j,int[][]dp)
   {
       if(i==j)
           return 0;
       if(dp[i][j]!=-1)
           return dp[i][j];
       int mini = Integer.MAX_VALUE;
       for(int k=i;k<=j-1;k++)
       {
           int steps = arr[i-1]*arr[k]*arr[j]+matrixMultiplication(arr,i,k,dp)+matrixMultiplication(arr,k+1,j,dp);
           mini = Math.min(mini,steps);
           dp[i][j]=mini;
       }
       return mini;
   }
   //Tabulation
   public static int matrixMultiplication1(int []arr)
   {
       int n = arr.length;
       int [][]dp = new int[n+1][n+1];
for(int i=1;i<n;i++)
    dp[i][i]=0;
  for(int i=n-1;i>0;i--) {
      for (int j = i+1; j < n; j++) {
          int mini = Integer.MAX_VALUE;
          for (int k = i; k <= j - 1; k++) {
              int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
              mini = Math.min(mini, steps);
              dp[i][j] = mini;
          }
      }
  }
        return dp[1][n-1];
    }
    public static void main(String[] args) {
       int []arr  = {2, 1, 3, 4};
        System.out.println(matrixMultiplication1(arr));
    }
}
