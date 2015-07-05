#include "Utility.h"

class Solution 
{
public:
    vector<vector<int> > subsets(vector<int> &S) 
    {
    	vector<vector<int> > res;
    	if (S.size() == 0)
    		return res;
    	vector<int> p;
    	res.push_back(p);
    	sort(S.begin(), S.end());
    	for (int i = 0; i < S.size(); i++)
    	{
    		int size = res.size();
    		for (int j = 0; j < size; j++)
    		{
    			vector<int> t(res[j]);
    			t.push_back(S[i]);
    			res.push_back(t);
    		}
    	}
    	return res;
    }
};

int main()
{
	return 0;
}
