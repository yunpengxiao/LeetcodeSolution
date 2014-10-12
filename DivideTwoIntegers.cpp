#include <iostream>
#include <cmath>
using namespace std;

class Solution {
public:
    int divide(int dividend, int divisor) 
    {
        if (divisor == 0)
            return INT_MAX;
        bool isNeg = ((dividend^divisor) >> 31 == 1);
        int res;

        dividend = abs(dividend);
        divisor = abs(divisor);
        int digit = 0;
        while (divisor <= (dividend >> 1))
        {
            divisor = divisor << 1;
            digit++;
        }
        while (digit > 0)
        {
            if (dividend >= divisor)
            {
                dividend -= divisor;
                res += 1 << digit;                
            }
            divisor = divisor >> 1;
            digit--;
        }
        return isNeg? -res: res;
    }
};

int main()
{
    Solution s;
    cout << s.divide(12, 4) << endl;
	return 0;
}