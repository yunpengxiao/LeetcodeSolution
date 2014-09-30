#include <iostream>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2)
    {
        if (l1 == NULL) return l2;
        if (l2 == NULL) return l1;
        ListNode *head = new ListNode(0);
        head->next = l1;
        ListNode *pre = head;
        ListNode *t;
        while (l1 && l2)
        {
            if (l1->val > l2->val)
            {
                t = l2->next;
                pre->next = l2;
                l2->next = l1;
                l2 = t;
            }
            else
            {
                l1 = l1->next;
            }
            pre = pre->next;
        }
        if (l2 != NULL)
        {
            pre->next = l2;
        }
        return head->next;
    }
};

int main()
{
    
    return 0;
}
