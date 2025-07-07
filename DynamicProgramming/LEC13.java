package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC13 {
    //Memoization
    public static int cherry(int [][]grid)
    {
      int n = grid.length;
        int m = grid[0].length;
        int [][][] dp= new int[n][m][m];
        for(int[][]row:dp)
        {
            for(int []row2:row)
                Arrays.fill(row2,-1);
        }
        return cherry(grid,0,0,m-1,dp);
    }
    private static int cherry(int [][]grid,int i,int j1,int j2,int[][][]dp)
    {
        if(j1<0 ||j1>=grid[0].length ||j2<0 ||j2>=grid[0].length)
            return (int)Math.pow(-10,9);
        if(i==grid.length-1)
        {
            if(j1==j2) {
                dp[i][j1][j2]=grid[i][j1];
                return dp[i][j1][j2];
            }
            else {
                dp[i][j1][j2]=grid[i][j1] + grid[i][j2];
                return dp[i][j1][j2];
            }
        }
        if(dp[i][j1][j2]!=-1)
        {
            return dp[i][j1][j2];
        }
        int max =Integer.MIN_VALUE;
        for(int d1 =-1;d1<=1;d1++) {

            for (int d2 = -1; d2 <= 1; d2++) {
int value;
                if (j1 == j2) {
                    value = grid[i][j1] + cherry(grid, i + 1, j1 + d1, j2 + d2,dp);
                }
                else {
                   value  = grid[i][j1]+grid[i][j2]+cherry(grid,i+1,j1+d1,j2+d2,dp);
                }
                dp[i][j1][j2] = Math.max(dp[i][j1][j2],value);
            }
                    }
        return dp[i][j1][j2];
    }
    //Tabulation
    public static int cherry1(int [][]grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int [][][] dp= new int[n][m][m];
        for(int[][]row:dp)
        {
            for(int []row2:row)
                Arrays.fill(row2,-1);
        }
        for(int j1=0;j1<m;j1++)
        {
            for(int j2=0;j2<m;j2++)
            {
                if(j1==j2) {
                    dp[n-1][j1][j2]=grid[n-1][j1];
                }
                else {
                    dp[n-1][j1][j2]=grid[n-1][j1] + grid[n-1][j2];
                }
            }
        }
        for(int i=n-2;i>=0;i--)
        {
            for(int j1=0;j1<m;j1++)
            {
                for(int j2=m-1;j2>=0;j2--)
                {
                    int max =Integer.MIN_VALUE;
                    for(int d1 =-1;d1<=1;d1++) {

                        for (int d2 = -1; d2 <= 1; d2++) {
                            int value;
                            if ((j1 + d1 < 0 || j1 + d1 >= m) || (j2 + d2 < 0 || j2 + d2 >= m))
                                value = (int) Math.pow(-10, 9);
                            else {

                                if (j1 == j2) {
                                    value = grid[i][j1] + dp[i + 1][j1 + d1][j2 + d2];
                                } else {
                                    value = grid[i][j1] + grid[i][j2] + dp[i + 1][j1 + d1][j2 + d2];
                                }
                            }
                                dp[i][j1][j2] = Math.max(dp[i][j1][j2], value);
                            }
                        }
                    }
                }
            }
        return dp[0][0][m-1];
    }
    //space optimisation
    public static int cherry2(int [][]grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int [][]dp= new int[m][m];

        for(int j1=0;j1<m;j1++)
        {
            for(int j2=0;j2<m;j2++)
            {
                if(j1==j2) {
                    dp[j1][j2]=grid[n-1][j1];
                }
                else {
                    dp[j1][j2]=grid[n-1][j1] + grid[n-1][j2];
                }
            }
        }
        for(int i=n-2;i>=0;i--)
        {
            int [][]temp = new int [m][m];
            for(int j1=0;j1<m;j1++) {
                for (int j2 = m - 1; j2 >= 0; j2--) {
                    int max = Integer.MIN_VALUE;
                    for (int d1 = -1; d1 <= 1; d1++) {

                        for (int d2 = -1; d2 <= 1; d2++) {
                            int value;
                            if ((j1 + d1 < 0 || j1 + d1 >= m) || (j2 + d2 < 0 || j2 + d2 >= m))
                                value = (int) Math.pow(-10, 9);
                            else {

                                if (j1 == j2) {
                                    value = grid[i][j1] + dp[j1 + d1][j2 + d2];
                                } else {
                                    value = grid[i][j1] + grid[i][j2] + dp[j1 + d1][j2 + d2];
                                }
                            }
                            temp[j1][j2] = Math.max(temp[j1][j2], value);
                        }
                    }
                }
            }
                for (int a = 0; a < m; a++) {
                    dp[a] = temp[a].clone();
                }

        }
        return dp[0][m-1];
    }
    public static void main(String[] args) {
int [][]arr = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println(cherry2(arr));
    }
}
