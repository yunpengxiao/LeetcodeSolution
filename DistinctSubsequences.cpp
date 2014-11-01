#include "Utility.h"

class Solution 
{
public:
    int numDistinct(string S, string T) 
    {
    	if (S == T)
    		return 1;
    	int m = S.size();
    	int n = T.size();
    	vector<vector<int> > res(m + 1, vector<int>(n + 1, 0));
    	res[0][0] = 1;
    	for (int i = 1; i <= m; i++)
    	{
    		res[m][0] = 1;
    	}

    	for (int i = 1; i <= n; i++)
    	{
    		res[0][n] = 0;
    	}

    	for (int i = 1; i <= m; i++)
    	{
    		for (int j = 1; j <= n; j++)
    		{
    			res[i][j] = S[i - 1] == T[j - 1]? res[i - 1][j - 1] + res[i - 1][j] : res[i - 1][j];
    		}
    	}
    	return res[m][n];
    }
};

int main()
{
	return 0;
}