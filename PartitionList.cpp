#include <iostream>
#include <climits>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    ListNode *partition(ListNode *head, int x)
    {
        if (head == NULL || head->next == NULL)
            return head;
        ListNode *second = NULL;
        ListNode *newHead = new ListNode(INT_MIN);
        newHead->next = head;
        ListNode *p = newHead;
        ListNode *pre;
        ListNode *cur;
        ListNode *t;
        while (p != NULL && p->val < x)
        {
            pre = p;
            p = p->next;
        }

        if (p != NULL)
        {
            cur = pre;
            while (p)
            {
                if (p->val < x)
                {
                    t = cur->next;
                    pre->next = p->next;
                    cur->next = p;
                    p->next = t;
                    cur = p;
                    p = pre;
                }
                pre = p;
                p = p->next;
            }
        }
        return newHead->next;
    }
};

int main()
{
    return 0;
}
