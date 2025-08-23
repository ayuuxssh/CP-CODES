package ayush.DynamicProgramming;

public class LEC30 {
    //Tabulation
     public  static int minDistance(String word1, String word2)
     {
         int n = word1.length();
         int m = word2.length();
         int [][]dp = new int [n+1][m+1];
         for(int i=0;i<=n;i++)
         {
             dp[i][0]=0;
         }
         for(int i=0;i<=m;i++)
         {
             dp[0][i]=0;
         }
         for(int i=1;i<=n;i++)
         {
             for(int j=1;j<=m;j++)
             {
                 if(word1.charAt(i-1)==word2.charAt(j-1))
                 {
                     dp[i][j]= 1+dp[i-1][j-1];
                 }
                 else
                     dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
             }
         }
         return n+m -2*dp[n][m];
     }
     //Space optimised
     public  static int minDistance1(String word1, String word2)
     {
         int n = word1.length();
         int m = word2.length();
         int []prev = new int [m+1];
         for(int i=0;i<=m;i++)
         {
             prev[i]=0;
         }
         for(int i=1;i<=n;i++)
         {
             int []curr = new int[m+1];
             curr[0]=0;
             for(int j=1;j<=m;j++)
             {
                 if(word1.charAt(i-1)==word2.charAt(j-1))
                 {
                     curr[j]= 1+prev[j-1];
                 }
                 else
                     curr[j]= Math.max(prev[j],curr[j-1]);
             }
             prev = curr;
         }
         return n+m -2*prev[m];
     }
    public static void main(String[] args) {
String word1 = "leetcode";
        String word2 = "etco";
        System.out.println(minDistance(word1,word2));
    }
}
