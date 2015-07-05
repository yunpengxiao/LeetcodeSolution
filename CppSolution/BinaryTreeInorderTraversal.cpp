#include <iostream>
#include <vector>
#include "Utility.h"
using namespace std;

class Solution {
public:
    vector<int> inorderTraversal(TreeNode *root)
    {
        vector<int> result;
        vector<TreeNode*> nodeStack;
        TreeNode *p = root;
        int size;
        while (p != NULL || nodeStack.size() != 0)
        {
            if (p != NULL)
            {
                nodeStack.push_back(p);
                p = p->left;
            }
            else
            {
                size = nodeStack.size();
                p = nodeStack[size - 1];
                nodeStack.pop_back();
                result.push_back(p->val);
                p = p->right;
            }
        }
        return result;
    }
};

int main()
{
    return 0;
}
