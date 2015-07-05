#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    vector<vector<int> > generate(int numRows) 
    {
    	vector<vector<int> > res;
    	if (numRows == 0)
    		return res;
    	vector<int> pre;
    	pre.push_back(1);
    	res.push_back(pre);
    	int t1, t2;
    	if (numRows == 1)
    		return res;
    	for (int i = 2; i <= numRows; i++)
    	{
    		vector<int> t;
    		t.push_back(1);
    		for (int j = 1; j < i - 1; j++)
    		{
    			t1 = pre[j - 1];
    			if (pre.size() < j + 1)
    				t2 = 0;
    			else
    				t2 = pre[j];
    			t.push_back(t1 + t2);
    		}
    		t.push_back(1);
    		pre = t;
    		res.push_back(pre);
    	}
    	return res;
    }
};

int main()
{
	return 0;
}