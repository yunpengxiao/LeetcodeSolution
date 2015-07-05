#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int maxArea(vector<int> &height) 
    {
    	int max = 0;
    	int i = 0;
    	int j = height.size() - 1;
    	while (i != j)
    	{
    		if (height[i] > height[j])
    		{
    			if ((j - i) * height[j] > max) max = (j - i) * height[j];
    			j--;
    		}
    		else 
    		{
    			if ((j - i) * height[i] > max) max = (j - i) * height[i];
    			i++;
    		}
    	}
        return max;
    }
};
int main()
{
	Solution s;
	vector<int> h(3);
	h[0] = 1;
	h[1] = 2;
	h[2] = 1;
	cout << s.maxArea(h) << endl;
	return 0;
}