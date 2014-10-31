#include "Utility.h"

class Solution 
{
private:
	int helper(TreeNode *root, int &res)
	{
		if (root == NULL)
			return 0;
		int left = helper(root->left, res);
		int right = helper(root->right, res);
		int val = root->val + (left > 0?left:0) + (right > 0?right:0);
		if (val > res)
			res = val;
		return root->val + max(0, max(left, right));
	}
public:
    int maxPathSum(TreeNode *root) 
    {
    	if (root == NULL)
    		return 0;
    	int res = INT_MIN;
    	helper(root, res);
    	return res;
    }
};

int main()
{
	return 0;
}
