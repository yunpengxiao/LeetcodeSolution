#include <iostream>
using namespace std;

class Solution 
{
public:
    bool search(int A[], int n, int target) 
    {
    	if (n == 0)
    		return false;
    	int l = 0;
    	int r = n - 1;
    	int m;
    	while (l <= r)
    	{
    		m = (l + r) / 2;
    		if (A[m] == target)
    			return true;
    		if (A[m] > A[r])
    		{
    			if (A[m] > target && A[l] <= target)
    				r = m - 1;
    			else 
    				l = m + 1;
    		}
    		else if (A[m] < A[r])
    		{
    			if (A[m] < target && A[r] >= target)
    				l = m + 1;
    			else
    				r = m - 1;
    		}
    		else
    			r--;
    	}
    	return false;

    }
};

int main()
{
	return 0;
}