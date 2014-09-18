#include <iostream>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    int minDepth(TreeNode *root)
    {
        if (root == NULL)
            return 0;
        if (root->left == NULL && root->right == NULL)
            return 1;
        int lmin = minDepth(root->left);
        int rmin = minDepth(root->right);
        if (root->left == NULL)
            lmin = INT_MAX;
        if (root->right == NULL)
            rmin = INT_MAX;
        return min(lmin, rmin) + 1;
    }
};

int main()
{
    
    return 0;
}
