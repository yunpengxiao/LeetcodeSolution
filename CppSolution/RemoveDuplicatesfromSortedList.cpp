#include <iostream>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    ListNode *deleteDuplicates(ListNode *head)
    {
        if (head == NULL || head->next == NULL)
            return head;
        ListNode *pre = head;
        ListNode *p = pre->next;
        while (p)
        {
            if (pre->val == p->val)
            {
                pre->next = p->next;
            }
            else
            {
                pre = p;
            }
            p = p->next;
        }
        return head;
    }
};

int main()
{
    return 0;
}
