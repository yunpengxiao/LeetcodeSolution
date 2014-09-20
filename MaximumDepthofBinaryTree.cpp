#include <iostream>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    int maxDepth(TreeNode *root)
    {
        if (root == NULL)
            return 0;
        if (root->left == NULL && root->right == NULL)
            return 1;
        int leftd = maxDepth(root->left);
        int rightd = maxDepth(root->right);
        return max(leftd, rightd) + 1;
    }
};

int main()
{
    
    return 0;
}
