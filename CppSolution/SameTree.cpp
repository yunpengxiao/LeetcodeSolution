#include <iostream>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    bool isSameTree(TreeNode *p, TreeNode *q)
    {
        if (p == NULL && q == NULL) return true;
        if (p == NULL && q != NULL) return false;
        if (p != NULL && q == NULL) return false;
        if (p->val == q->val && isSameTree(p->left, q->left)
            && isSameTree(p->right, q->right))
            return true;
        return false;
    }
};

int main()
{
    
    return 0;
}
