package ayush.Binarrysearch;

public class LEC22 {
    public static int kthelement(int []a,int []b,int k)
    {
        int n1 = a.length;
        int n2 = b.length;
        if(n1>n2)
            return kthelement(b,a,k);
        int n = n1+n2;
        int left =k;
        int low =Math.max(0,k-n2);
        int high =Math.min(k,n1);
        int ans =0;
        while(low<=high)
        {
            int mid1 = low+(high-low)/2;
            int mid2 = left-mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1-1>=0)
                l1 = a[mid1-1];
            if(mid2-1>=0)
                l2 = b[mid2-1];
            if(mid1<n1)
                r1 = a[mid1];
            if(mid2<n2)
                r2 = b[mid2];
            if(l1<=r2 && l2<=r1)
            {
                return Math.max(l1,l2);
            }
            else if(l1>r2)
            {
                high = mid1-1;
            }
            else {

                low = mid1 + 1;
            }
        }
return -1;
    }
    public static void main(String[] args) {

       int [] a={5, 5 ,8, 8, 8, 9, 11, 11, 11, 11 ,11};
      int []b={4, 4, 4, 4, 6, 8, 9, 9, 9, 11, 13};
        System.out.println(kthelement(a,b,2));
    }
}
