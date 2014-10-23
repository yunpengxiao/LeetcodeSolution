#include <iostream>
#include "Utility.h"
using namespace std;

class Solution 
{
private:
	ListNode *reverseList(ListNode *head)
	{
		if (head == NULL || head->next == NULL)
			return head;
		ListNode *pre = head;
		ListNode *cur = head->next;
		while (cur != NULL)
		{
			ListNode *t = cur->next;
			cur->next = pre;
			pre = cur;
			cur = t;
		}
		head->next = NULL;
		return pre;
	}

	ListNode *mergeList(ListNode *h1, ListNode *h2)
	{
		if (h1 == NULL)
			return h2;
		if (h2 == NULL)
			return h1;
		ListNode *t1 = h1;
		ListNode *t2 = h2;
		while (t1 != NULL && t2 != NULL)
		{
			ListNode *temp = t1->next;
			t1->next = t2;
			t1 = temp;
			temp = t2->next;
			t2->next = t1;
			t2 = temp;
		}
		return h1;
	}

public:
    void reorderList(ListNode *head) 
    {
    	if (head == NULL || head->next == NULL || head->next->next == NULL)
    		return;
    	ListNode *slow = head;
    	ListNode *fast = head;;
    	while (fast != NULL && fast->next != NULL)
    	{
    		slow = slow->next;
    		fast = fast->next->next;
    	}
    	ListNode *t = slow->next;
    	slow->next = NULL;
    	mergeList(head, reverseList(t));
    }
};

int main()
{
	return 0;
}