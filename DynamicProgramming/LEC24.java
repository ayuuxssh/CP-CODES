package ayush.DynamicProgramming;
import java.util.*;
public class LEC24 {
    //Memoization
    public static int cutrod(int []price)
    {
        int n = price.length;
        int [][]dp = new int[n][n+1];
        for(int []row:dp)
            Arrays.fill(row,-1);
        return cutrod(price,n-1,n,dp);
    }
    private static int cutrod(int []price,int index,int target,int [][]dp)
    {
        if(index==0)
        {
                return target*price[0];
        }
        if(dp[index][target]!=-1)
            return dp[index][target];
        int left = cutrod(price,index-1,target,dp);
        int right = Integer.MIN_VALUE;
        if(index+1<=target)
        {
            right = price[index]+cutrod(price,index,target-(index+1),dp);
        }
        return dp[index][target]=Math.max(left,right);
    }
    //Tabulation
    public static int cutrod1(int []price)
    {
        int n = price.length;
        int [][]dp = new int[n][n+1];
        for(int []row:dp)
            Arrays.fill(row,-1);

        for(int i=0;i<=n;i++)
        {
            dp[0][i]= i*price[0];
        }
        for(int i=1;i<n;i++) {
            for (int j = 0; j <= n; j++) {
                int left = dp[i - 1][j];
                int right = Integer.MIN_VALUE;
                if (i + 1 <= j) {
                    right = price[i] + dp[i][j - (i + 1)];
                }
                dp[i][j] = Math.max(left, right);
            }
        }
        return dp[n-1][n];
    }
    //space optimised
    public static int cutrod2(int []price)
    {
        int n = price.length;
        int []prev = new int[n+1];
            Arrays.fill(prev,-1);

        for(int i=0;i<=n;i++)
        {
            prev[i]= i*price[0];
        }
        for(int i=1;i<n;i++) {
            int [] temp = new int[n+1];
            for (int j = 0; j <= n; j++) {
                int left = prev[j];
                int right = Integer.MIN_VALUE;
                if (i + 1 <= j) {
                    right = price[i] + temp[j - (i + 1)];
                }
                temp[j] = Math.max(left, right);
            }
            prev= temp;
        }
        return prev[n];
    }
    //Further optimised
    public static int cutrod3(int []price)
    {
        int n = price.length;
        int []prev = new int[n+1];
        Arrays.fill(prev,-1);

        for(int i=0;i<=n;i++)
        {
            prev[i]= i*price[0];
        }
        for(int i=1;i<n;i++) {
            for (int j = 0; j <= n; j++) {
                int left = prev[j];
                int right = Integer.MIN_VALUE;
                if (i + 1 <= j) {
                    right = price[i] + prev[j - (i + 1)];
                }
                prev[j] = Math.max(left, right);
            }
        }
        return prev[n];
    }
    public static void main(String[] args) {
int []arr={1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutrod3(arr));
    }
}
