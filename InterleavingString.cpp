#include "Utility.h"

class Solution 
{
public:
    bool isInterleave(string s1, string s2, string s3) 
    {
        int m = s1.size();
        int n = s2.size();
        if (m + n != s3.size())
        	return false; 
        if (m == 0)
        	return s2 == s3;
        if (n == 0)
        	return s1 == s3;
        vector<vector<bool> > res(m + 1, vector<bool>(n + 1, false));
        res[0][0] = true;
        for (int i = 1; i <= n; i++)
        {
        	res[0][i] = res[0][i - 1] && (s2[i - 1] == s3[i - 1]);
        }
        for (int i = 1; i <= m; i++)
        {
        	res[i][0] = res[i - 1][0] && (s1[i - 1] == s3[i - 1]);
        }

        for (int i = 1; i <= m; i++)
        {
        	for (int j = 1; j <= n; j++)
        	{
        		res[i][j] = (res[i - 1][j] && s1[i - 1] == s3[i + j - 1]) || (res[i][j - 1] && s2[j - 1] == s3[i + j - 1]);
        	}
        }
        return res[m][n];
    }
};

int main()
{
	string a = "a";
	string b = "b";
	string c = "ab";
	Solution ss;
	cout << ss.isInterleave(a, b, c) << endl;
	return 0;
}
