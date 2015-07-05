#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution 
{
private:
	int tmin(int a, int b, int c)
	{
		if (a > b)
			return b > c? c : b;
		else
			return b < c? a : (a > c? c : a);
	}
public:
    int minDistance(string word1, string word2) 
    {
    	int m = word1.size();
    	int n = word2.size();
    	if (m == 0) return n;
    	if (n == 0) return m;
    	vector<int> pre(n + 1);
    	vector<int> cur(n + 1);
    	for (int i = 0; i <= n; i++)
    		pre[i] = i;
    	for (int i = 1; i <= m; i++)
    	{
    		cur[0] = i;
    		for (int j = 1; j <= n; j++)
    		{
    			int d = (word1[i - 1] == word2[j - 1])? 0 : 1;
    			cur[j] = tmin(pre[j] + 1, cur[j - 1] + 1, pre[j - 1] + d);
    		}
    		for (int j = 0; j <= n; j++)
    			pre[j] = cur[j];
    	}
    
    	return cur[n];
    }
};

int main()
{
	Solution s;
	s.minDistance("a", "b");
	return 0;
}