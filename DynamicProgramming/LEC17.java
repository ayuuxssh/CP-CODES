package ayush.DynamicProgramming;
import java.util.*;
public class LEC17 {
    //Memoization
    public static int countsum(int [] nums,int target)
    {
        int n = nums.length;
        int [][]dp = new int[n][target+1];
        for(int [] row:dp)
            Arrays.fill(row,-1);
        return countsum(nums,n-1,target,dp);
    }
    private static int countsum(int []nums,int index,int target,int [][]dp)
    {
//This case is not working for 0
         /*   if(target == 0)
                return 1;
            if(index==0) {
                if (nums[index] == target)
                    return 1;
                return 0;
            }*/
        //This is working
//        if(index<0)
//        {
//            if(target ==0)
//                return 1;
//            return 0;
//        }
        //Strivers
        if(index ==0)
        {
            if(target ==0 && nums[0]==0)
                return 2;
            else if(target==0||nums[0]==target)
                return 1;
            return 0;
        }
        if(dp[index][target]!=-1)
            return dp[index][target];
        int left =0;
        if(nums[index]<=target)
         left = countsum(nums,index-1,target-nums[index],dp);
        int right = countsum(nums,index-1,target,dp);
        dp[index][target]= left+right;
        return dp[index][target];
    }
    //Tabulation
    public static int countsum1(int [] nums,int target)
    {
        int n = nums.length;
        int [][]dp = new int[n][target+1];
        for(int [] row:dp)
            Arrays.fill(row,-1);
        if(nums[0]==0)
        {
            dp[0][0]=2;
        }
        else {
            dp[0][0] = 1;
        }
            if(nums[0]!=0 && nums[0]<=target)
                dp[0][nums[0]]=1;
        for(int i=1;i<n;i++) {
            for (int j = 0; j <= target; j++) {
                int left = 0;
                if (nums[i] <= j)
                    left = dp[i - 1][j - nums[i]];
                int right = dp[i - 1][j];
                dp[i][j] = left + right;
            }
        }
        return dp[n-1][target];
    }
    //space optimisation
    public static int countsum2(int [] nums,int target)
    {
        int n = nums.length;
        int count =0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
                count++;
        }
        int []prev = new int[target+1];
            Arrays.fill(prev,0);
            if(nums[0]==0)
            {
                prev[0]=2;
            }
            else {
                prev[0] = 1;
            }
        if(nums[0]!=0&&nums[0]<=target)
            prev[nums[0]]=1;
        for(int i=1;i<n;i++) {
            int [] temp = new int[target+1];
            temp[0]=1;
            for (int j = 0; j <= target; j++) {
                int left = 0;
                if (nums[i] <= j)
                    left = prev[j - nums[i]];
                int right = prev[j];
                temp[j] = left + right;
            }
            prev = temp;
        }
        return prev[target];
    }
    public static void main(String[] args) {
int [] arr ={0,10,0};
        System.out.println(countsum1(arr,0));
    }
}
