package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC34 {
    //Memoization
    public  static boolean isMatch(String s, String p)
    {
        int n =s.length();
        int m = p.length();
        int[][]dp = new int [n][m];
        for(int []row:dp)
            Arrays.fill(row,-1);
        return isMatch(s,p,n-1,m-1,dp);
    }
    private static boolean isMatch(String s,String p ,int i,int j,int [][]dp)
    {
if(i<0 &&j<0)
    return true;
if(j<0 && i>=0)
return false;
        if(i<0 && j>=0) {
            for(int k=0;k<=j;k++)
            {
               if(p.charAt(k)!='*')
                   return false;
            }
            return true;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j]==1?true:false;
        }
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
        {
            return isMatch(s,p,i-1,j-1,dp);
        }
       if(p.charAt(j)=='*') {
           boolean match1 = isMatch(s,p,i,j-1,dp);
           boolean match2 = isMatch(s,p,i-1,j,dp);
            dp[i][j]= (match2 | match1)?1:0;
            return match2|match1;
       }
       return false;
        }
//Tabulation
public  static boolean isMatch1(String s, String p) {
    int n = s.length();
    int m = p.length();
    boolean[][] dp = new boolean[n + 1][m + 1];
    for (boolean[] row : dp)
        Arrays.fill(row, false);
    dp[0][0] = true;
    for (int i = 1; i <= n; i++)
        dp[i][0] = false;
    for (int i = 1; i <= m; i++) {
        boolean flag = true;
        for (int j = 1; j <= i; j++) {
            if (p.charAt(j - 1) != '*') {
                 flag=false;
                break;
            }
        }
        dp[0][i]=flag;
    }
      for(int i=1;i<=n;i++) {
          for (int j = 1; j <= m; j++) {
              if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                  dp[i][j] = dp[i - 1][j - 1];
              }
            else  if (p.charAt(j - 1) == '*') {
                  boolean match1 = dp[i][j - 1];
                  boolean match2 = dp[i - 1][j];
                  dp[i][j] = (match2 | match1);
              }
          }
      }
      return dp[n][m];
    }
    //Space Optimisation
    public  static boolean isMatch2(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[] prev = new boolean[m + 1];

            Arrays.fill(prev, false);
        prev[0] = true;

        for (int i = 1; i <= m; i++) {
            boolean flag = true;
            for (int j = 1; j <= i; j++) {
                if (p.charAt(j - 1) != '*') {
                    flag=false;
                    break;
                }
            }
            prev[i]=flag;
        }
        for(int i=1;i<=n;i++) {
            boolean [] curr = new boolean [m+1];
            curr[0]=false;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                }
                else  if (p.charAt(j - 1) == '*') {
                    boolean match1 = curr[j - 1];
                    boolean match2 = prev[j];
                    curr[j] = (match2 | match1);
                }
            }
            prev = curr;
        }
        return prev[m];
    }
    public static void main(String[] args) {
       String  s = "aa", p = "*";
        System.out.println(isMatch2(s,p));
    }

}
