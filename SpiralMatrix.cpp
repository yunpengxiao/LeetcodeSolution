#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
private:
	vector<int> res;
	void helper(vector<vector<int> > &matrix, int m, int n, int k)
	{
		if (m <=0 || n <= 0)
			return ;
		if (m == 1)
		{
			for (int i = 0; i < n; i++)
				res.push_back(matrix[k][k + i]);
			return;
		}
		if (n == 1)
		{
			for (int i = 0; i < m; i++)
				res.push_back(matrix[k + i][k]);
			return;
		}
		for (int i = 0; i < n - 1; i++)
			res.push_back(matrix[k][k + i]);
		for (int i = 0; i < m - 1; i++)
			res.push_back(matrix[k + i][k + n - 1]); // we can see here the column is the last element in the previous loop 
		for (int i = 0; i < n - 1; i++)
			res.push_back(matrix[k + m - 1][n + k - 1 - i]);
		for (int i = 0; i < m - 1; i++)
			res.push_back(matrix[k + m - 1 - i][k]);

		helper(matrix, m - 2, n - 2, k + 1);
	}
public:
    vector<int> spiralOrder(vector<vector<int> > &matrix) 
    {
    	if (matrix.size() == 0 || matrix[0].size() == 0)
    		return res;
    	int m = matrix.size();
    	int n = matrix[0].size();
    	helper(matrix, m, n, 0);
    	return res;
    }
};

int main()
{
	return 0;
}