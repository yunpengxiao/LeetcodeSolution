#include <iostream>
using namespace std;

class Solution 
{
public:
    bool canJump(int A[], int n) 
    {
    	if (n == 0)
    		return false;
    	if (n == 1)
    		return true;
    	int reach = 0;
    	for (int i = 0; i < n && i <= reach; i++)
    	{
    		reach = max(A[i] + i, reach);
    	}
    	if (reach >= n - 1)
    		return true;
    	return false;
    }
};

int main()
{
	return 0;
}