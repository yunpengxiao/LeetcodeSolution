#include <iostream>
using namespace std;

class Solution {
private:
	double power(double x, int n)
	{
		if (n == 0)
			return 1;
		else
		{
			double half = power(x, n / 2);
			if (n % 2 == 0)
				return half * half;
			else
				return half * half * x;
		}
	}
public:
    double pow(double x, int n) 
    {
        if (n < 0)
        	return 1 / power(x, -n);
        else 
        	return power(x, n);
    }
};

int main()
{
	return 0;
}