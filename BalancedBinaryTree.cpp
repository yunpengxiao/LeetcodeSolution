#include <iostream>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    bool isBalanced(TreeNode *root)
    {
        if (root == NULL) return true;
        if (getBalance(root) == -1) return false;
        else return true;
    }

    int getBalance(TreeNode *root)
    {
        if (root == NULL)
            return 0;
        int leftb = getBalance(root->left);
        if (leftb == -1) return -1;
        int rightb = getBalance(root->right);
        if (rightb == -1) return -1;
        if ((leftb - rightb) > 1 || (rightb - leftb) > 1)
            return -1;
        return leftb > rightb ? leftb + 1 : rightb + 1;
    }
};

int main()
{
    return 0;
}
