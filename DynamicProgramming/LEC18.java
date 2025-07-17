package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC18 {
    //Memoization
    public static int countPartition(int []arr,int d)
    {
        int n =arr.length;
        int sum=0;
        for(int i=0;i<n;i++)
            sum +=arr[i];
        if(sum-d<0 || (sum-d)%2==1)
            return 0;
        int target = (sum-d)/2;
        int [][]dp = new int [n][target+1];
        for(int []row:dp)
            Arrays.fill(row,-1);
        return countPartition(arr,target,0,n,dp);
    }
    private static int countPartition(int []arr,int target,int index,int n,int [][]dp)
    {
        if(index==n)
        {
            if(target ==0)
                return 1;
            return 0;
        }
        if(dp[index][target]!=-1)
            return dp[index][target];
        int left =0;
        if(arr[index]<=target)
            left = countPartition(arr,target-arr[index],index+1,n,dp);
        int right = countPartition(arr,target,index+1,n,dp);
        dp[index][target]=left +right;
        return dp[index][target];
    }
    //Tabulation
    public static int countPartition1(int []arr,int d) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        if (sum - d < 0 || (sum - d) % 2 == 1)
            return 0;
        int target = (sum - d) / 2;
        int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp)
            Arrays.fill(row, 0);
        if (arr[0] == 0) {
            dp[0][0] = 2;
        } else
            dp[0][0] = 1;
        if (arr[0] != 0 && arr[0] <= target)
            dp[0][arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int left = 0;
                if (arr[i] <= j)
                    left = dp[i - 1][j - arr[i]];
                int right = dp[i - 1][j];
                dp[i][j] = left + right;
            }
        }
        return dp[n-1][target];
    }
    //space optimisation
    public static int countPartition2(int []arr,int d) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        if (sum - d < 0 || (sum - d) % 2 == 1)
            return 0;
        int target = (sum - d) / 2;
        int[] prev = new int [target + 1];

        if (arr[0] == 0) {
            prev[0] = 2;
        } else
            prev[0] = 1;
        if (arr[0] != 0 && arr[0] <= target)
            prev[arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            int []temp = new int[target+1];
            for (int j = 0; j <= target; j++) {
                int left = 0;
                if (arr[i] <= j)
                    left = prev[j - arr[i]];
                int right = prev[j];
                temp[j] = left + right;
            }
            prev = temp;
        }
        return prev[target];
    }
    public static void main(String[] args) {
int []arr = {1,1,1,1};
        System.out.println(countPartition2(arr,0));
    }
}
