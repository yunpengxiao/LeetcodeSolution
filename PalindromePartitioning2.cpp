#include "Utility.h"

class Solution 
{
private:
	vector<vector<bool> > getdict(string s)
	{
		vector<vector<bool> > dict(s.size(), vector<bool>(s.size(), false));
		for (int i = s.size() - 1; i >= 0; i--)
		{
			for (int j = i; j < s.size(); j++)
			{
				if (s[i] == s[j] && ((j - i) < 2 || dict[i + 1][j - 1]))
					dict[i][j] = true;
			}
		}
		return dict;
	}
public:
    int minCut(string s) 
    {
    	if (s.size() == 0)
    		return 0;
    	vector<vector<bool> > dict = getdict(s);
    	vector<int> res(s.size() + 1);
    	res[0] = 0;
    	for (int i = 0; i < s.size(); i++)
    	{
    		res[i + 1] = i + 1;
    		for (int j = 0; j <= i; j++)
    		{
    			if (dict[j][i])
    			{
    				res[i + 1] = min(res[i + 1], res[j] + 1);
    			}
    		}
    	}
    	return res[s.size()];
    }
};

int main()
{
	return 0;
}