package ayush.DynamicProgramming;
import java.util.*;
public class LEC2 {

    //Memoization
    public static int climbstairs(int n,int[]dp)
    {
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        int left = climbstairs(n-1,dp);
        int right = climbstairs(n-2,dp);
        return dp[n] = left+right;
    }
    // TC -O(N)
    //SC - 2(N)

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        int [] dp = new int[n+1];
        for(int i=0;i<n+1;i++)
            dp[i]=-1;
        System.out.println(climbstairs(n,dp));
    }
}
