#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution 
{
private:
	ListNode *reverse(ListNode *pre, ListNode *nxt)
	{

        ListNode *last = pre->next;
        ListNode *cur = last->next;
        while (cur != nxt)
        {
            last->next = cur->next;
            cur->next = pre->next;
            pre->next = cur;
            cur = last->next;
        }
        return last;
	}
public:
    ListNode *reverseKGroup(ListNode *head, int k) 
    {
        if (head == NULL || k == 1) return head;
        ListNode *dummy = new ListNode(0);
        dummy->next = head;
        ListNode *pre = dummy;
        int i = 0;
        while (head != NULL)
        {
            i++;
            if (i % k == 0)
            {
                pre = reverse(pre, head->next);
                head = pre->next;
            }
            else head = head->next;
        } 
        return dummy->next;
    }
};

int main()
{
	
	return 0;
}