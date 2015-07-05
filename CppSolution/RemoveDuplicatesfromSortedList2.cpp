#include <iostream>
#include "Utility.h"
#include <set>
using namespace std;

class Solution
{
public:
        //create a new linklist in this method
        //I think we should not create a new one
    ListNode *deleteDuplicates(ListNode *head)
    {
        bool dup = false;
        if (head == NULL || head->next == NULL)
            return head;
        ListNode* solution = new ListNode(0);
        ListNode* solutionEnd = solution;
        ListNode* np = head;
        while (np)
        {
            while (np->next != NULL && np->val == np->next->val)
            {
                dup = true;
                np = np->next;
            }
            if (dup == false)
            {
                solutionEnd->next = new ListNode(np->val);
                solutionEnd = solutionEnd->next;
            }
            np = np->next;
            dup = false;
        }
        solution = solution->next;
        return solution;
    }
};

int main()
{
    return 0;
}
