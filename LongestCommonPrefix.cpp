#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) 
    {
    	string r;
        for (int i = 0; i < strs[0].size(); i++)
        {
        	for (int j = 1; j < strs.size(); j++)
        	{
        		if (i == strs[j].size()) return r;
        		if (strs[0][i] == strs[j][i])
        		{
        			re += strs[0][i];
        		}
        	}
        }
        return r;
    }
};
int main()
{
	return 0;
}