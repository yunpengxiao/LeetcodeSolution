#include <iostream>
#include <vector>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    vector<int> postorderTraversal(TreeNode *root)
    {
        vector<int> r;
        if (root == NULL) return r;
        vector<int> tl = postorderTraversal(root->left);
        vector<int> tr = postorderTraversal(root->right);
        r.insert(r.end(), tl.begin(), tl.end());
        r.insert(r.end(), tr.begin(), tr.end());
        r.push_back(root->val);
        return r;
    }
};

int main()
{
    return 0;
}
