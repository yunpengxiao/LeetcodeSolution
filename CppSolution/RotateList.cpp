#include <iostream>
#include "Utility.h"
using namespace std;

class Solution 
{
public:
    ListNode *rotateRight(ListNode *head, int k) 
    {
    	if (head == NULL)
    		return NULL;
    	ListNode *h = new ListNode(0);
    	h->next = head;
    	ListNode *p = head;
    	int len = 1;
    	while (p->next != NULL)
    	{
    		len++;
    		p = p->next;
    	}
    	k = k % len;
    	if (k == 0)
    		return head;
    	int count = 1;
    	p = head;
    	while (count != len - k)
    	{
    		count++;
    		p = p->next;
    	}
    	h->next = p->next;
    	p->next = NULL;
    	p = h->next;
    	while (p->next != NULL)
    		p = p->next;
    	p->next = head;
    	return h->next;
    }
};

int main()
{
	return 0;
}