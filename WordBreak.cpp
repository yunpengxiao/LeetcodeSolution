#include <iostream>
#include <unordered_set>
#include <vector>
using namespace std;

class Solution 
{
public:
    bool wordBreak(string s, unordered_set<string> &dict) 
    {
        if (s.size() == 0)
        	return true;
        if (dict.size() == 0)
        	return false;
        vector<bool> res(s.size() + 1, false);
        res[0] = true;
        string st;
        for (int i = 1; i <= s.size(); i++)
        {
        	for (int j = 0; j < i; j++)
        	{
        		st = s.substr(j, i - j);
        		if (res[j] && dict.find(st) != dict.end())
        		{
        			res[i] = true;
        			break;
        		}
        	}
        }
        return res[s.size()];
    }
};

int main()
{
	unordered_set<string> dict;
	dict.insert("a");
	string s = "a";
	Solution ss;
	cout << ss.wordBreak(s, dict) << endl;
	return 0;
}