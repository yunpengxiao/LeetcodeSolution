#include <iostream>
#include <vector>
#include "Utility.h"
using namespace std;

class Solution
{
private:
    TreeNode *pre;
    vector<TreeNode*> res;
    void helper(TreeNode *root)
    {
        if (root == NULL)
            return;
        helper(root->left);
        if (pre != NULL && root->val < pre->val)
        {
            if (res.size() == 0)
            {
                res.push_back(pre);
                res.push_back(root);
            }
            else
            {
                res[1] = root;
            }
        }
        pre = root;
        helper(root->right);
    }
public:
    void recoverTree(TreeNode *root)
    {
        pre = NULL;
        if (root == NULL)
            return;
        helper(root);
        if (res.size() > 0)
        {
        int tmp = res[0]->val;
        res[0]->val = res[1]->val;
        res[1]->val = tmp;
        }
    }
};

int main()
{
    Solution s;
    TreeNode* t1 = new TreeNode(0);
    TreeNode* t2 = new TreeNode(1);
    t1->left = t2;
    s.recoverTree(t1);
    cout << t1->val << endl;
    cout << t2->val << endl;
    return 0;
}
