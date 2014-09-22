#include <iostream>
#include <vector>
#include "Utility.h"
using namespace std;

class Solution
{
private:
    TreeNode* buildTree(vector<int> &num, int start, int end)
    {
        if (start > end) return NULL;
        if (start == end) return new TreeNode(num[start]);
        int mid = (start + end) / 2;
        TreeNode *t = new TreeNode(num[mid]);
        t->left = buildTree(num, start, mid - 1);
        t->right = buildTree(num, mid + 1, end);
    }
public:
    TreeNode *sortedArrayToBST(vector<int> &num)
    {
        return buildTree(num, 0, num.size() - 1);
    }
};

int main()
{
    return 0;
}
