#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    vector<int> searchRange(int A[], int n, int target)
    {
    	vector<int> res;
    	res.push_back(-1);
    	res.push_back(-1);
    	if (A == NULL || n == 0)
    		return res;
    	int l = 0;
    	int r = n - 1;
    	int m;
    	while (l <= r)
    	{
    		m = (l + r) / 2;
    		if (target == A[m])
    		{
    			res[0] = m;
    			res[1] = m;
    			break;
    		}
    		if (target > A[m])
    			l = m + 1;
    		else 
    			r = m - 1;
    	}
    	if (A[m] != target)
    		return res;
    	int l1 = 0;
    	int l2 = m;
    	int m1;
    	while (l1 <= l2)
    	{
    		m1 = (l1 + l2) / 2;
    		if (A[m1] == target)
    			l2 = m1 - 1;
    		else
    			l1 = m1 + 1;
    	}
    	res[0] = l1;
    	l1 = m;
    	l2 = n - 1;
    	while (l1 <= l2)
    	{
    		m1 = (l1 + l2) / 2;
    		if (A[m1] == target)
    			l1 = m1 + 1;
    		else 
    			l2 = m1 - 1;
    	}
    	res[1] = l2;
    	return res;
    }
};

int main()
{
	return 0;
}