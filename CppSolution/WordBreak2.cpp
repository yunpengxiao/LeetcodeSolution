#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

class Solution 
{
private:
	void helper(string s, unordered_set<string> &dict, int start, string t, vector<string> &res)
	{
		if (start >= s.size())
		{
			res.push_back(t);
			return ;
		}

		string temp = "";
		for (int i = start; i < s.size(); i++)
		{
			temp += s[i];
			if (dict.find(temp) != dict.end())
			{
				string nextpass = t.size() > 0? t + ' ' + temp : t + temp;
				helper(s, dict, i + 1, nextpass, res);
			}
		}
	}
public:
    vector<string> wordBreak(string s, unordered_set<string> &dict) 
    {
    	vector<string> res;
    	if (dict.size() == 0 || s.size() == 0)
    		return res;
    	helper(s, dict, 0, "", res);
    	return res;
    }
};

int main()
{
	return 0;
}