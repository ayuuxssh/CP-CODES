package ayush.Graph;

import java.util.Arrays;

//Find the city with the smallest number
public class LEC43 {
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][]cost = new int[n][n];
        for(int []row:cost)
            Arrays.fill(row,(int)1e9);
        for(int []it:edges)
        {
            int u = it[0];
            int v =it[1];
            int w = it[2];

            cost[u][v]=w;
            cost[v][u]=w;
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                    cost[i][j]=0;

            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    cost[j][k]=Math.min(cost[j][k],cost[j][i]+cost[i][k]);
                }
            }
        }
        int city =-1;
        int countmax =n ;
        for(int i=0;i<n;i++)
        {
            int count =0;
            for(int j=0;j<n;j++)
            {
                if( cost[i][j]<=distanceThreshold)
                {
                    count++;
                }
            }
            if(count<=countmax)
            {
                countmax=count;
                city=i;
            }

        }
        return city;

    }
    public static void main(String[] args) {
int n = 4;
int [][]edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
int distanceThreshold = 4;
        System.out.println(findTheCity(n,edges,distanceThreshold));
    }
}
