#include <iostream>
using namespace std;

class Solution 
{
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) 
    {
    	if (matrix.size() == 0)
    		return false;
    	int size = matrix.size();
    	int l = 0;
    	int r = size - 1;
    	int m;
    	while (l <= r)
    	{
    		m = (l + r) / 2;
    		if (matrix[m][0] == target)
    			return true;
    		else if (matrix[m][0] > target)
    			r = m - 1;
    		else
    			l = m + 1;
    	}
    	int row = r;
    	if (r < 0)
    		return false;
    	l = 0;
    	r = matrix[0].size() - 1;
    	while (l <= r)
    	{
    		m = (l + r) / 2;
    		if (matrix[row][m] == target)
    			return true;
    		else if (matrix[row][m] > target)
    			r = m - 1;
    		else
    			l = m + 1;
    	}
    	return false;
    }
};

int main()
{
	return 0;
}