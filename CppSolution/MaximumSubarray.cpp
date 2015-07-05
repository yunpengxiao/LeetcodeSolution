#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    int maxSubArray(int A[], int n) 
    {
    	if (n == 0)
    		return 0;
    	int local = A[0];
    	int global = A[0];
    	for (int i = 1; i < n; i++)
    	{
    		local = max(A[i], local + A[i]);
    		global = max(local, global);
    	}
    	return global;
    }
};

int main()
{
	return 0;
}