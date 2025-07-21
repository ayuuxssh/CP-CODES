package ayush.DynamicProgramming;
import java.util.*;
public class LEC20 {
    //Memoization
    public static int coinchange(int []coins,int amount)
    {
        int n = coins.length;
        int [][]dp= new int[n][amount+1];
        for(int []row:dp)
            Arrays.fill(row,-1);
        int ans =coinchange(coins,amount,n-1,dp);
        if(ans>=(int)Math.pow(10,9))
            return -1;
        return ans;
    }
    private static int coinchange(int []cost,int target,int index,int [][]dp)
    {
        if(index==0)
        {
            if(target%cost[0]==0)
                return target/cost[0];
            else
                return (int)Math.pow(10,9);
        }
        if(dp[index][target]!=-1)
            return dp[index][target];
        int left = Integer.MAX_VALUE;
        if(cost[index]<=target)
            left = 1+coinchange(cost,target-cost[index],index,dp);
        int right = coinchange(cost,target,index-1,dp);
        return dp[index][target]=Math.min(left,right);
    }
    //Tabulation
    public static int coinchange1(int []coins,int amount)
    {
        int n = coins.length;
        int [][]dp= new int[n][amount+1];
        for(int []row:dp)
            Arrays.fill(row,0);
        for(int i=0;i<=amount;i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i/ coins[0];
            }
            else
                dp[0][i]=(int)Math.pow(10,9);
        }
            for(int i=1;i<n;i++)
            {
                for(int j=0;j<=amount;j++)
                {
        int left = Integer.MAX_VALUE;
        if(coins[i]<=j)
            left = 1+dp[i][j-coins[i]];
        int right = dp[i-1][j];
         dp[i][j]=Math.min(left,right);
                }
            }
            if(dp[n-1][amount]>=(int)Math.pow(10,9))
                return -1;
            return dp[n-1][amount];
    }
    //Space optimised
    public static int coinchange2(int []coins,int amount)
    {
        int n = coins.length;
        int []prev= new int[amount+1];
            Arrays.fill(prev,0);
        for(int i=0;i<=amount;i++) {
            if (i % coins[0] == 0) {
                prev[i] = i/ coins[0];
            }
            else
                prev[i]=(int)Math.pow(10,9);
        }
        for(int i=1;i<n;i++)
        {
            int [] temp = new int[amount+1];
            for(int j=0;j<=amount;j++)
            {
                int left = Integer.MAX_VALUE;
                if(coins[i]<=j)
                    left = 1+temp[j-coins[i]];
                int right = prev[j];
                temp[j]=Math.min(left,right);
            }
            prev = temp;
        }
        if(prev[amount]>=(int)Math.pow(10,9))
            return -1;
        return prev[amount];
    }

    public static void main(String[] args) {
int []arr ={1,2,5};
        System.out.println(coinchange2(arr,11));
    }
}
