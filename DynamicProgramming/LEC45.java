package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC45 {

    public static  int longestStrChain(String[] words)
    {
        int n = words.length;
        Arrays.sort(words,(String a , String b)->a.length()-b.length());
        int []dp = new int [n];
        Arrays.fill(dp,1);
        int max =1;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(check(words[i],words[j]) && 1+dp[j]>dp[i])
                {
                    dp[i] = 1+dp[j];
                }
            }
            if(dp[i]>max)
            {
                max = dp[i];
            }
        }
        return max;
    }
    private static boolean check(String words1,String words2)
    {
        if(words1.length()!=words2.length()+1)
            return false;
        int k=0;
        int m =0;
        while(k<words1.length())
        {
            if(m<words2.length() && words1.charAt(k)==words2.charAt(m))
            {
                k++;
                m++;
            }
            else
            {
                k++;
            }
        }
        if(k==words1.length() && m ==words2.length()) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
       String [] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(words));
    }
}
