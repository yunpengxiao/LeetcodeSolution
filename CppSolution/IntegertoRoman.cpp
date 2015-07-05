//http://blog.csdn.net/havenoidea/article/details/11848921
#include <iostream>
using namespace std;

class Solution {
public:
    string intToRoman(int num) 
    {
    	string str;
        string tab[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int n[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int i = 0;
        while (num != 0)
        {
        	if (num >= n[i])
        	{
        		num -= n[i];
        		str += tab[i];
        	}
        	else i++;
        }
        return str;
    }
};

int main()
{

	return 0;
}