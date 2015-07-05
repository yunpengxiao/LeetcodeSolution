#include <iostream>
#include <queue>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    vector<vector<int> > levelOrder(TreeNode *root)
    {
        vector<vector<int> > result;
        vector<int> level;
        queue<TreeNode*> nodeQueue;
        if (root == NULL)
            return result;
        nodeQueue.push(root);
        int curNum = 0;
        int lastNum = 1;
        TreeNode *cur;
        while (!nodeQueue.empty())
        {
            cur = nodeQueue.front();
            nodeQueue.pop();
            lastNum--;
            level.push_back(cur->val);
            if (cur->left != NULL)
            {
                nodeQueue.push(cur->left);
                curNum++;
            }
            if (cur->right != NULL)
            {
                nodeQueue.push(cur->right);
                curNum++;
            }
            if (lastNum == 0)
            {
                lastNum = curNum;
                curNum = 0;
                result.push_back(level);
                level.clear();
            }
        }
        return result;
    }
};

int main()
{
    return 0;
}
