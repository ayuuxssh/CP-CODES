package ayush.DynamicProgramming;
import java.util.*;
public class LEC1 {
    //Memoization
    /*public static int fibo(int n,int []dp)
    {
        if(n<=1)
            return n;
        if(dp[n]!=-1)
            return dp[n];
        else
        {
            dp[n] =fibo(n-1,dp)+fibo(n-2,dp);
            return dp[n];
        }
         //TC -O(N)
    //SC-2O(N)
    }*/
    //Tabulation
   /* public static int[] fibo(int n ,int [] dp)
    {
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i] =dp[i-1]+dp[i-2];
        }
        return dp;
        // TC - O(N)
        SC - O(N)
    }*/
    //Space Optimisation
    public static void fibo(int n)
    {
        int prev2 =0;
        int prev =1;
        int curri =0;
        for(int i=2;i<=n;i++)
        {
            curri = prev+prev2;
            prev2 = prev;
            prev =curri;
        }
        if(n>=1)
        System.out.println(prev);
        else
            System.out.println(prev2);
    }
//TC -O(N)
    //SC -O(1)
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        fibo(n);
    }

}
