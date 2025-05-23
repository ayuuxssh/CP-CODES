#include<bits/stdc++.h>
using namespace std;
int main()
{
    vector<int>v = {1,2,2,3,2,3,2};
    int cnt=0;
    int ele;
    for(int i =0;i<v.size();i++)
    {
        if(cnt ==0)
        {
            cnt++;
            ele = v[i];
        }
        else if(v[i]==ele)
        {
            cnt++;
        }
        else
        {
            cnt--;
        }
    }
    int count =0;
    for(int i =0;i<v.size();i++)
    {
        if(v[i]==ele)
        {
            count++;
        }
    }
    if(count>(v.size()/2))
    {
        cout<<ele<<"\n";
    }
    return 0;
}