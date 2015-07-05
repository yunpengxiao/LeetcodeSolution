#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
private:
	bool helper(vector<vector<char> > &board, string word, int index, int starti, int startj, vector<vector<bool> > visit)
	{
		if (word.size() == index) return true;
		if (starti < 0 || starti >= board.size() || startj < 0 || startj >= board[0].size() || visit[starti][startj] || word[index] != board[starti][startj])
			return false;
		visit[starti][startj] = true;
		return helper(board, word, index + 1, starti - 1, startj, visit) ||
		       helper(board, word, index + 1, starti + 1, startj, visit) ||
		       helper(board, word, index + 1, starti, startj - 1, visit) ||
		       helper(board, word, index + 1, starti, startj + 1, visit);
	}
public:
    bool exist(vector<vector<char> > &board, string word) 
    {
    	if (word.size() == 0)
    		return true;
    	int m = board.size();
    	if (m == 0)
    		return false;
    	int n = board[0].size();
    	if (n == 0)
    		return false;
        vector<vector<bool> > visit(m, vector<bool>(n, false));
    	for (int i = 0; i < m; i++)
    	{
    		for (int j = 0; j < n; j++)
    		{
    			if (helper(board, word, 0, i, j, visit))
    				return true;
    		}
    	}
    	return false;
    }
};

int main()
{

	return 0;
}