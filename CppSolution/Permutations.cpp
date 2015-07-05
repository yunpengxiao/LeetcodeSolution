#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
private:
	vector<vector<int> > res;
	void helper(vector<int> t, vector<int> num, vector<bool> used)
	{
		if (t.size() == num.size())
		{
			res.push_back(t);
			return ;
		}
			

		for (int i = 0; i < num.size(); i++)
		{
			if (used[i] == true)
				continue;
			used[i] = true;
			t.push_back(num[i]);
			helper(t, num, used);
			t.pop_back();
			used[i] = false;
		}
	}
public:
    vector<vector<int> > permute(vector<int> &num) 
    {
    	vector<int> t;
    	vector<bool> used(num.size());
    	helper(t, num, used);
    	return res;
    }
};

int main()
{
	return 0;
}