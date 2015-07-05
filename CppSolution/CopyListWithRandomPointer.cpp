#include "Utility.h"

class Solution 
{
public:
    RandomListNode *copyRandomList(RandomListNode *head) 
    {
    	if (head == NULL)
    		return head;
    	RandomListNode *t;
    	RandomListNode *res;
    	RandomListNode *tmp;
    	RandomListNode *p = head;
    	while (p)
    	{
    		t = p->next;
    		RandomListNode *newp = new RandomListNode(p->label);
    		newp->next = p->next;
    		p->next = newp;
    		p = t;
    	}
    	p = head;
    	while (p)
    	{
    		p->next->random = p->random->next;
    		p = p->next->next;
    	}
    	p = head;
    	res = head->next;
    	t = p->next->next;
    	while (p && t)
    	{
    		tmp = p->next;
    		p->next = t;
    		tmp->next = t->next;
    		p = t;
    		t = t->next->next;
    	}
    	p->next = NULL;
    	return res;
    }
};

int main()
{
	return 0;
}
