package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC16 {
    //TABULATION WORKS FOR POSITIVE NUMBERS!!
    public static int mindifference(int [] nums)
    {
       int min1 = (int)Math.pow(10,9);
       int total =0;
       for(int i=0;i<nums.length;i++)
           total +=nums[i];
       for(int i=0;i<=total/2;i++)
       {
           if(subset(nums,i)==true)
           {
               int s1 = i;
               int s2 = (total-s1);
               min1 = Math.min(min1,Math.abs(s2-s1));
           }
       }
       return min1;
    }
    private static boolean subset(int [] nums,int target)
    {
        int n = nums.length;
        boolean [][]dp = new boolean[n][(int)Math.pow(10,4)];
        for(boolean []row:dp)
            Arrays.fill(row,false);
        for(int i=0;i<n;i++)
            dp[i][0]= true;
        if(nums[0]<=target)
            dp[0][nums[0]]=true;
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=target;j++)
            {
                boolean pick = false;
                if(nums[i]<=j)
                    pick = dp[i-1][j-nums[i]];
                boolean notpick = dp[i-1][j];
                dp[i][j]= pick||notpick;
            }
        }
        return dp[n-1][target];
    }
    public static void main(String[] args) {
int [] arr={3,9,7,3};
        System.out.println(mindifference(arr));
    }
}
