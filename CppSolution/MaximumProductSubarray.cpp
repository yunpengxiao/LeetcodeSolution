#include <iostream>
using namespace std;

class Solution 
{
public:
    int maxProduct(int A[], int n) 
    {
    	if (n == 0)
    		return 0;
    	if (n == 1)
    		return A[0];
    	int localmax = A[0];
    	int localmin = A[0];
    	int global = A[0];
    	for (int i = 1; i < n; i++)
    	{
    		int t = localmax;
    		localmax = max(max(A[i], t * A[i]), localmin * A[i]);
    		localmin = min(min(A[i], t * A[i]), localmin * A[i]);
    		global = max(global, localmax);
    	}
    	return global;
    }
};

int main()
{
	return 0;
}