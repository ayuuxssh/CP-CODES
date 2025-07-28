package ayush.DynamicProgramming;
import java.util.*;
public class LEC26 {
    public static List<String> lcs(String s1, String s2)
    {
        int n1 = s1.length();
        int n2 = s2.length();
        List<String> ans = new ArrayList<>();
        alllcs(n1,n2,s1,s2,ans);
        return ans;
    }
private static void alllcs(int index1,int index2,String s1,String s2,List<String>ans)
{
    int [][]dp = new int[index1+1][index2+1];
    for(int i=0;i<=index1;i++)
        dp[i][0]=0;
    for(int i=0;i<=index2;i++)
        dp[0][i]=0;
    for(int i=1;i<=index1;i++)
    {
        for(int j=1;j<=index2;j++)
        {
            if(s1.charAt(i-1)==s2.charAt(j-1))
            {
                dp[i][j]= 1+dp[i-1][j-1];
            }
            else
            {
                dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
    }
    int len = dp[index1][index2];
    String s="";
    int k=index1;
    int m = index2;
    int index = len-1;
    for(int i=0;i<len;i++)
        s +="$";
    StringBuilder ss = new StringBuilder(s1);
    StringBuilder str2 = new StringBuilder(s);
    while(k>0 && m>0)
    {
        if(s1.charAt(k-1) ==s2.charAt(m-1))
        {
str2.setCharAt(index,s1.charAt(k-1));
index--;
k--;
m--;
        }
        else if(dp[k-1][m]>dp[k][m-1])
        {
            k=k-1;
        }
        else
        {
            m= m-1;
        }
    }
    String str3 =str2.toString();
    ans.add(str3);
}

    public static void main(String[] args) {

        String s1= "abcde";
        String s2= "bdgek";
        System.out.println(lcs(s1,s2));
    }
}
