#include <iostream>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

struct Interval
{
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};

ListNode *generateLinkList(int n)
{
	ListNode *head = new ListNode(random() % 100);
	ListNode *node = head;
	for (int i = 1; i < n; i++)
	{
		node->next = new ListNode(random() % 100);
		node = node->next;
	}
	return head;
}

void printLinkList(ListNode *head)
{
	int count = 0;
	while (head)
	{
		cout << "element " << count + 1 << " val: " << head->val << endl;
		count++;
		head = head->next;
	}
}

