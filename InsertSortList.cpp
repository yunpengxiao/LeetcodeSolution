#include <iostream>
#include "Utility.h"
using namespace std;

class Solution
{
public:
	ListNode *insertSortList(ListNode *head)
	{
		if (head == NULL || head->next == NULL) return head;
		ListNode *sortedList;
		ListNode *unsortedList = head->next;
		ListNode *pre;
		ListNode *cur;
		head->next = NULL;
		cout << "entering loop!" << endl;
		while (unsortedList != NULL)
		{
			sortedList = head;
			while (sortedList != NULL && sortedList->val < unsortedList->val)
			{
				pre = sortedList;
				sortedList = sortedList->next;
			}
			cout << "find position" << endl;

			cur = unsortedList;
			if (head == sortedList)
			{
				head = cur;
			}
			else
			{
				pre->next = unsortedList;
			}
			unsortedList = unsortedList->next;
			cur->next = sortedList;
		}
		return head;
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