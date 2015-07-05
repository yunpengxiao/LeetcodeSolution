#include <iostream>
#include <string>
#include <cstring>
using namespace std;

class Solution {
private:
	//string re;
	//int max;
	//int start, end;
	/*string fitinstring(string s)
	{
		string re;
		re += "$#";									//Adding an $ at first can handle the edge case
		for (int i = 0; i < s.size(); i++)
		{
			re = re + s[i] + '#';
		}
		re += '^';									//Adding this is the same reason as above
		cout << re << endl;
		return re;
	}*/
public:
	/*string longestPalindrome(string s)            //Solution of O(n), it works!!
    {
    	int p[2005];
    	int c, r, max, poi;
    	string str = fitinstring(s);
    	memset(p, 0, sizeof(p));
    	c = 1;
    	r = 1;
    	p[0] = 0;
    	p[1] = 0;
    	for (int i = 2; i < str.size(); i++)
    	{
    		//mirro = 2 * c - i;
    		if (i > r)
    		{
    			p[i] = 1;
    		}
    		else
    		{
    			p[i] = min(r - i, p[2 * c - i]);
    		}
    		while (str[i + p[i]] == str[i - p[i]]) p[i]++;
    		if ((i + p[i]) > r)
    		{
    			c = i;
    			r = i + p[i];
    		}
    	}
    	max = 0;
    	poi = 0;
    	for (int i = 0; i < str.size(); i++)
    	{
    		if (p[i] > max) 
    		{
    			max = p[i];
    			poi = i;
    		}
    	}
    	return s.substr((poi - max) / 2, max - 1);
    }*/

    string longestPalindrome(string s)       			//this solution uses dynamic programming using two demison 
	{	
		bool dp[1001][1001];												//array dp[i][j]to store weather this substring is a palindrome 
    	if (s.size() == 1) return s;
    	//memset(dp, 0, sizeof(dp));					//or not. It depends on dp[i + 1][j - 1] and if s[i] == s[j]
    	int max = 0;										//I got Time Limit Exceeded for this solution on leetcode.
    	int start = 0; 
        /*for (int i = 0; i < s.size(); i++)			
        {
        	for (int j = 0; j < s.size(); j++)
        	{
        		if (i >= j) dp[i][j] = true;
        	}
        }*/
        for (int i = 0; i < s.size(); i++)
        {
        	dp[i][i] = true;
        }
        for (int i = 0; i < s.size() - 1; i++)
        {
        	dp[i][i + 1] = (s[i] == s[i + 1]);
        	if (dp[i][i + 1]) 
        	{
        		max = 2;
        		start = i;
        	}
        }
        for (int j = 1; j < s.size(); j++)
        {
        	for (int i = 0; i < j - 1; i++)
        	{
        		if (s[i] == s[j])
        		{
        			dp[i][j] = dp[i + 1][j - 1];
        			if (dp[i][j] == true && (j - i + 1) > max)
        			{
        				max = j - i + 1;
        				start = i;
        			}
        		}
        		else  dp[i][j] = false;
        	}
        }
        return s.substr(start, max);
    }

};

int main()
{
	string t = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	Solution s;
	cout << s.longestPalindrome(t).size() << endl;
	return 0;
}
