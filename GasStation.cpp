#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) 
    {
    	if (gas.size() == 0)
    		return -1;
    	int total = 0;
    	int sum = 0;
    	int p = -1;
    	for (int i = 0; i < gas.size(); i++)
    	{
    		sum += gas[i] - cost[i];
    		total += gas[i] - cost[i];
    		if (sum < 0)
    		{
    			sum = 0;
    			p = i;
    		}
    	}
    	return total >=0? p + 1: -1;
    }
};

int main()
{
	return 0;
}