#include <iostream>
#include <algorithm>
#include <string>
#include <functional>
using namespace std;

class Solution {
public:
    bool isPalindrome(string s) 
    {
    	if (s.empty()) return true;
    	transform(s.begin(), s.end(), s.begin(), (int(*)(int))toupper);
    	//to_upper(s);
        string r;
        for (int i = 0; i < s.size(); i++)
        {
        	if ((s[i] >= 'A' && s[i] <= 'Z') ||(s[i] >= '0' && s[i] <= '9'))
        	{
        		r.push_back(s[i]);
        	}
        }
        int i = 0;
        int j = r.size() - 1;
        while (i < j)
        {
        	if (r[i] != r[j]) return false;
        	i++;
        	j--;
        }
        return true;
    }
};

int main()
{
	return 0;
}