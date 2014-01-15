#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

// class Solution 
// {
// private:
// 	vector<int> findpair(vector<int> &n, int m)
// 	{
// 		vector<int> r;
// 		sort(n.begin(), n.end());
// 		int start = 0;
// 		int end = n.size() - 1;
// 		while (start < end)
// 		{
// 			if (n[start] + n[end] == m) 
// 			{
// 				r.push_back(n[start]);
// 				r.push_back(n[end]);
// 				start++;
// 				end--;
// 			}
// 			else if (n[start] + n[end] > m) end--;
// 			else 
// 			{
// 				start++;
// 			}
// 		}
// 		return r;
// 	}
// 	bool isinr(vector<vector<int> > &r, vector<int> &n)
// 	{
// 		for (int i = 0; i < r.size(); i++)
// 		{
// 			if (r[i] == n) return true;
// 		}
// 		return false;
// 	}
// public:
//     vector<vector<int> > threeSum(vector<int> &num) 
//     {
//         set<vector<int> > r;
//         vector<vector<int> > result;
//         if (num.size() < 3) return result;
//         int temp;
//         int sum;
//         vector<int> t;
//         vector<int> saver;
//         for (int i = 0; i < num.size(); i++)
//         {
//         	t = num;
//         	sum = 0 - t[i];
//         	temp = t[i];
//         	t[i] = t[num.size() - 1];
//         	t[num.size() - 1] = temp;
//         	t.pop_back();
//         	//cout << "NOW is " << -sum << endl;
//         	//sort(t.begin(), t.end());
//         	saver = findpair(t, sum);
//         	saver.push_back(num[i]);
//         	sort(saver.begin(), saver.end());
//         	if (saver.size() == 3) r.insert(saver);
//         	//result.insert
// 			//if (saver.size() == 3 && !isinr(r, saver)) r.push_back(saver);
//         	// for (int i = 0; i < saver.size(); i++)
//         	// {
//         	// 	cout << saver[i] << " ";
//         	// }
//         	// cout << endl;
//         }
//         result.assign(r.begin(), r.end());
//         return result;
//     }
// };

class Solution 
{
public:
	vector<vector<int> > threeSum(vector<int> &num)
	{
		//set<vector<int> > t;
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
				if (num[i] + num[j] + num[k] > 0) k--;
				else if (num[i] + num[j] + num[k] < 0) j++;
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
};
int main()
{
	Solution s; 
	int te[3] = {0, 0, 0};
	vector<int> n(te, te + 3);
	vector<vector<int> > t = s.threeSum(n);
	for (int i = 0; i < t.size(); i++)
	{
		for (int j = 0; j < t[i].size(); j++)
		{
			cout << t[i][j] << ' ';
		}
		cout << endl;
	}
	return 0;
}