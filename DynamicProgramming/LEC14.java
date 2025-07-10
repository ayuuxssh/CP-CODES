package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC14 {
    //Memoization
    public static boolean subset(int [] arr,int sum)
    {
      int n = arr.length;
      int [][]dp = new int[200+1][(int)Math.pow(10,4)+1];
      for(int[]row:dp)
          Arrays.fill(row,-1);
      return subset(arr,sum,n-1,dp);
    }
    private static boolean  subset(int []arr,int sum ,int i,int [][]dp)
    {
        if(sum==0)
            return true;
        if(i==0)
        {
            return arr[0]==sum;
        }

        if(dp[i][sum]!=-1)
            return dp[i][sum]==0?false:true;
        boolean  pick = false;
        if(sum>=arr[i])
            pick = subset(arr,sum-arr[i],i-1,dp);
        boolean nonpick = subset(arr,sum,i-1,dp);
dp[i][sum]= pick||nonpick?1:0;
        return pick||nonpick;
    }
    //Tabulation
    public static boolean subset1(int [] arr,int sum) {
        int n = arr.length;
        boolean [][] dp = new boolean[n][sum+1];
        for (boolean[] row : dp)
            Arrays.fill(row, false);
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if(arr[0]<=sum) {
            dp[0][arr[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean pick = false;
                if (j >= arr[i])
                    pick = dp[i-1][j-arr[i]];
                boolean nonpick =dp[i-1][j];
                dp[i][j] = pick || nonpick ;
            }
        }
        return dp[n-1][sum];
    }
    //Space optimisation
    public static boolean subset2(int [] arr,int sum) {
        int n = arr.length;
        boolean [] prev = new boolean[sum+1];
            Arrays.fill(prev, false);
prev[0]= true;
if(arr[0]<=sum)
    prev[arr[0]]=true;
        for (int i = 1; i < n; i++) {
            boolean [] temp = new boolean[sum+1];
            temp[0]=true;
            for (int j = 1; j <= sum; j++) {
                boolean pick = false;
                if (j >= arr[i])
                    pick = prev[j-arr[i]];
                boolean nonpick =prev[j];
                temp[j] = pick || nonpick ;
            }
            prev = temp;
        }
        return prev[sum];
    }
    public static void main(String[] args) {
       int [] arr = {3, 34, 4, 12, 5, 2};
       int sum = 9;
        System.out.println(subset2(arr,sum));

    }
}
