#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string convert(string s, int nRows) 
    {
    	if (nRows == 1) return s;
    	string re;
    	int blank = nRows * 2 - 2;
    	int index;
    	for (int i = 0; i < nRows; i++) 
    	{
    		index = i;
    		while (index < s.size())
    		{
    			re += s[index];
    			index += blank;
    			if (i != 0 && i != nRows - 1 && (index - 2 * i) < s.size())
    			{
    				re += s[index - 2 * i];
    			}
    		}
    	}  
    	return re; 
    }
};

int main()
{
	Solution s;
	cout << s.convert("PAYPALISHIRING", 3) << endl;
	return 0;
}