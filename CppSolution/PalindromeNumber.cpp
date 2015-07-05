#include <iostream>
using namespace std;

class Solution 
{
private:
    int pow(int n, int m)
    {
        int sum = 1;
        if (m == 0) return 1;
        for (int i = 0; i < m; i++)
        {
            sum *= n;
        }
        return sum;
    }
public:
    bool isPalindrome(int x) 
    {
        if (x < 0) return false;
        if (x / 10 == 0) return true;
        int digit = 0;
        int t = x;
        int first, last;
        while (t != 0)
        {
        	//t = t - pow( )
        	digit++;
        	t = t / 10;
        }
        t = x;
        while (digit > 0)
        {
        	first = t / pow(10, digit - 1);
            last = t % 10;
            if (first != last) return false;
            t = t % pow(10, digit - 1);
            t = (t - last) / 10;
            digit -= 2;
        }
        return true;
    }
};
int main()
{
	return 0;
}
