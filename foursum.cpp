#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

class Solution 
{
public:
    vector<vector<int> > fourSum(vector<int> &num, int target) 
    {
    	vector<vector<int> > r;
        if (num.size() < 4) return r;
        vector<int> t(4);
        set<vector<int> > temp;
        int start, end;
        sort(num.begin(), num.end());
        int n = num.size();
        for (int i = 0; i < n; i++)
        {
        	for (int j = i + 1; j < n; j++)
        	{
        		start = j + 1;
        		end = n - 1;
        		while (start < end)
        		{
        			if (num[i] + num[j] + num[start] + num[end] > target) end--;
        			else if (num[i] + num[j] + num[start] + num[end] < target) start++;
        			else 
        			{
        					t[0] = num[i];
        					t[1] = num[j];
        					t[2] = num[start];
        					t[3] = num[end];
        					temp.insert(t);
        				start++;
        				end--;
        			}
        		}
        	}
        }
        r.assign(temp.begin(), temp.end());
        return r;
    }
};

int main()
{

	return 0;
}