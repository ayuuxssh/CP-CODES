package ayush.DynamicProgramming;
import java.util.*;
public class LEC33 {
    //Memoization
    public  static int minDistance(String word1, String word2)
    {
        int n = word1.length();
        int m = word2.length();
        int [][]dp = new int[n+1][m+1];
        for(int []row:dp)
            Arrays.fill(row,-1);
        return minDistance(word1,word2,n,m,dp);
    }
    private static int minDistance(String word1, String word2,int i,int j,int [][]dp)
    {
        if(i==0)
            return j;
        if(j==0)
            return i;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(word1.charAt(i-1)==word2.charAt(j-1))
        {
            return minDistance(word1, word2, i - 1, j - 1,dp);
        }
        else {
            int insert = 1 + minDistance(word1, word2, i, j - 1,dp);
            int delete = 1 + minDistance(word1, word2, i - 1, j,dp);
            int replace = 1 + minDistance(word1, word2, i - 1, j - 1,dp);

            return dp[i][j]=Math.min(insert,Math.min(delete,replace));
        }
    }
    //Tabulation
    public  static int minDistance1(String word1, String word2)
    {
        int n = word1.length();
        int m = word2.length();
        int [][]dp = new int[n+1][m+1];
    for(int i=0;i<=n;i++)
    {
        dp[i][0]=i;
    }
    for(int i=0;i<=m;i++)
        dp[0][i]=i;
    for(int i=1;i<=n;i++) {
        for (int j = 1; j <= m; j++) {
            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                int insert = 1 + dp[i][j - 1];
                int delete = 1 + dp[i - 1][j];
                int replace = 1 + dp[i - 1][j - 1];
                dp[i][j] = Math.min(insert, Math.min(delete, replace));
            }
        }
    }
    return dp[n][m];
    }
    //Space optimisation
    public  static int minDistance2(String word1, String word2)
    {
        int n = word1.length();
        int m = word2.length();
        int []prev = new int[m+1];

        for(int i=0;i<=m;i++)
            prev[i]=i;
        for(int i=1;i<=n;i++) {
            int []curr = new int[m+1];
            curr[0]=i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int insert = 1 + curr[j - 1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j - 1];
                    curr[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = curr;
        }
        return prev[m];
    }
    public static void main(String[] args) {
       String  word1 = "horse", word2 = "ros";
        System.out.println(minDistance2(word1,word2));
    }
}
