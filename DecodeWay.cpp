#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution 
{
public:
    int numDecodings(string s) 
    {
    	int m = s.size();
    	if (m == 0 || s[0] == '0')
    		return 0;
    	int pre = 1;
    	int prere = 1;
    	int cur = 1;
    	for (int i = 1; i < m; i++)
    	{
    		if (s[i] == '0')
    		{
    			if (s[i - 1] == '1' || s[i - 1] == '2') 
    				cur = prere;
    			else
    				return 0;
    		}
    		else
    		{
    			if (s[i - 1] == '0' || s[i - 1] >= '3')
    				cur = pre;
    			else
    			{
    				if (s[i - 1] == '2' && s[i] >= '7' && s[i] <= '9')
    					cur = pre;
    				else
    					cur = pre + prere;
    			}
    		}
    		prere = pre;
    		pre = cur;
    	}
    	return cur;
    }
};

int main()
{
	return 0;
}