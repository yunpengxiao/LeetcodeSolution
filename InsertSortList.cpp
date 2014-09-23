#include <iostream>
#include <climits>
#include "Utility.h"
using namespace std;

class Solution
{
public:
	ListNode *insertSortList(ListNode *head)
	{
		if (head == NULL || head->next == NULL) return head;
                ListNode *g = new ListNode(INT_MIN);
                ListNode *p = head;
                ListNode *pre;
                ListNode *t;
                while (p)
                {
                    t = p->next;
                    pre = g;
                    while (pre->next != NULL && pre->next->val < p->val)
                    {
                        pre = pre->next;
                    }
                    p->next = pre->next;
                    pre->next = p;
                    p = t;
                }
		return g->next;
	}
};

int main()
{
    Solution *solution = new Solution();
    ListNode *head = generateLinkList(10);
    head = solution->insertSortList(head);
    printLinkList(head);
    return 0;
}
