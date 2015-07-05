#include "Utility.h"

class Solution 
{
public:
    vector<vector<int> > subsetsWithDup(vector<int> &S) 
    {
    	vector<vector<int> > res;
    	if (S.size() == 0)
    		return res;
    	vector<int> p;
    	res.push_back(p);
    	sort(S.begin(), S.end());
    	int start = 0;
    	for (int i = 0; i < S.size(); i++)
    	{
    		cout << start << endl;
    		int size = res.size();
    		for (int j = start; j < size; j++)
    		{
    			vector<int> t(res[j]);
    			t.push_back(S[i]);
    			res.push_back(t);
    		}
    		if (i < S.size() - 1 && S[i] == S[i + 1])
    			start = size;
    		else
    			start = 0;
    	}
    	return res;
    }
};

int main()
{
	Solution ss;
	vector<int> s(5);
	for (int i = 0; i < 5; i++)
		s[i] = 5;
	ss.subsetsWithDup(s);
	return 0;
}