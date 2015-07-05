#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution 
{
public:
	int threeSumClosest(vector<int> &num, int target)
	{
		//vector<vector<int> > r;
		//vector<int> triple(3);
		sort(num.begin(), num.end());
		int j, k;
		int min = 999999999;
		int sum;
		for (int i = 0; i < num.size(); i++)
		{
			if (num[i] == num[i - 1] && i > 0) continue;
			j = i + 1;
			k = num.size() - 1;
			while (j < k)
			{
				if (num[i] + num[j] + num[k] > target) 
				{
					if (abs(target - (num[i] + num[j] + num[k])) < min) 
					{
						min = abs(target - (num[i] + num[j] + num[k]));
						sum = num[i] + num[j] + num[k];
					}
					k--;
				}
				else if (num[i] + num[j] + num[k] < target) 
				{
					if (abs(target - (num[i] + num[j] + num[k])) < min) 
					{
						min = abs(target - (num[i] + num[j] + num[k]));
						sum = num[i] + num[j] + num[k];
					}
					j++;
				}
				else 
				{
					min = 0;
					return num[i] + num[j] + num[k];
					// if (num[j] != triple[1] || num[k] != triple[2] || r.size() == 0)
					// {
					// 	triple[0] = num[i];
					// 	triple[1] = num[j];
					// 	triple[2] = num[k];
					// 	r.push_back(triple);
					// }
					// j++;
					// k--;
				}
			}
		}
		return sum;
	}
};

int main()
{
	Solution s;
	int te[3] = {0, 0, 0};
	vector<int> n(te, te + 3);
	cout << s.threeSumClosest(n, 1) << endl;
	return 0;
}