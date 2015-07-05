#include "Utility.h"

class Solution 
{
public:
    string multiply(string num1, string num2) 
    {
    	if (num1 == "0" || num2 == "0")
    		return "0";
    	string res(num1.size() + num2.size() + 1, '0');
    	reverse(num1.begin(), num1.end());
    	reverse(num2.begin(), num2.end());
    	int carry;
    	int exist;
    	int digit1;
    	int digit2;
    	int result;
    	for (int i = 0; i < num1.size(); i++)
    	{
    		digit1 = num1[i] - '0';
    		carry = 0;
    		for (int j = 0; j < num2.size(); j++)
    		{
    			digit2 = num2[j] - '0';
    			exist = res[i + j] - '0';
    			result = (digit1 * digit2 + carry + exist);
    			res[i + j] = result % 10 + '0';
    			carry = result / 10;
    		}
    		if (carry > 0)
    		{
    			res[i + num2.size()] = carry + '0';
    		}
    	}
    	reverse(res.begin(), res.end());
    	int ii = 0;
    	while (ii < res.size() && res[ii] == '0')
    		ii++;
    	return res.substr(ii, res.size() - ii);
    }
};

int main()
{
	return 0;
}