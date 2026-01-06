package ayush.Graph;

import java.util.*;
//Accounts Merge
public class LEC50 extends DisjointSet {
    LEC50(int n) {
        super(n);
    }
    public  static List<List<String>> accountsMerge(List<List<String>> accounts) {
            int n = accounts.size();
            LEC50 ds = new LEC50(n);
            HashMap<String,Integer> mp = new HashMap<>();

            for(int i=0;i<n;i++)
            {
                for(int j=1;j<accounts.get(i).size();j++)
                {
                    String mail = accounts.get(i).get(j);
                    if(!mp.containsKey(mail))
                    {
                        mp.put(mail,i);
                    }
                    else
                    {
                        ds.unionBySize(i,mp.get(mail));
                    }
                }
            }
            List<String>[]merge = new ArrayList[n];
            for(int i=0;i<n;i++)
            {
                merge[i]=new ArrayList<>();
            }
            for(Map.Entry<String,Integer>it:mp.entrySet())
            {
                String mail = it.getKey();
                int node = ds.UltParent(it.getValue());
                merge[node].add(mail);
            }
            List<List<String>>ans = new ArrayList<>();

            for(int i=0;i<n;i++)
            {
                if(merge[i].size()==0)
                    continue;
                Collections.sort(merge[i]);
                List<String>temp = new ArrayList<>();
                temp.add(accounts.get(i).get(0));

                for(String it:merge[i])
                {
                    temp.add(it);
                }

                ans.add(temp);
            }
            return ans;
        }

public static void main(String[] args) {
}
}
