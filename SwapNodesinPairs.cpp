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
    ListNode *swapPairs(ListNode *head) 
    {
        ListNode *pre = NULL;
        ListNode *cur = head;
        ListNode *nextN = NULL;
        while (cur != NULL && cur->next != NULL)
        {
        	nextN = cur->next;
        	if (pre != NULL) 
        	{
        		pre->next = nextN;
        	}
        	else
        	{
        		head = nextN;
        	}
        	cur->next = nextN->next;
        	nextN->next = cur;
        	pre = cur;
        	cur = cur->next;
        }
        return head;
    }
};

int main()
{
	return 0;
}