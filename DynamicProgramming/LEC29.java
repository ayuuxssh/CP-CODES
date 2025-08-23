package ayush.DynamicProgramming;

public class LEC29 {
    //Tabulation
    public  static int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String s1 = sb.toString();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
        {
            dp[i][0]=0;
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==s1.charAt(j-1))
                {
                    dp[i][j]= 1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return n-dp[n][n];
    }
    //Space optimisation
    public static int minInsertions1(String s)
    {
    int n = s.length();
    StringBuilder sb = new StringBuilder(s);
        sb.reverse();
    String s1 = sb.toString();
    int[]prev = new int[n + 1];
        for (int i = 0; i <= n; i++)
    {
        prev[i]=0;
    }
        for(int i=1;i<=n;i++)
    {
        int []curr = new int[n+1];
        curr[0]=0;
        for(int j=1;j<=n;j++)
        {
            if(s.charAt(i-1)==s1.charAt(j-1))
            {
                curr[j]= 1+prev[j-1];
            }
            else
            {
                curr[j]= Math.max(prev[j],curr[j-1]);
            }
        }
        prev = curr;
    }
        return n-prev[n];
}
    public static void main(String[] args) {
String s ="zzazz";
        System.out.println(minInsertions1(s));
    }
}
