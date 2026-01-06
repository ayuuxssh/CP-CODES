package ayush.Graph;

public class LEC49 extends DisjointSet {
    LEC49(int n)
    {
        super(n);
    }
    public static int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if(m<n-1)
            return -1;
        LEC49 ds = new LEC49(n);
        for(int [] it:connections)
        {
            int x =it[0];
            int y =it[1];
            ds.unionBySize(x,y);
        }
        int count =0;
        for(int i=0;i<n;i++)
        {
            if(ds.UltParent(i)==i)
                count++;
        }
        return count-1;
    }
    public static void main(String[] args) {
       int n = 4;
       int [][] connections = {{0,1},{0,2},{1,2}};
        System.out.println(makeConnected(n,connections));
    }
}
