#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
private:
	vector<string> res;
	void helper(string s, string prefix, int segment)
	{
		string subStr;
		if (segment == 3 && isValid(s))
		{
			res.push_back(prefix + s);
			return ;
		}
		for (int i = 1; i < 4 && i <= s.length(); i++)
		{
			subStr = s.substr(0, i);
			if (isValid(subStr))
			{
				helper(s.substr(i), prefix + subStr + '.', segment + 1);
			}
		}
	}

	bool isValid(string s)
	{
		if (s[0] == '0')
			return s == "0";
		int value = atoi(s.c_str());
		return value <= 255 && value > 0;
	}
public:
    vector<string> restoreIpAddresses(string s) 
    {
    	if (s.size() < 4 || s.size() > 12)
    		return res;
    	helper(s, "", 0);
    	return res;
    }
};

int main()
{

	return 0;
}