package ayush.DynamicProgramming;
import java.util.*;
public class LEC40 {
    //Memiozation
    public static int maxProfit(int []prices,int fee)
    {
        int n = prices.length;
        int [][]dp = new int[n+1][2];
        for(int []row:dp)
            Arrays.fill(row,-1);
        return maxProfit(prices,0,1,fee,dp);
    }
    private static int maxProfit(int []prices,int i,int buy,int fee,int [][]dp)
    {
        if(i==prices.length)
            return 0;
        int profit =0;
        if(dp[i][buy]!=-1)
            return dp[i][buy];
        if(buy==1)
        {
            profit = Math.max(-prices[i]+maxProfit(prices,i+1,0,fee,dp),maxProfit(prices,i+1,1,fee,dp));
        }
        else
        {
            profit = Math.max(prices[i]+maxProfit(prices,i+1,1,fee,dp)-fee,maxProfit(prices,i+1,0,fee,dp));
        }
        return dp[i][buy]= profit;
    }
    //Tabulation
    public static int maxProfit1(int []prices,int fee)
    {
    int n = prices.length;
    int [][]dp = new int[n+1][2];
 dp[n][0]=0;
 dp[n][1]=0;
    int profit =0;
   for(int i=n-1;i>=0;i--) {

       dp[i][1] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
       dp[i][0]= Math.max(prices[i] + dp[i+1][1] - fee, dp[i+1][0]);
   }
    return dp[0][1];
    }
    //Space optimised
    public static int maxProfit2(int []prices,int fee)
    {
        int n = prices.length;
        int []after = new int[2];

        for(int i=n-1;i>=0;i--) {
int []curr = new int[2];
            curr[1] = Math.max(-prices[i] + after[0], after[1]);
            curr[0]= Math.max(prices[i] + after[1] - fee, after[0]);
            after = curr;
        }
        return after[1];
    }
    public static void main(String[] args) {
        int [] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println(maxProfit2(prices,fee));
    }
}
