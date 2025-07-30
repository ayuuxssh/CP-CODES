package ayush.DynamicProgramming;
import java.util.*;
public class LEC27 {
    public static int longestcommonsubstring(String s1,String s2)
    {
        int n1 =s1.length();
        int n2 = s2.length();
        int [][]dp = new int[n1+1][n2+1];
        for(int []row:dp)
            Arrays.fill(row,-1);
   for(int i=0;i<=n1;i++)
       dp[i][0]=0;
   for(int i=0;i<=n2;i++)
       dp[0][i]=0;
   for(int i=1;i<=n1;i++)
   {
       for(int j=1;j<=n2;j++)
       {
           if(s1.charAt(i-1)==s2.charAt(j-1))
           {
               dp[i][j]= 1+dp[i-1][j-1];
           }
           else
               dp[i][j]=0;
       }
   }
   int max1 = Integer.MIN_VALUE;
   for(int i=0;i<=n1;i++)
   {
       for(int j=0;j<=n2;j++)
       {
           max1 = Math.max(max1,dp[i][j]);
       }
   }
   return max1;
    }
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        System.out.println(longestcommonsubstring(s1,s2));
    }
}
