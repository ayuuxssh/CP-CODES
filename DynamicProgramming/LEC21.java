package ayush.DynamicProgramming;
import java.util.*;
public class LEC21 {
    //Memoization
    public static int target(int []nums,int target)
    {
        int n = nums.length;
        int sum =0;
        for(int i=0;i<n;i++)
            sum +=nums[i];
        int target1 = (sum-target)/2;
        if(sum-target<0 ||(sum-target)%2==1)
            return 0;
        int [][]dp = new int[n][target1+1];
        for(int []row:dp)
            Arrays.fill(row,-1);
        return target(nums,n-1,target1,dp);
    }
    private static int target(int [] nums,int index,int target,int [][]dp)
    {
        if(index==0)
        {
            if(target==0 && nums[0]==0)
                return 2;
            else if(target==0 ||nums[0]==target)
                return 1;
            return 0;
        }
        if(dp[index][target]!=-1)
            return dp[index][target];
        int left = target(nums,index-1,target,dp);
        int right =0;
        if(nums[index]<=target)
            right = target(nums,index-1,target-nums[index],dp);
        return dp[index][target]=left +right;
    }
    //Tabulation
    public static int target1(int []nums,int target)
    {
        int n = nums.length;
        int sum =0;
        for(int i=0;i<n;i++)
            sum +=nums[i];
        int target1 = (sum-target)/2;
        if((sum-target)<0 ||(sum-target)%2==1)
            return 0;
        int [][]dp = new int[n][target1+1];
        for(int []row:dp)
            Arrays.fill(row,0);
            if( nums[0]==0)
             dp[0][0] =  2;
            else
                dp[0][0]=1;
if(nums[0]!=0 && nums[0]<=target1)
    dp[0][nums[0]]=1;
            for(int i=1;i<n;i++) {
                for (int j = 0; j <= target1; j++) {
                    int left = dp[i - 1][j];
                    int right = 0;
                    if (nums[i] <= j)
                        right = dp[i - 1][j - nums[i]];
                    dp[i][j] = left + right;
                }
            }
            return dp[n-1][target1];
    }
    //space optimisation
    public static int target2(int []nums,int target)
    {
        int n = nums.length;
        int sum =0;
        for(int i=0;i<n;i++)
            sum +=nums[i];
        int target1 = (sum-target)/2;
        if((sum-target)<0 ||(sum-target)%2==1)
            return 0;
        int []prev = new int[target1+1];
     ;
        if( nums[0]==0)
            prev[0] =  2;
        else
            prev[0]=1;
        if(nums[0]!=0 && nums[0]<=target1)
            prev[nums[0]]=1;
        for(int i=1;i<n;i++) {
            int []temp = new int[target1+1];
            for (int j = 0; j <= target1; j++) {
                int left = prev[j];
                int right = 0;
                if (nums[i] <= j)
                    right = prev[j - nums[i]];
                temp[j] = left + right;
            }
            prev = temp;
        }
        return prev[target1];
    }
    public static void main(String[] args) {
int []arr ={1,1,1,1,1};
        System.out.println(target2(arr,3));
    }
}
