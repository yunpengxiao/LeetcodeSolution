#include "Utility.h"

class Solution 
{
public:
    void nextPermutation(vector<int> &num) 
    {
    	int start = num.size() - 1;
    	if (start < 1)
    		return ;
    	while (start > 0 && num[start - 1] > num[start])
    		start--;
    	if (start == 0)
    	{
    		sort(num.begin(), num.end());
    		return ;
    	}
    	int minlarge = num[start - 1];
    	int pos = start - 1;
    	for (int i = start - 1; i < num.size(); i++)
    	{
    		if (num[i] < minlarge && num[i] > num[start])
    		{
    			minlarge = num[i];
    			pos = i;
    		}
    	}
    	int t = num[start - 1];
    	num[start - 1] = num[pos];
    	num[pos] = t;
    	sort(num.begin() + start, num.end());
    }
};

int main()
{
	return 0;
}
