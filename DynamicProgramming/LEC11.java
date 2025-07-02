package ayush.DynamicProgramming;
import java.util.*;
public class LEC11 {
    //Memoization
    public static int minpathtriangle(List<List<Integer>>triangle)
    {
        int [][]dp= new int[triangle.size()][triangle.size()+1];
        for(int[]row:dp)
            Arrays.fill(row,-1);
        return minpath(0,0,triangle,dp);
    }
    private static int minpath(int i,int j,List<List<Integer>>triangle,int [][]dp)
    {
        int m = triangle.size();
        int n = m+1;
        if(i== m-1) {
            dp[i][j] = triangle.get(i).get(j);
            return dp[i][j];
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        int left =  triangle.get(i).get(j)+minpath(i+1,j,triangle,dp);
      int right =  triangle.get(i).get(j)+minpath(i+1,j+1,triangle,dp);
      dp[i][j]= Math.min(left,right);
      return dp[i][j];
    }
    //Tabulation
    public static int minpathtriangle1(List<List<Integer>>triangle)
    {
        int [][]dp= new int[triangle.size()][triangle.size()+1];
        for(int[]row:dp)
            Arrays.fill(row,-1);
        int m = triangle.size();
        int n = m+1;
        for(int i=m-1;i>=0;i--) {
            for (int j = 0; j <= i; j++) {
                if (i == m - 1) {
                    dp[i][j] = triangle.get(i).get(j);
                    continue;
                }
                int left = triangle.get(i).get(j) + dp[i + 1][j];
                int right = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(left, right);
            }
        }
        return dp[0][0];
    }
    //space optimisation
    public static int minpath2(List<List<Integer>> triangle)
    {
    int []prev= new int[triangle.size()];

            Arrays.fill(prev,-1);
    int m = triangle.size();
        for(int i=m-1;i>=0;i--) {
            int [] temp = new int[m];
        for (int j = 0; j <= i; j++) {
            if (i == m - 1) {
                prev[j] = triangle.get(i).get(j);
                continue;
            }
            int left = triangle.get(i).get(j) + prev[j];
            int right = triangle.get(i).get(j) + prev[j + 1];
            temp[j] = Math.min(left, right);
        }
        prev = temp;
    }
        return prev[0];
}
    public static void main(String[] args) {

}

    }

