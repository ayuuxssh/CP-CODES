package ayush.DynamicProgramming;

public class LEC5 {
    //Memoization
    public static int Houserobber(int [] arr,int n , int []dp)
    {
        if(n==0)
        {
            dp[n] =arr[n];
            return dp[n];
        }
        if(n<0)
        {
            return 0;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }

         int left = arr[n]+Houserobber(arr,n-2,dp);
        int right = 0+Houserobber(arr,n-1,dp);
        dp[n]= Math.max(left,right);
        return dp[n];
    }
    //Tabulation
    public static int HouseRobber(int []arr,int []dp)
    {
        dp[0]=arr[0];
        for(int i=1;i<arr.length;i++)
        {

            int left = arr[i];
            if(i>1) {
                 left  += dp[i - 2];
            }
            int right = 0+dp[i-1];
            dp[i] = Math.max(left,right);
        }
        return dp[arr.length-1];
    }
    //space optimization
    public static int HouseRobber(int []arr)
    {
        int prev =arr[0];
        int prev2 = 0;
        for(int i =1;i<arr.length;i++)
        {
            int left = arr[i];
            if(i>1)
            {
                left+=prev2;
            }
            int right = 0+prev;
            int curr = Math.max(left,right);
            prev2 =prev;
            prev = curr;
        }
return prev;

    }
    //All houses are arranged in circle.
    public static void main(String[] args) {
int [] arr ={1,2};
int n = arr.length;
int [] dp =new int[n];
for(int i=0;i<n;i++)
    dp[i]=-1;
        System.out.println(HouseRobber(arr));
    }
}
