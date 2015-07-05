#include "Utility.h"

class Solution 
{
private:
	TreeNode *pre;
	void helper(TreeNode *root)
	{
		if (root == NULL)
			return ;
		TreeNode *t = root->right;
		if (pre != NULL)
		{
			pre->left = NULL;
			pre->right = root;
		}
		pre = root;
		helper(root->left);
		helper(t);
	}
public:
    void flatten(TreeNode *root) 
    {
    	if (root == NULL || (root->left == NULL && root->right == NULL) )
    		return ;
    	pre = NULL;
    	helper(root);
    }
};

int main()
{
	return 0;
}