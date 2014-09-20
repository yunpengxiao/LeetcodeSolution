#include <iostream>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    bool hasPathSum(TreeNode *root, int sum)
    {
        if (root == NULL)
            return sum == 0;
        if (root->val == sum && root->left == NULL && root->right == NULL)
            return true;
        return hasPathSum(root->left, sum - root->val) || hasPathSum(root->right, sum - root->val);
    }
};

int main()
{
    
    return 0;
}
