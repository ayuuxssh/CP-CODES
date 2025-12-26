package ayush.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LEC39 {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
   public static int minimumMultiplications(int[] arr, int start, int end)
    {
        Queue<Pair>q= new LinkedList<>();
        int []dist = new int[(int)1e5];
        Arrays.fill(dist,(int)1e9);
        int mod =(int)1e5;
        dist[start]=0;
        q.add(new Pair(0,start));
        while(!q.isEmpty())
        {
            int steps = q.peek().first;
            int node = q.peek().second;
            q.remove();

            for(int it:arr)
            {
                int num =(node*it)%mod;
                if(steps+1<dist[num])
                {
                    dist[num]=steps+1;
                    if(num==end)
                        return steps+1;
                    q.add(new Pair(steps+1,num));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
      int []  arr ={2, 5, 7};
       int start = 3, end = 30;
        System.out.println(minimumMultiplications(arr,start,end));
    }
}
