#include <iostream>
using namespace std;

struct ListNode 
{
	int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
private:
	void reverslist(ListNode *l)
	{
		ListNode *pre = l;
		ListNode *cur = pre->next;
		ListNode *nextNode = NULL;
		while (cur != NULL)
		{
			nextNode = cur->next;
			cur->next = pre;
			pre = cur;
			cur = nextNode;
		}
		l->next = NULL;
		l = pre;
	}
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) 
    {
    	int count1 = 0;
    	int count2 = 0;
    	int size;
    	ListNode *t = l1;
    	ListNode *p1 = l1;
    	ListNode *p2 = l2;
    	while (t != NULL)
    	{
    		count1++;
    		t = t->next;
    	}
    	t = l2;
    	while (t != NULL)
    	{
    		count2++;
    		t = t->next;
    	}
    	size = max(count1, count2);
    	ListNode *head;
    	ListNode *pre = NULL;
    	ListNode *cur = NULL;
    	int forward = 0;
    	int value;
    	for (int i = 0; i < size; i++)
    	{
    		if (p1 != NULL && p2 != NULL)	value = p1->val + p2->val + forward;
    		else if (p1 == NULL) value = p2->val + forward;
    		else if (p2 == NULL) value = p1->val + forward;
    		if (value > 9) 
    		{
				forward  = value / 10;
				value = value % 10;
    		}
    		else
    		{
    			forward = 0;
    		}
    		cur = new ListNode(value);
    		if (i == 0)
    		{
    			head = cur;
    		}
    		if (pre != NULL) 
    		{
    			pre->next = cur;
    		}
    		pre = cur;
    		if (p1 != NULL) p1 = p1->next;
    		if (p2 != NULL) p2 = p2->next;
    	}
    	if (forward != 0)
    	{
    		cur = new ListNode(forward);
    		pre->next = cur;
    	}
    	return head;
    }
};

int main()
{
	ListNode *t1 = new ListNode(2);
	ListNode *t2 = new ListNode(4);
	ListNode *t3 = new ListNode(3);
	ListNode *t4 = new ListNode(5);
	ListNode *t5 = new ListNode(6);
	ListNode *t6 = new ListNode(4);
	t1->next = t2;
	t2->next = t3;
	t4->next = t5;
	t5->next = t6;
	Solution s;
	ListNode *t = s.addTwoNumbers(t1, t4);
	while (t != NULL)
	{
		cout << t->val << endl;
		t = t->next;
	}
	return 0;
}