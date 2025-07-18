package ayush.DynamicProgramming;
import java.util.*;
public class LEC19 {
    //Memoization
    public static int  knapsack(int w , int []val ,int []wt)
    {
        int n = wt.length;
        int [][]dp = new int [n][w+1];
        for(int [] row:dp)
            Arrays.fill(row,-1);
        return knapsack(n-1,w,val,wt,dp);
    }
    private static int knapsack(int index, int w, int []val,int []wt,int [][]dp)
    {
        if(index==0)
        {
            if(w>=wt[index])
            {
                return val[index];
            }
            return 0;
        }
        if(dp[index][w]!=-1)
            return dp[index][w];
        int left =Integer.MIN_VALUE;
        if(w>=wt[index])
        {
            left = val[index]+knapsack(index-1,w-wt[index],val,wt,dp);
        }
        int right = knapsack(index-1,w,val,wt,dp);
        return dp[index][w]= Math.max(left,right);
    }
    //Tabulation
    public static int  knapsack1(int w , int []val ,int []wt) {
        int n = wt.length;
        int[][] dp = new int[n][w + 1];
        for (int[] row : dp)
            Arrays.fill(row, 0);

        for(int i=wt[0];i<=w;i++)
            dp[0][i] = val[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                int left = Integer.MIN_VALUE;
                if (j >= wt[i]) {
                    left = val[i] + dp[i - 1][j - wt[i]];
                }
                int right = dp[i - 1][j];
                dp[i][j] = Math.max(left, right);
            }
        }
        return dp[n-1][w];
    }
    //space optimised
    public static int  knapsack2(int w , int []val ,int []wt) {
        int n = wt.length;
        int[] prev = new int[w + 1];
            Arrays.fill(prev, 0);

        for(int i=wt[0];i<=w;i++)
            prev[i] = val[0];

        for (int i = 1; i < n; i++) {
            int [] temp = new int [w+1];
            for (int j = 0; j <= w; j++) {
                int left = Integer.MIN_VALUE;
                if (j >= wt[i]) {
                    left = val[i] + prev[j - wt[i]];
                }
                int right = prev[j];
                temp[j] = Math.max(left, right);
            }
            prev = temp;
        }
        return prev[w];
    }
    //Space optimised in single array approach
    public static int  knapsack3(int w , int []val ,int []wt) {
        int n = wt.length;
        int[] prev = new int[w + 1];
        Arrays.fill(prev, 0);

        for(int i=wt[0];i<=w;i++)
            prev[i] = val[0];

        for (int i = 1; i < n; i++) {
            for (int j = w; j >= 0; j--) {
                int left = Integer.MIN_VALUE;
                if (j >= wt[i]) {
                    left = val[i] + prev[j - wt[i]];
                }
                int right = prev[j];
                prev[j] = Math.max(left, right);
            }
        }
        return prev[w];
    }
    public static void main(String[] args) {
int []wt = {5, 4, 2, 3};
int [] val ={10, 40, 30, 50};
        System.out.println(knapsack3(5,val,wt));
    }
}
