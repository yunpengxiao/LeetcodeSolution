#include <iostream>
#include <vector>
#include <queue>
#include "Utility.h"
using namespace std;

class Solution 
{
public:
    vector<vector<int> > zigzagLevelOrder(TreeNode *root) 
    {
    	queue<TreeNode*> tq;
    	queue<int> lq;
    	vector<vector<int> > res;
    	vector<int> tmp;
    	if (root == NULL)
    		return res;
    	tq.push(root);
    	lq.push(1);
    	int level;
    	int lastlevel = 1;
    	TreeNode *p;
    	while (!tq.empty())
    	{
    		level = lq.front();
    		lq.pop();
    		if (level > lastlevel)
    		{
    			res.push_back(tmp);
    			tmp.clear();
    			lastlevel = level;
    		}
    		p = tq.front();
    		tq.pop();
    		tmp.push_back(p->val);
    		if (p->left != NULL)
    		{
    			tq.push(p->left);
    			lq.push(level + 1);
    		}

    		if (p->right != NULL)
    		{
    			tq.push(p->right);
    			lq.push(level + 1);
    		}
    	}	
    	if (res.size() < level)
    		res.push_back(tmp);
    	for (int i = 1; i < res.size(); i += 2)
    	{
    		reverse(res[i].begin(), res[i].end());
    	}
    	return res;
    }
};

int main()
{
	return 0;
}
