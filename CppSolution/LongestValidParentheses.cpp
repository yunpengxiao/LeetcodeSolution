#include "Utility.h"

class Solution 
{
public:
    int longestValidParentheses(string s) 
    {
    	if (s.size() < 2)
    		return 0;
    	vector<int> st;
    	int start = 0;
    	int maxs = 0;
    	for (int i = 0; i < s.size(); i++)
    	{
    		if (s[i] == '(')
    			st.push_back(i);
    		else
    		{
    			if (st.size() == 0)
    			{
    				start = i + 1;
    			}
    			else
    			{
    				st.pop_back();
    				maxs = st.size() == 0? max(maxs, i - start + 1) : max(maxs, i - st[0]);
    			}
    		}
    		
    	}
    	return maxs;
    }
};

int main()
{
	return 0;
}