#include <iostream>
#include "Utility.h"
using namespace std;

class Solution 
{
private:
	ListNode *p;
	TreeNode *helper(int start, int end)
	{
		if (start > end)
			return NULL;
		int m = (start + end) / 2;
		TreeNode *left = helper(start, m - 1);
		TreeNode *root = new TreeNode(p->val);
		root->left = left;
		p = p->next;
		root->right = helper(m + 1, end);
		return root;
	}
public:
    TreeNode *sortedListToBST(ListNode *head) 
    {
        if (head == NULL)
        	return NULL;
        ListNode *cur = head;
        int count = 0;
        while (cur != NULL)
        {
        	cur = cur->next;
        	count++;
        }
        p = head;
        return helper(0, count - 1);
    }
};

int main()
{
	return 0;
}