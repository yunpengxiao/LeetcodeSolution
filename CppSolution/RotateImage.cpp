#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    void rotate(vector<vector<int> > &matrix) 
    {
    	if (matrix.size() == 0 || matrix[0].size() == 0)
    		return ;
    	int first;
    	int last;
    	int temp;
    	int n = matrix.size();
    	for (int i = 0; i < n / 2; i++)
    	{
    		first = i;
    		last = n - 1 - i;
    		for (int j = first; j < last; j++)
    		{
    			int offset = j - first;
    			temp = matrix[first][j];
    			matrix[first][j] = matrix[last - offset][first];
    			matrix[last - offset][first] = matrix[last][last - offset];
    			matrix[last][last - offset] = matrix[j][last];
    			matrix[j][last] = temp;
    		}
    	}
    }
};

int main()
{
	return 0;
}