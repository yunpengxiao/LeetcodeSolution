#include <iostream>
#include "Utility.h"
using namespace std;

class Solution 
{
public:
    ListNode *reverseBetween(ListNode *head, int m, int n) 
    {
    	if (head == NULL || head->next == NULL)
    		return head;
    	if (m == n)
    		return head;
    	int count = 1;
    	ListNode *h = new ListNode(0);
    	h->next = head;
    	ListNode *p = h;
    	while (count < m)
    	{
    		p = p->next;
    		count++;
    	}
    	ListNode *save1 = p;
    	ListNode *save2 = p->next;
    	ListNode *pre = save2;
    	ListNode *cur = save2->next;
    	while (count < n)
    	{
    		ListNode *t = cur->next;
    		cur->next = pre;
    		pre = cur;
    		cur = t;
    		count++;
    	}
    	save2->next = cur;
    	save1->next = pre;
    	return h->next;
    }
};

int main()
{
	return 0;
}