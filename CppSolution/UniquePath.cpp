#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    int uniquePaths(int m, int n) 
    {
    	if (m == 0 || n == 0)
    		return 0;
    	if (m == 1 || n == 1)
    		return 1;
    	vector<int> pre(m);
    	vector<int> cur(m);
    	pre[0] = 0;
    	for (int i = 1; i < m; i++)
    		pre[i] = 1;
    	for (int i = 1; i < n; i++)
    	{
    		cur[0] = 1;
    		for (int j = 1; j < m; j++)
    		{
    			cur[j] = pre[j] + cur[j - 1];
    			pre[j] = cur[j];
    		}
    	}
    	return cur[m - 1];
    }
};

int main()
{
	return 0;
}