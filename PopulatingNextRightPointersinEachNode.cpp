#include "Utility.h"

class Solution 
{
public:
    void connect(TreeLinkNode *root) 
    {
    	if (root == NULL)
    		return ;
    	queue<TreeLinkNode*> q;
    	queue<int> l;
    	TreeLinkNode *t;
    	int curlevel;
    	q.push(root);
    	l.push(1);
    	while (!q.empty())
    	{
    		t = q.front();
    		q.pop();
    		int curlevel = l.front();
    		l.pop();
    		if (l.size() == 0 || l.front() > curlevel)
    		{
    			t->next = NULL;
    		}
    		else
    		{
    			t->next = q.front();
    		}
    		if (t->left != NULL)
    		{
    			q.push(t->left);
    			l.push(curlevel + 1);
    		}
    		if (t->right != NULL)
    		{
    			q.push(t->right);
    			l.push(curlevel + 1);
    		}
    	}
    }
};

int main()
{
	return 0;
}