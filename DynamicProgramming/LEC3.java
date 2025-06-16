package ayush.DynamicProgramming;
//Frog Jump
public class LEC3 {
    //Memoization
public static int mincost(int [] arr ,int n,int [] dp) {
    if (n == 0) {
        dp[n] = 0;
        return dp[n];
    }
    if (dp[n] != -1) {
        return dp[n];
    }
        int left = mincost(arr,n-1,dp)+Math.abs(arr[n]-arr[n-1]);
    int right = Integer.MAX_VALUE;
        if(n>1) {
            right = mincost(arr, n - 2, dp) + Math.abs(arr[n] - arr[n - 2]);
        }
    dp[n] = Math.min(left, right);
    return dp[n];
}
//Tabulation
public static int mincost(int []arr ,int []dp)
{
    dp[0] = 0;
    for(int i=1;i<arr.length;i++)
    {
        int left = dp[i-1]+Math.abs(arr[i]-arr[i-1]);
        int right = Integer.MAX_VALUE;
        if(i>1)
            right = dp[i-2]+Math.abs(arr[i]-arr[i-2]);
        dp[i] =Math.min(left,right);

    }
    return dp[arr.length-1];
}
//Space Optimization
    public static int mincost(int []arr)
    {
        int prev =0;
        int prev2=0;
        for(int i=1;i<arr.length;i++)
        {
            int left = prev+Math.abs(arr[i]- arr[i-1]);
            int right =Integer.MAX_VALUE;
            if(i>1)
                right = prev2+Math.abs(arr[i]-arr[i-2]);
            int curr = Math.min(left,right);
            prev2 = prev;
            prev = curr;

        }
        return prev;
    }
    // for k jumps
    public static int mincost(int []arr,int n,int[]dp ,int k)
    {
        if(n==0)
        {
            dp[n]=0;
            return dp[n];
        }
        if(dp[n]!=-1)
        {
            return  dp[n];
        }
        int min1 = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++)
        {
            if(n-i>=0) {
                int left = mincost(arr, n - i, dp, k) + Math.abs(arr[n] - arr[n - i]);
                min1=Math.min(min1, left);
                dp[n]=min1;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int[] arr = {30, 10, 60, 10, 60, 50};
        int n = arr.length-1;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
        {
            dp[i] = -1;
    }
        System.out.println(mincost(arr,n,dp,2));
    }
}
