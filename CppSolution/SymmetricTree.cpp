#include <iostream>
#include <vector>
#include "Utility.h"
using namespace std;

class Solution
{
private:
    bool isSym(TreeNode *left, TreeNode *right)
    {
        if (left == NULL)
            return right == NULL;
        if (right == NULL)
            return left == NULL;
        if (left->val != right->val)
            return false;
        if (!isSym(left->left, right->right))
            return false;
        if (!isSym(left->right, right->left))
            return false;
        return true;
    }
public:
    bool isSymmetric(TreeNode *root) 
    {
        if (root == NULL) return true;
        return isSym(root->left, root->right);
    }
};

int main()
{
    return 0;
}