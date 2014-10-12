#include <iostream>
using namespace std;

class Solution 
{
public:
    int search(int A[], int n, int target) 
    {
    	if (n == 0)
    		return -1;
    	int l = 0;
    	int r = n - 1;
    	int m;
    	while (l <= r)
    	{
    		m = (l + r) / 2;
    		if (A[m] == target)
    			return m;
    		else if (A[m] < A[r])
    		{
    			if (target >= A[m] && target < A[r])
    				l = m + 1;
    			else
    				r = m - 1;
    		}
    		else
    		{
    			if (target >= A[l] && target < A[m])
    				r = m - 1;
    			else 
    				l = m + 1;
    		}
    	}
    	return -1;
    }
};

int main()
{
	return 0;
}