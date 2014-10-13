#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution 
{
private:
	vector<vector<string> > res;
	void pushIntoResult(vector<int> a)
	{
		int size = a.size();
		vector<string> t;
		for (int i = 0; i < size; i++)
		{
			string tm(size, '.');
			tm[a[i]] = 'Q';
			t.push_back(tm);
		}
		res.push_back(t);
	}

	bool check(int row, vector<int> columnForRow)
	{
		for (int i = 0; i < row; i++)
		{
			if (columnForRow[i] == columnForRow[row] || abs(columnForRow[row] - columnForRow[i]) == row - i)
				return false;
		}
		return true;
	}

	void helper(int n, int row, vector<int> columnForRow) // check weather there need a pointer
	{
		if (row == n)
		{
			pushIntoResult(columnForRow);
			return;
		}

		for (int i = 0; i < n; i++)
		{
			columnForRow[row] = i;
			if (check(row, columnForRow))
				helper(n, row + 1, columnForRow);
		}
	}
public:
    int totalNQueens(int n) 
    {
    	vector<int> cfr(n);
    	helper(n, 0, cfr);
    	return res.size();
    }
};

int main()
{
	return 0;
}