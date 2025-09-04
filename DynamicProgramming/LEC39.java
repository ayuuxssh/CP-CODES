package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC39 {
    //Memoization
    public  static int maxProfit(int[] prices)
    {
int n = prices.length;
int [][]dp = new int[n+1][2];
for(int []row:dp)
    Arrays.fill(row,-1);
return maxProfit(prices,0,1,dp);
    }
    private static int maxProfit(int[]prices,int i,int buy,int [][]dp)
    {
        if(i>=prices.length)
            return 0;
        int profit =0;
        if(dp[i][buy]!=-1)
            return dp[i][buy];
        if(buy==1)
        {
            profit = Math.max(-prices[i]+maxProfit(prices,i+1,0,dp),maxProfit(prices,i+1,1,dp));
        }
        else
        {
            profit = Math.max(prices[i]+maxProfit(prices,i+2,1,dp),maxProfit(prices,i+1,0,dp));
        }
        return dp[i][buy]= profit;
    }
    //Tabulation

    public  static int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        dp[n][0] = 0;
        dp[n][1] = 0;
dp[n+1][0]=0;
dp[n+1][1]=0;
        int profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                if (j == 1) {
                    profit = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
                } else {
                    profit = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][1];
    }
    //space optimised
    public  static int maxProfit2(int[] prices) {
        int n = prices.length;
        int[]front = new int[2];
       int []front2 =new int[2];


        for (int i = n - 1; i >= 0; i--) {
            int [] curr = new int[2];
                    curr[1] = Math.max(-prices[i] + front[0], front[1]);
                    curr[0]= Math.max(prices[i] + front2[1], front[0]);
                    front2 = front;
                    front = curr;
        }
        return front[1];
    }
    public static void main(String[] args) {
int []  prices = {1,2,3,0,2};
        System.out.println(maxProfit2(prices));
    }
}
