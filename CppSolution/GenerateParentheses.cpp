#include <iostream>
#include <vector>
using namespace std;

class Solution {
private:
	vector<string> genepa(int n, int left)
	{
		vector<string> r;
		vector<string> temp;
		string t;
		if (n == left)
		{
			for (int i = 0; i < n; i++)
			{
				t += ')';
			}
			r.push_back(t);
		}
		else 
		{
			if (left == 0) 
			{
				temp = genepa(n - 1, 1);
				for (int i = 0; i < temp.size(); i++)
				{
					r.push_back('(' + temp[i]);
				}
			}
			else 
			{
				temp = genepa(n - 1, left - 1);
				for (int i = 0; i < temp.size(); i++)
				{
					r.push_back(')' + temp[i]);
				}
				temp = genepa(n - 1, left + 1);
				for (int i = 0; i < temp.size(); i++)
				{
					r.push_back('(' + temp[i]);
				}				
			}
		}
		return r;
	}
public:
    vector<string> generateParenthesis(int n) 
    {
        vector<string> r;
        if (n == 0) return r;
        r = genepa(n * 2, 0);
        return r;
    }
};

int main()
{
	return 0;
}