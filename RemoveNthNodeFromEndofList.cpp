#include <iostream>
using namespace std;


struct ListNode 
{
	int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) 
    {
        ListNode *slow = head;
        ListNode *fast = head;
        int count = 0;
        while (count != n)
        {
            fast = fast->next;
            count++;
        }

        if (fast == NULL)
        {
            head = head->next;
            return head;
        }
        while (fast->next != NULL)
        {
            slow = slow->next;
            fast = fast->next;
        }
        slow->next = slow->next->next;
        return head;
    }
};

int main()
{
	return 0;
}
