#include <iostream>
using namespace std;

class Solution 
{
public:
    int sqrt(int x) 
    {
    	if (x == 1)
    		return 1;
    	int l = 1;
    	int r = x / 2 + 1;
    	while (l <= r)
    	{
    		int m = (l + r) / 2;
    		if (m <= x / m && x / (m + 1) < (m + 1))
    			return m;
    		if (x / m < m)
    			r = m - 1;
    		else
    			l = m + 1;
    	}
    }
};

int main()
{
	return 0;
}