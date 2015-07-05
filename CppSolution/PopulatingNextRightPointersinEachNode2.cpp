#include "Utility.h"

class Solution 
{
public:
    void connect(TreeLinkNode *root) 
    {
        if (root == NULL)
        	return ;
        TreeLinkNode *lastHead = root;
        TreeLinkNode *pre = NULL;
        TreeLinkNode *curHead = NULL;
        TreeLinkNode *lastCur;
        while (lastHead != NULL)
        {
        	lastCur = lastHead;
        	while (lastCur != NULL)
        	{
        		if (lastCur->left != NULL)
        		{
        			if (curHead == NULL)
        			{
        				curHead = lastHead->left;
        				pre = curHead;
        			}
        			else
        			{
        				pre->next = lastCur->left;
        				pre = pre->next;
        			}
        		}

        		if (lastCur->right != NULL)
        		{
        			if (curHead == NULL)
        			{
        				curHead = lastCur->right;
        				pre = curHead;
        			}
        			else
        			{
        				pre->next = lastCur->right;
        				pre = pre->next;
        			}
        		}
        		lastCur = lastCur->next;
        	}
        	lastHead = curHead;
        	curHead = NULL;
        }
    }
};

int main()
{
	return 0;
}