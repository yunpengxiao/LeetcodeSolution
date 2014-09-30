#include <iostream>
#include <vector>
#include <map>
#include "Utility.h"
using namespace std;

class Solution
{
private:
    map<int, int> m;

    TreeNode *build(vector<int> &inorder, int istart, int iend, vector<int> &postorder, int pstart, int pend)
    {
        if (istart > iend || pstart > pend)
            return NULL;
        TreeNode *root = new TreeNode(postorder[pend]);
        int mid = m[postorder[pend]];
        root->left = build(inorder, istart, mid - 1, postorder, pstart, pstart + mid - istart - 1);
        root->right = build(inorder, mid + 1, iend, postorder, pstart + mid - istart, pend - 1);
        return  root;
    }
public:
    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder)
    {
        for (int i = 0; i < inorder.size(); i++)
        {
            m[inorder[i]] = i;
        }
        return build(inorder, 0, inorder.size() - 1, postorder, 0, postorder.size() - 1);
    }
};

int main()
{
    return 0;
}
