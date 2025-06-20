package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC7 {
    //Memoization
    public static int training(int [][]arr)
    {
        int n = arr.length;
        int [][]dp  = new int[n][4];
        for(int []row:dp)
        {
            Arrays.fill(row,-1);
        }
        return training(n-1,3,arr,dp);
    }
    private static int training(int days,int last,int [][]arr,int[][]dp)
    {
        if(dp[days][last]!=-1)
        {
            return dp[days][last];
        }
        if(days==0)
        {
            int maxi =Integer.MIN_VALUE;
            for(int i=0;i<3;i++)
            {
                if(i!=last)
                {
                   maxi = Math.max(maxi,arr[0][i]);

                }
            }
            return dp[days][last] =maxi;
        }

        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<3;i++)
        {
            if(i!=last)
            {
                int points = arr[days][i]+training(days-1,i,arr,dp);
                maxi = Math.max(maxi,points);
            }
        }
        return dp[days][last] = maxi;
    }
    //Tabulation
    public static int training1(int [][] arr)
    {
int n = arr.length;
        int [][]dp = new int[n][4];
        for(int []row:dp)
        {
            Arrays.fill(row,-1);
        }
        return training1(n,dp,arr);
    }
    private static int training1(int days,int [][]dp,int[][]arr)
    {
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
        dp[0][2] = Math.max(arr[0][0],arr[0][1]);
        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
        dp[0][3] = Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));

        for(int i=1;i<days;i++) {
            for (int last = 0; last < 4; last++) {
                dp[i][last] = 0;
                for (int j = 0; j < 3; j++) {
                    if (j != last) {
                        int points = arr[i][j] + dp[i-1][j];
                        dp[i][last] = Math.max(dp[i][last], points);
                    }
                }
            }
        }
        return dp[days-1][3];
    }
    //Space optimisation
    public static int training2(int [][]arr)
    {
        int []dp = new int[arr.length];
        for(int i=0;i<arr.length;i++)
            dp[i] =-1;
        return training2(arr,dp);
    }
    private static int training2(int [][]arr,int []dp)
    {
        dp[1] = Math.max(arr[0][0],arr[0][2]);
        dp[2] = Math.max(arr[0][0],arr[0][1]);
      dp[0] = Math.max(arr[0][1],arr[0][2]);
        dp[3] = Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));
        for(int day =1;day<arr.length;day++)
        {
            int []temp = new int[4];
            for(int last =0;last<4;last++)
            {
                temp[last]=0;
                for(int j=0;j<3;j++)
                {
                    if(j!=last)
                    {
                        temp[last] = Math.max(temp[last],arr[day][j]+dp[j]);
                    }
                }
            }
            dp= temp;
        }
        return dp[3];
    }
    public static void main(String[] args) {
int [][]arr ={{2,1,3},{3,4,6},{10,1,6},{8,3,7}};
        System.out.println(training2(arr));
    }
}
