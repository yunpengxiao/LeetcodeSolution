#include <iostream>
#include <vector>
#include "Utility.h"
using namespace std;

class Solution 
{
private:
	vector<TreeNode *> helper(int start, int end)
	{
		vector<TreeNode *> res;
		if (start > end)
		{
			res.push_back(NULL);
		}
		for (int i = start; i <= end; i++)
		{
			vector<TreeNode *> leftlist = helper(start, i - 1);
			vector<TreeNode *> rightlist = helper(i + 1, end);
			for (int j = 0; j < leftlist.size(); j++)
			{
				for (int r = 0; r < rightlist.size(); r++)
				{
					TreeNode *root = new TreeNode(i);
					root->left = leftlist[j];
					root->right = rightlist[r];
					res.push_back(root);
				}
			}
		}
		return res;
	}
public:
    vector<TreeNode *> generateTrees(int n) 
    {
    	return helper(1, n);
    }
};

int main()
{
	return 0;
}