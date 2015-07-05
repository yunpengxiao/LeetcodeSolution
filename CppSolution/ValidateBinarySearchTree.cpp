#include <iostream>
#include "Utility.h"
using namespace std;

class Solution
{
private:
    bool helper(TreeNode *root, int &pre)
    {
        if (root == NULL)
            return true;
        bool left = helper(root->left, pre);
        if (root->val <= pre)
            return false;
        pre = root->val;
        return left && helper(root->right, pre);
    }
public:
    bool isValidBST(TreeNode *root)
    {
        int pre = INT_MIN;
        return helper(root, pre);
    }
};

int main()
{
    return 0;
}
