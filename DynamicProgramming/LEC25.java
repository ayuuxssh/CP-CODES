package ayush.DynamicProgramming;
import java.util.*;
public class LEC25 {
    //Memoization
    public static  int lcs(String text1, String text2)
    {
        int n1 = text1.length();
        int n2 = text2.length();
        int [][]dp = new int[n1+1][n2+1];
        for(int []row:dp)
            Arrays.fill(row,-1);
        return lcs(text1,text2,n1-1,n2-1,dp);
    }
    private static int  lcs(String text1,String text2,int index1,int index2,int [][]dp)
    {
        if(index1<0 ||index2<0) {
            return 0;
        }
        if(dp[index1][index2]!=-1)
            return dp[index1][index2];
        if(text1.charAt(index1)==text2.charAt(index2))
        {
            return  dp[index1][index2]=1+lcs(text1,text2,index1-1,index2-1,dp);
        }
        else {
            return dp[index1][index2]= Math.max(lcs(text1, text2, index1 - 1, index2,dp), lcs(text1, text2, index1, index2 - 1,dp));
        }
    }
    //Tabulation
    public static  int lcs1(String text1, String text2)
    {
        int n1 = text1.length();
        int n2 = text2.length();
        int [][]dp = new int[n1+1][n2+1];
        for(int []row:dp)
            Arrays.fill(row,-1);
        for(int i=0;i<=n1;i++) {
                dp[i][0] = 0;
        }
        for(int i=0;i<=n2;i++) {
                dp[0][i] = 0;
        }
        for(int i=1;i<=n1;i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
    //Space optimised
    public static  int lcs2(String text1, String text2)
    {
        int n1 = text1.length();
        int n2 = text2.length();
        int []prev = new int[n2+1];
        for(int i=0;i<=n1;i++) {
            prev[0] = 0;
        }
        for(int i=0;i<=n2;i++) {
            prev[i] = 0;
        }
        for(int i=1;i<=n1;i++) {
            int []temp = new int[n2+1];
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                   temp [j] = 1 + prev[j - 1] ;
                } else {
                    temp[j] = Math.max(prev[j], temp[j - 1]);
                }
            }
            prev= temp;
        }
        return prev[n2];
    }
    public static void main(String[] args) {
String text1 = "abcde";String text2 = "ace";
        System.out.println(lcs2(text1,text2));
    }
}
