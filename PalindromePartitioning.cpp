#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

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
	void helper(string s, vector<vector<bool> > &dict, int start, vector<string> item, vector<vector<string> > &res)
	{
		if (start >= s.size())
		{
			res.push_back(item);
			return ;
		}

		for (int i = start; i < s.size(); i++)
		{
			if (dict[start][i])
			{
				item.push_back(s.substr(start, i - start + 1));
				helper(s, dict, i + 1, item, res);
				item.pop_back();
			}
		}
	}
public:	
    vector<vector<string> > partition(string s) 
    {
    	vector<vector<string> > res;
    	vector<string> item;
    	vector<vector<bool> > dict = getdict(s);
    	if (dict.size() == 0 || s.size() == 0)
    		return res;
    	helper(s, dict, 0, item, res);
    	return res;
    }
};

int main()
{
	return 0;
}