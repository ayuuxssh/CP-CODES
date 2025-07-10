package ayush.Binarrysearch;

public class LEC21 {
    //Brute Force
    //TC -O(N+M)
    //SC-0(M+M)
    public static double median(int []nums1,int []nums2)
    {
        int m = nums1.length;
        int n = nums2.length;
        int [] arr= new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while(i<m && j<n )
        {
            if(nums1[i]<nums2[j])
            {
                arr[k]= nums1[i];
                i++;
                k++;
            }
            else
            {
                arr[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<m)
        {
            arr[k] = nums1[i];
            i++;k++;
        }
        while(j<n)
        {
            arr[k]= nums2[j];
            j++;k++;
        }
        int s = m+n;
        if(s%2==1)
        {
            return (double) arr[s/2];
        }
        return (double) (arr[s/2]+arr[s/2-1])/2;
    }
    //SC-O(1)
    public static double median1(int [] nums1,int []nums2)
    {
        int m= nums1.length;
        int n = nums2.length;
        int s = m+n;

            int index2 = s/2;
        int i=0;
        int j=0;
        int count =0;
        int ele1=-1;
        int ele2=-1;
        while(i<m &&j<n) {
            if (nums1[i] < nums2[j]) {
                if (count == (index2 - 1))
                    ele1 = nums1[i];
                if (count == (index2))
                    ele2 = nums1[i];
                count++;
                i++;

            } else {
                if (count == (index2 - 1))
                    ele1 = nums2[j];
                if (count == (index2))
                    ele2 = nums2[j];
                count++;
                j++;
            }
        }
            while(i<m)
            {
                if(count==(index2-1))
                    ele1= nums1[i];
                if(count==(index2))
                    ele2= nums1[i];
                i++;count++;
            }
            while(j<n) {
                if (count == (index2 - 1))
                    ele1 = nums2[j];
                if (count == (index2))
                    ele2 = nums2[j];
                j++;
                count++;
            }
        if(s%2==1)
            return (double)(ele2);
        return (double)((double)ele1+ele2)/2;

    }
    //using binary search
    public static double median2(int []nums1,int[]nums2)
    {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        double ans =0;
        if(n1>n2)
            return median2(nums2,nums1);
        int low =0;
        int high = n1;
        int left =(n1+n2+1)/2;
        while(low<=high)
        {
            int mid =low+(high-low)/2;
            int mid2 =left-mid;
            int l1=Integer.MIN_VALUE;
            int l2 =Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid-1>=0)
                l1=nums1[mid-1];
            if(mid2-1>=0)
                l2=nums2[mid2-1];
            if(mid<n1)
                r1=nums1[mid];
            if(mid2<n2)
                r2 = nums2[mid2];
            if(l1<=r2 && l2<=r1)
            {
                if(n%2==1)
                {
                    ans = (double)Math.max(l1,l2);
                }
                else
                {
                    ans = (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
            }
            else if(l1>r2)
            {
                high = mid-1;
            }
            else
                low = mid+1;

        }
        return ans;
    }
    public static void main(String[] args) {
        int [] nums1 = {1,3};
        int [] nums2 = {2};
        System.out.println(median2(nums1,nums2));
    }
}
