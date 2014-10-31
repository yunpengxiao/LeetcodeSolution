#include "Utility.h"

class Solution 
{
public:
    int findMin(vector<int> &num) 
    {
    	if (num.size() == 1)
    		return num[0];
    	int left = 0;
    	int right = num.size() - 1;
    	int mid;
    	while (left < right)
    	{
    		mid = (left + right) / 2;
    		if (num[mid] < num[right])
    			right = mid;
    		else if (num[mid] > num[right])
    			left = mid + 1;
    		else right--;
    	}
    	return num[right];
    }
};

int main()
{
	return 0;
}
