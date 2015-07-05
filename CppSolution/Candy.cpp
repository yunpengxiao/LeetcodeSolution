#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    int candy(vector<int> &ratings) 
    {
    	int m = ratings.size();
    	if (m == 0)
    		return 0;
    	vector<int> dp(m);
    	dp[0] = 1;
    	for (int i = 1; i < m; i++)
    	{

    		if (ratings[i] > ratings[i - 1])
    			dp[i] = dp[i - 1] + 1;
    		else
    			dp[i] = 1;
    	}
    	int res = dp[m - 1];
    	int t;
    	for (int i = m - 2; i >= 0; i--)
    	{
    		t = 1;
    		if (ratings[i] > ratings[i + 1])
    		{
    			t = dp[i + 1] + 1;
    		}
    		res += max(dp[i], t);
    		dp[i] = t;
    	}
    	return res;
    }
};

int main()
{
	Solution ss;
	vector<int> a;
	a.push_back(2);
	a.push_back(2);
	cout << ss.candy(a)<< endl;
	return 0;
}