#include <iostream>
using namespace std;

class Solution
{
public:
    bool isValidBST(TreeNode *root)
    {
        if (root == NULL)
            return false;
        if (root->left == NULL && root->right == NULL)
            return true;
        if (root->left != NULL && root->right == NULL)
            return isValidBST(root->left);
        if (root->right == NULL && root->right != NULL)
            return isValidBST(root->right);
        if (root->)
        
    }
};

int main()
{
    return 0;
}
