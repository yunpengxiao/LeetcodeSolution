#include <iostream>
#include <sstream>
using namespace std;

class Solution {
public:
    int reverse(int x) 
    {
    	if (x == 0) return x;
        int n = (x > 0)? x: -x;
        string t;
        while (n != 0)
        {
        	t += n % 10 + '0';
        	n = n / 10;
        }
        istringstream buffer(t);
        int value;
        buffer >> value;
        return (x > 0)? value: -value;
    }
};

int main()
{
	Solution s;
	cout << s.reverse(-123) << endl;
	return 0;
}