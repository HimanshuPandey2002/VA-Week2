#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void hartal(int n, int p, int arr[])
{
    int days[n];
    
    for(int i=0; i<n; i++)  days[i]=0;
    
    for(int i=0; i<p; i++)
    {
        int x = arr[i];
        if(x > n)
            break;
        else
        {
            int k=-1;
            while(k<=n)
            {
                k += x;
                if(k%7!=5 && k%7!=6)
                {
                    days[k]=1;
                }
            }
        }
    }
    
    int count=0;
    for(int i=0; i<n; i++)
        count += days[i];
    
    cout << count<< endl;
}

int main() {
    int t;
    cin >> t;
    
    while(t--)
    {
        int n,p;
        cin >> n >> p;
        int arr[p];
        
        for(int i=0; i<p; i++)  cin >> arr[i];
        
        hartal(n, p, arr);
    }
    
    return 0;
}
