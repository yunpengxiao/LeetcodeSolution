#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution 
{
private:
	vector<vector<int> > res;
	void helper(vector<int> c, int target, vector<int> &candidates, int s)
	{
		if (target == 0)
		{
			res.push_back(c);
			return;
		}
		if (target < 0)
			return;
		for (int i = s; i < candidates.size(); i++)
		{
			if (i > 0 && candidates[i] == candidates[i - 1])
				continue;
			c.push_back(candidates[i]);
			helper(c, target - candidates[i], candidates, i);
			c.pop_back();
		}
	}
public:
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) 
    {
    	vector<int> t;
    	sort(candidates.begin(), candidates.end());
    	helper(t, target, candidates, 0);
    	return res;
    }
};

int main()
{
	return 0;
}
