package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC32 {
    //Memoization
    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return numDistinct(s, t, n - 1, m - 1, dp);
    }

    private static int numDistinct(String s, String t, int i, int j, int[][] dp) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = numDistinct(s, t, i - 1, j - 1, dp) + numDistinct(s, t, i - 1, j, dp);
        } else {
            return dp[i][j] = numDistinct(s, t, i - 1, j, dp);
        }
    }

    //Tabulation
    public static int numDistinct1(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        for (int j = 1; j <= m; j++)
            dp[0][j] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
//Space optimised
public static int numDistinct2(String s, String t) {
    int n = s.length();
    int m = t.length();
    int[] prev = new int [m + 1];
    prev[0]=1;
    for (int j = 1; j <= m; j++)
        prev[j] = 0;
    for (int i = 1; i <= n; i++) {
        int []curr = new int[m+1];
        curr[0]=1;
        for (int j = 1; j <= m; j++) {
            if (s.charAt(i-1) == t.charAt(j-1)) {
                curr[j] = prev[j - 1] + prev[j];
            } else {
                curr[j] = prev[j];
            }
        }
        prev= curr;
    }
    return prev[m];
}
//1d Array optimised
public static int numDistinct3(String s, String t) {
    int n = s.length();
    int m = t.length();
    int[] prev = new int [m + 1];
    prev[0]=1;
    for (int j = 1; j <= m; j++)
        prev[j] = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = m; j >= 1; j--) {
            if (s.charAt(i-1) == t.charAt(j-1)) {
                prev[j]+= prev[j - 1] ;
            }
            }
        }
    return prev[m];
}
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct3(s,t));
    }

}
