#include <iostream>
#include <vector>
using namespace std;

class Solution 
{
public:
    bool isValidSudoku(vector<vector<char> > &board) 
    {
    	if (board.size() != 9 || board[0].size() != 9)
    		return false;
    	bool showed[9];
    	for (int i = 0; i < 9; i++)
    	{
    		for (int r = 0; r < 9; r++)
    			showed[r] = false;
    		for (int j = 0; j < 9; j++)
    		{
    			if (board[i][j] == '.')
    				continue;
    			if (showed[board[i][j] - '1'])
    				return false;
    			else
    				showed[board[i][j] - '1'] = true;
    		}
    	}

    	for (int j = 0; j < 9; j++)
    	{
    		for (int r = 0; r < 9; r++)
    			showed[r] = false;
    		for (int i = 0; i < 9; i++)
    		{
    			if (board[i][j] == '.')
    				continue;
    			if (showed[board[i][j] - '1'])
    				return false;
    			else
    				showed[board[i][j] - '1'] = true;
    		}
    	}

    	for (int i = 0; i < 9; i++)
    	{
    		for (int r = 0; r < 9; r++)
    			showed[r] = false;
    		for (int m = (i / 3) * 3; m < (i / 3) * 3 + 3; m++)
    		{
    			for (int n = (i % 3) * 3; n < (i % 3) * 3 + 3; n++)
    			{
    				if (board[m][n] == '.')
    					continue;
    				if (showed[board[m][n] - '1'])
    					return false;
    				else
    					showed[board[m][n] - '1'] = true;
    			}	
    		}
    	}
    	return true;
    }
};

int main()
{
	return 0;
}