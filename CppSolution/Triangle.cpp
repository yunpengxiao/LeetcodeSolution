#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    int minimumTotal(vector<vector<int> > &triangle) 
    {
    	if (triangle.size() == 0)
    		return 0;
    	int n = triangle.size();
    	for (int i = n - 2; i >= 0; i--)
    	{
    		for (int j = 0; j <= i; j++)
    		{
    			triangle[i][j] += min(triangle[i + 1][j], triangle[i + 1][j + 1]);
    		}
    	}
    	return triangle[0][0];
    }
};

int main()
{
	vector<int> a;
	a.push_back(1);
	vector<int> b;
	b.push_back(2);
	b.push_back(3);
	vector<vector<int> > s;
	s.push_back(a);
	s.push_back(b);
	Solution ss;
	cout << ss.minimumTotal(s) << endl;
	return 0;
}