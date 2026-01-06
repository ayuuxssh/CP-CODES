package ayush.Graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer>parent= new ArrayList<>();
    List<Integer> Rank = new ArrayList<>();
    List<Integer>Size = new ArrayList<>();
    DisjointSet(int n)
    {
        for(int i=0;i<=n;i++)
        {
            parent.add(i);
            Rank.add(0);
            Size.add(1);
        }
    }

    public int UltParent(int node)
    {
        if(node ==parent.get(node))
        {
            return node;
        }
        int no = UltParent(parent.get(node));
        parent.set(node,no);
        return parent.get(node);
    }
    public void unionByRank(int u,int v)
    {
        int pu = UltParent(u);
        int pv = UltParent(v);
        if(pu == pv)
        {
            return;
        }
         if(Rank.get(pu)<Rank.get(pv))
         {
             parent.set(pu,pv);
         }
       else if(Rank.get(pu)>Rank.get(pv))
        {
            parent.set(pv,pu);
        }
       else
         {
             parent.set(pv,pu);
             int ranku = Rank.get(pu);
             Rank.set(pu,ranku+1);
         }
    }
    public void unionBySize(int u,int v)
    {
        int pu = UltParent(u);
        int pv = UltParent(v);
        if(pu==pv)
            return ;
        if(Size.get(pu)<Size.get(pv))
        {
            parent.set(pu,pv);
            int size=Size.get(pv);
            Size.set(pv,Size.get(pu)+size);
        }
      else  if(Size.get(pu)>Size.get(pv))
        {
            parent.set(pv,pu);
            int size=Size.get(pu);
            Size.set(pu,Size.get(pv)+size);
        }
      else
        {
            parent.set(pv,pu);
            int size=Size.get(pu);
            Size.set(pu,Size.get(pv)+size);
        }
    }
}
class Main{
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(8);
//        ds.unionByRank(1,2);
//        ds.unionByRank(2,3);
//        ds.unionByRank(4,5);
//        ds.unionByRank(6,7);
//        ds.unionByRank(5,6);
//        if(ds.UltParent(3)==ds.UltParent(7))
//        {
//            System.out.println("Yes");
//        }
//        else
//        {
//            System.out.println("No");
//        }
//      ds.unionByRank(3,7);
//        if(ds.UltParent(3)==ds.UltParent(7))
//        {
//            System.out.println("Yes");
//        }
//        else
//        {
//            System.out.println("No");
//        }

        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);
        if(ds.UltParent(3)==ds.UltParent(7))
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
        ds.unionBySize(3,7);
        if(ds.UltParent(3)==ds.UltParent(7))
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }

    }
}
