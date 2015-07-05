#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) 
    {
    	if (obstacleGrid.size() == 0 || obstacleGrid[0].size() == 0)
    		return 0;
    	vector<int> res(obstacleGrid.size());
    	res[0] = 1;
    	for (int i = 0; i < obstacleGrid[0].size(); i++)
    	{
    		for (int j = 0; j < obstacleGrid.size(); j++)
    		{
    			if (obstacleGrid[j][i] == 1)
    				res[j] = 0;
    			else if (j > 0)
    				res[j] += res[j - 1];
    		}
    	}
    	return res[obstacleGrid.size() - 1];
    }
};

int main()
{
	return 0;
}