#include <iostream>
using namespace std;

class Solution 
{
private:
	vector<vector<int> > threeSum(vector<int> &num, int target)
	{
		vector<vector<int> > r;
		vector<int> triple(3);
		sort(num.begin(), num.end());
		int j, k;
		for (int i = 0; i < num.size(); i++)
		{
			if (num[i] == num[i - 1] && i > 0) continue;
			j = i + 1;
			k = num.size() - 1;
			while (j < k)
			{
				if (num[i] + num[j] + num[k] > target) k--;
				else if (num[i] + num[j] + num[k] < target) j++;
				else 
				{
					if (num[j] != triple[1] || num[k] != triple[2] || r.size() == 0)
					{
						triple[0] = num[i];
						triple[1] = num[j];
						triple[2] = num[k];
						r.push_back(triple);
					}
					j++;
					k--;
				}
			}
		}
		return r;
	}
public:
    vector<vector<int> > fourSum(vector<int> &num, int target) 
    {
        
    }
};
int main()
{

	return 0;
}