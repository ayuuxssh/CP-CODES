package ayush.DynamicProgramming;
import java.util.*;
public class LEC8 {
    //Memoization
    public static int unique(int m , int n)
    {
int[][]dp = new int[m][n];
for(int [] row:dp)
    Arrays.fill(row,-1);
        return unique1(m-1,n-1,dp);
    }
    private static int unique1(int m , int n,int[][]dp)
    {
        if(m==0 && n==0) {
            dp[m][n] = 1;
            return dp[m][n];
        }
        if(m<0 || n<0)
            return 0;
        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }
        int left = unique1(m-1,n,dp);
        int right = unique1(m,n-1,dp);
        dp[m][n]= left+right;
        return dp[m][n];
    }
    //TC-O(N*M)
    //SC-O(N-1+M-1)+O(N*M)
    public static int unique2(int m , int n)
    {
        int[][]dp = new int[m][n];
        for(int [] row:dp)
            Arrays.fill(row,-1);
//        for(int k=0;k<n;k++)
//            dp[0][k]=1;
//        for(int r=0;r<m;r++)
//            dp[r][0]=1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dp[i][j]!=-1)
                    return dp[i][j];
                if(i==0 && j==0)
                    dp[0][0]=1;
                else {
                    int left = 0;
                    int right = 0;

                    if (i > 0)
                        left = dp[i - 1][j];
                    if (j > 0)
                        right = dp[i][j - 1];
                    dp[i][j] = left + right;
                }
                }
            }

        return dp[m-1][n-1];
    }
    //TC -O(N*M)
    //SC-O(N*M)
    //Space optimisation
    public static int unique3(int m ,int n)
    {
        int [] dp = new int[n];
        Arrays.fill(dp,0);
        for(int i=0;i<m;i++)
        {
            int [] temp =new int [n];
            Arrays.fill(temp,0);
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                {
                    temp[j] =1;
                }
                else
                {
                    int left =0;
                    int right =0;
                    if(i>0)
                        left = dp[j];
                    if(j>0)
                        right = temp[j-1];
                    temp[j] = left + right;
                }
            }
            dp = temp;

        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        System.out.println(unique3(51,9));
    }
}
