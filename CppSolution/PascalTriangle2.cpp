#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    vector<int> getRow(int rowIndex) 
    {
    	vector<int> res(rowIndex + 1);
    	res[0] = 1;
    	if (rowIndex == 0)
    		return res;    	
    	for (int i = 2; i <= rowIndex + 1; i++)
    	{
    		for (int j = i - 2; j > 0; j--)
    		{
    			res[j] += res[j - 1];
    		}
    		res[i - 1] = 1;
    	}
    	return res;
    }
};

int main()
{
	return 0;
}