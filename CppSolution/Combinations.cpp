#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
private:
	vector<vector<int> > res;
	void helper(int n, int k, int s, vector<int> a)
	{
		if (a.size() == k)
		{
			res.push_back(a);
			return;
		}
		for (int i = s; i <= n; i++)
		{
			a.push_back(i);
			helper(n, k, i + 1, a);
			a.pop_back();
		}
	}
public:
    vector<vector<int> > combine(int n, int k) 
    {
        vector<int> a;
        if (n < k) return res;
        helper(n, k, 1, a);
        return res;
    }
};

int main()
{
	return 0;
}
