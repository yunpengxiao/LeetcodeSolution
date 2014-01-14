#include <iostream>
using namespace std;

class Solution 
{
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
        while (digit != 0)
        {
        	
        }
    }
};
int main()
{
	return 0;
}
