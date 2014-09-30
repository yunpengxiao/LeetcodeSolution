#include <iostream>
#include <map>
#include <vector>
#include "Utility.h"
using namespace std;

class Solution
{
private:
    map<int, int> m;
    
    TreeNode *build(vector<int> &preorder, int pstart, int pend, vector <int> &inorder, int istart, int iend)
    {
        if (pstart > pend || istart > iend)
            return NULL;
        TreeNode *root = new TreeNode(preorder[pstart]);
        int mid = m[preorder[pstart]];
        root->left = build(preorder, pstart + 1, mid - istart + pstart, inorder, istart, mid - 1);
        root->right = build(preorder, mid - istart + pstart + 1, pend, inorder, mid + 1, iend);
        return root;
    }
public:

    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder)
    {
        for (int i = 0; i < inorder.size(); i++)
        {
            m[inorder[i]] = i;
        }
        return build(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
    }
};

int main()
{
    return 0;
}
