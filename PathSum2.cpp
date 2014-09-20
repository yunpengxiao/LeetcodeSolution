#include <iostream>
#include <vector>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    vector<vector<int> > pathSum(TreeNode *root, int sum)
    {
        vector<vector<int> > collection;
        vector<int> solution;
        getSum(root, sum, collection, solution);
        return collection;
    }

    void getSum(TreeNode *root, int sum, vector<vector<int> >& collection, vector<int>& solution)
    {
        if (root == NULL)
            return;
        solution.push_back(root->val);
        if (root->val == sum && root->left == NULL && root->right == NULL)
        {
            collection.push_back(solution);
        }
        else
        {
            getSum(root->left, sum - root->val, collection, solution);
            getSum(root->right, sum - root->val, collection, solution);
        }
        solution.pop_back();
    }
};

int main()
{
    return 0;
}

