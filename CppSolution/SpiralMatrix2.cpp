#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    vector<vector<int> > generateMatrix(int n) 
    {
        vector<vector<int> > res;
        if (n <= 0)
        	return res;
        for (int i = 0; i < n; i++)
        {
        	vector<int> t;
        	for (int j = 0; j < n; j++)
        	{
        		t.push_back(0);
        	}
        	res.push_back(t);
        }
        int v = 1;
        int x = 0, y = 0;
        int count = n;
        while (count > 0)
        {
        	if (count == 1)
        		res[x][y] = v;
        	else
        	{
        		for (int i = 0; i < count - 1; i++)
        			res[x][y++] = v++;
        		for (int i = 0; i < count - 1; i++)
        			res[x++][y] = v++;
        		for (int i = 0; i < count - 1; i++)
        			res[x][y--] = v++;
        		for (int i = 0; i < count - 1; i++)
        			res[x--][y] = v++;
        		x++;
        		y++;
        	}
        	count = count - 2;
        }
        return res;
    }
};

int main()
{
	return 0;
}
