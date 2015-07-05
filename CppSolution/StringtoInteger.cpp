#include <iostream>
#include <string>
#include <sstream>
using namespace std;

class Solution {
public:
    int atoi(const char *str) 
    {
        int start = 0;
        string r;
        //int pn = -1;
        for (int i = 0; str[i] != '\0'; i++)
        {
        	if (str[i] == '-' && start == 0)
        	{
        		start = -1;
        		r += '-';
        	}
        	else if (str[i] == '+' && start == 0)
        	{
        		start = 1;
        		r += '+';
        	}
        	else if (str[i] >= '0' && str[i] <= '9')
        	{
        		if (start == 0) start = 1;
        		r += str[i];
        	}
        	else if ((str[i] < '0' || str[i] > '9'))
        	{
        		if (str[i] == ' ' && start == 0) continue;
        		else break;
        	}
        }
        istringstream buffer(r);
        long long value = 0;
        buffer >> value;
        if (start == 0) return 0;
        if (r.size() == 1 && (r[0] < '0' || r[0] > '9')) return 0;
        if (value >= 2147483647) return 2147483647;
        else if (value <= -2147483648) return -2147483648;
        return value;

    }
};

int main()
{
	Solution s;
	cout << s.atoi("23a8f") << endl;
	return 0;
}