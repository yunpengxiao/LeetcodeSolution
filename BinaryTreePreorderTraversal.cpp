#include <iostream>
#include <vector>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    vector<int> preorderTraversal(TreeNode *root)
    {
        vector<int> r;
        if (root == NULL) return r;
        r.push_back(root->val);
        vector<int> tl = preorderTraversal(root->left);
        vector<int> tr = preorderTraversal(root->right);
        r.insert(r.end(), tl.begin(), tl.end());
        r.insert(r.end(), tr.begin(), tr.end());
        return r;
    }
};

int main()
{
    return 0;
}
