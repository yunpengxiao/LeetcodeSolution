#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    int maxProfit(vector<int> &prices) 
    {
        if (prices.size() == 0)
        	return 0;
        int local = 0;
        int global = 0;
        for (int i = 0; i < prices.size() - 1; i++)
        {
        	local = max(0, local + prices[i + 1] - prices[i]);
        	global = max(local, global);
        }
        return global;
    }
};

int main()
{
	return 0;
}