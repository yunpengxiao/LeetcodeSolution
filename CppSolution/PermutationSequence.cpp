#include "Utility.h"

class Solution 
{
public:
    string getPermutation(int n, int k) 
    {
        if (n <= 0)
        	return "";
        string res = "";
        vector<int> num;
        int factor = 1;
        for (int i = 1; i < n; i++)
        {
        	factor *= i;
        	num.push_back(i);
        }
        num.push_back(n);
        int index;
        int round = n - 1;
        k--;
        while (round >= 0)
        {
        	index = k / factor;
        	k = k % factor;
        	res += num[index] + '0';
        	num.erase(num.begin() + index);
        	if (round == 0)
        		break;
        	factor = factor / round;
        	round--;
        }
        return res;
    }
};

int main()
{
	Solution ss;
	cout << ss.getPermutation(1, 1) << endl;
	return 0;
}