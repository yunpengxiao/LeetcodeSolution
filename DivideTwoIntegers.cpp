#include <iostream>
#include <cmath>
using namespace std;

class Solution {
private:
    int div(unsigned int dividend, unsigned int divisor)
    {
        if (divisor == dividend) return 1;
        if (divisor > dividend) return 0;
        int result = 1;
        unsigned int t = divisor;
        while (t < dividend)
        {
            t = t << 1;
            if (t <= dividend) result = result << 1;
            if (t == dividend) return result;
        }
        t = t >> 1;
        return result + div(dividend - t, divisor);
    }
public:
    int divide(int dividend, int divisor) 
    {
        if (dividend == 0) return 0;
        unsigned int divd = abs(dividend);
        unsigned int divr = abs(divisor);
        int result = div(divd, divr);
        if (dividend > 0 && divisor < 0) return -result;
        if (dividend < 0 && divisor > 0) return -result;
        else return result;
    }
};

int main()
{
    Solution s;
    cout << s.divide(-1010369383, -2147483648) << endl;
	return 0;
}