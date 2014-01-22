#include <iostream>
using namespace std;


class Solution {
public:
    int lengthOfLastWord(const char *s) 
    {
    	if (s == NULL) return 0;
    	int m = 0;
    	while ('\0' != s[m])
    	{
    		m++;
    	}
    	if (m == 0) return 0;
    	int count = 0;
    	while (' ' == s[m - 1])
    	{
    		m--;
    	}
    	while ( m > 0 && ' ' != s[m - 1] )
    	{
    		count++;
    		m--;
    	}
    	return count;
    }
};

int main()
{
	Solution s;
	cout << s.lengthOfLastWord("") << endl;
	return 0;
}