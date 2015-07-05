#include "Utility.h"

class Solution 
{
public:
    int longestConsecutive(vector<int> &num) 
    {
        if (num.size() < 2)
        	return num.size();
        int res = 0;
        int len;
        unordered_set<int> nums; 
        for (int i = 0; i < num.size(); i++)
        {
        	nums.insert(num[i]);
        }
        unordered_set<int> :: iterator it;
        while (!nums.empty())
        {
        	it = nums.begin();
        	len = 1;
        	nums.erase(it);
        	int i = *it;
        	while (nums.find(--i) != nums.end())
        	{
        		len++;
        		nums.erase(i);
        	}
        	i = *it;
        	while (nums.find(++i) != nums.end())
        	{
        		len++;
        		nums.erase(i);
        	}
        	if (len > res)
        		res = len;
        }
        return res;
    }
};

int main()
{
	return 0;
}