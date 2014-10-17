#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    int findMin(vector<int> &num) 
    {
    	int s = num.size();
    	if (s == 1)
    		return num[0];
    	int l = 0;
    	int r = s - 1;
    	int m;
    	while (l < r)
    	{
    		m = (l + s) / 2;
    		cout << m << endl;
    		if (num[m] < num[r])
    			r = m;
    		else
    			l = m + 1;
    	}
    	cout << r << endl;
    	return num[r];
    }
};

int main()
{
	Solution s;
	vector<int> num(2);
	num[0] = 1;
	num[1] = 2;
	cout << s.findMin(num) << endl;
	return 0;
}