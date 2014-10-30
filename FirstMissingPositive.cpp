#include "Utility.h"

class Solution 
{
public:
    int firstMissingPositive(int A[], int n) 
    {
    	if (A == NULL || n == 0)
    		return 1;
    	for (int i = 0; i < n; i++)
    	{
    		if (A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i])
    		{
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
                i--;
    		}
    	}

    	for (int i = 0; i < n; i++)
    	{
    		if (A[i] != i + 1)
    			return i + 1;
    	}
    	return n + 1;
    }
};

int main()
{
	int A[2];
	A[0] = 2;
	A[1] = 1;
	Solution ss;
	ss.firstMissingPositive(A, 2);
	return 0;
}