package ayush.DynamicProgramming;

public class LEC31 {

    public static String Scs(String str1,String str2)
    {
        int n= str1.length();
        int m=str2.length();
        int[][]dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            dp[i][0]=0;
        for(int i=0;i<=m;i++)
            dp[0][i]=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int len = n+m-dp[n][m];
        int k =n;
        int r = m;
        String str="";
        StringBuilder sb = new StringBuilder(str);
        while(k>0 && r>0)
        {
            if(str1.charAt(k-1)==str2.charAt(r-1))
            {
                sb.append(str1.charAt(k-1));
                k--;
                r--;
            }
            else if(dp[k-1][r]>dp[k][r-1])
{
    sb.append(str1.charAt(k-1));
    k--;
}
            else
            {
                sb.append(str2.charAt(r-1));
                r--;
            }
        }
        while(k>0)
        {
            sb.append(str1.charAt(k-1));
            k--;
        }
        while(r>0)
        {
            sb.append(str2.charAt(r-1));
            r--;
        }
        sb.reverse();
        String s3 = sb.toString();
        return s3;
    }
    public static void main(String[] args)
    {
        String str1 = "abac";
        String str2 = "cab";
        System.out.println(Scs(str1,str2));
    }
}
