package ayush.SlidingWindow;
//Maximum Sum subarray with size k
public class LEC3 {
    //Brute force
    //T.C-O(N^2)
    public static int maxSubarraySum(int[] arr, int k)
    {
        int n = arr.length;
        int ans = 0;
        for(int i=0;i<=n-k;i++)
        {
            int sum =0;
            for(int j=i;j<i+k;j++)
            {
                sum+=arr[j];
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
//sliding window
public static int maxSubarraySum1(int[] arr, int k)
{
    int n = arr.length;
  int sum=0;
  for(int i=0;i<k;i++)
      sum+=arr[i];
  int m =0;
  int j =k;
  int ans = sum;
  while(j<n)
  {
sum+=arr[j]-arr[m];
m++;
j++;
ans = Math.max(ans,sum);
  }
    return ans;
}
    public static void main(String[] args) {
        int [] arr = {100, 200, 300, 400};
        int k = 2;
        System.out.println(maxSubarraySum1(arr,k));
    }
}
