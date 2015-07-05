#include <iostream>
#include "Utility.h"
using namespace std;

class Solution
{
private:
    int sum(TreeNode *root, int qua)
    {
        if (root == NULL)
            return 0;
        if (root->left == NULL && root->right == NULL)
            return qua * 10 + root->val;
        return sum(root->left, qua * 10 + root->val) + sum(root->right, qua * 10 + root->val);
    }
public:
    int sumNumbers(TreeNode *root)
    {
        return sum(root, 0);
    }
};

int main()
{
    return 0;
}
