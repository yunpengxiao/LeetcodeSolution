#include <iostream>
#include <vector>
using namespace std;



struct ListNode 
{
	int val;
    ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

class Solution 
{
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) 
    {
    	if (lists.empty()) return NULL;
        ListNode *head;
        ListNode *p1;
        ListNode *p2;
        ListNode *cur;
        int r;
        for (r = 0; r < lists.size(); r++)
        {
        	if (lists[r] != NULL) break;
        }
        if (r == lists.size()) return NULL;
        head = lists[r];
        for (int i = r + 1; i < lists.size(); i++)
        {
        	if (lists[i] == NULL) continue;
        	cur = NULL;
        	p1 = head;
        	p2 = lists[i];
        	while (p1 != NULL && p2 != NULL)
        	{
        		if (p1->val >= p2->val)
        		{
        			if (cur == NULL)
        			{
        				head = p2;
        				cur = p2;
        			}
        			else
        			{
        				cur->next = p2;
        				cur = cur->next;
        			}
        			p2 = p2->next;

          		}
          		else
          		{
          			if (cur == NULL)
          			{
          				head = p1;
          				cur = p1;
          			}
          			else
          			{
          				cur->next = p1;
          				cur = cur->next;
          			}
          			p1 = p1->next;
          		}
        	}
        	cur->next = p1? p1: p2;
        }
        return head;
    }
};

int main()
{
	return 0;
}