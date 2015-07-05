#include <iostream>
#include <vector>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    vector<int> postorderTraversal(TreeNode *root)
    {
        vector<int> result;
        vector<TreeNode*> nodeStack;
        TreeNode* p = root;
        TreeNode* pre = NULL;
        int size;
        while (p != NULL || !nodeStack.empty())
        {
            if (p != NULL)
            {
                nodeStack.push_back(p);
                p = p->left;
            }
            else
            {
                size = nodeStack.size();
                if (nodeStack[size - 1]->right != NULL && nodeStack[size - 1]->right != pre)
                {
                    p = nodeStack[size - 1]->right;
                }
                else
                {
                    pre = nodeStack[size - 1];
                    nodeStack.pop_back();
                    result.push_back(pre->val);
                }
            }
        }
        return result;
    }
};

int main()
{
    return 0;
}
