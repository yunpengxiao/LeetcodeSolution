#include <iostream>
#include <vector>
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
        vector<ListNode *> savepoint;
        savepoint.push_back(head);
        int count = 1;
        ListNode *p = head;
        while (p->next != NULL)
        {
        	count++;
        	savepoint.push_back(p->next);
        	p = p->next;
        }
        int index = count - n;
        if (index == 0)
        {
        	head = head->next;
        	return head;
        }
        else if (n == 1)
        {
        	savepoint[count - 2]->next = NULL;
        	return head;
        }
        else
        {
        	savepoint[index - 1]->next = savepoint[index + 1];
        	return head;
        }
    }
};

int main()
{
	return 0;
}