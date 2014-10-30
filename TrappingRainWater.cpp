#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    int trap(int A[], int n) 
    {
        if (n == 0 || n == 1)
        	return 0;
        int maxs = 0;
        int res = 0;
        vector<int> maxhigh(n);
        for (int i = 0; i < n; i++)
        {
        	maxhigh[i] = maxs;
        	maxs = max(maxs, A[i]);
        }

        maxs = 0;
        for (int i = n - 1; i >= 0; i--)
        {
        	maxhigh[i] = min(maxs, maxhigh[i]);
        	maxs = max(maxhigh[i], A[i]);
        	res += maxhigh[i] > A[i]? maxhigh[i] - A[i] : 0;
        }
        return res;
    }
};

int main()
{
	return 0;
}