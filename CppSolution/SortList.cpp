#include <iostream>
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
    ListNode *sortList(ListNode *head) 
    {
        ListNode *mid;
        if (head == NULL || head->next == NULL) return head;
        else
        {
            mid = findMidPoint(head);
        }
        ListNode *list1 = head;
        ListNode *list2 = mid->next;
        mid->next = NULL;
        list1 = sortList(list1);
        list2 = sortList(list2);
        return mergeSortedList(list1, list2);
    }

private:
    ListNode *mergeSortedList(ListNode *list1, ListNode *list2)
    {
        if (list1 == NULL) return list2;
        if (list2 == NULL) return list1;
        ListNode *head;
        ListNode *position1;
        ListNode *position2;
        ListNode *cur;
        if (list1->val > list2->val)
        {
            head = list2;
            position1 = list1;
            position2 = list2->next;
            if (position2 == NULL)
            {
                head->next = list1;
                return head;
            }    
        }
        else
        {
            head = list1;
            position1 = list1->next;
            position2 = list2;
            if (position1 == NULL)
            {
                head->next = list2;
                return head;
            }
        }

        cur = head;

        while (position1 != NULL && position2 != NULL)
        {
            if (position1->val > position2->val)
            {
                cur->next = position2;
                cur = cur->next;
                position2 = position2->next;
            }
            else
            {
                cur->next = position1;
                cur = cur->next;
                position1 = position1->next;
            }
        }
        if (position1 != NULL)
        {
            cur->next = position1;
        }
        if (position2 != NULL)
        {
            cur->next = position2;
        }
        return head;
    }

    ListNode *findMidPoint(ListNode *head)
    {
        ListNode *fastPoint = head;
        ListNode *slowPoint = head;
        while (fastPoint->next != NULL && fastPoint->next->next != NULL)
        {
            slowPoint = slowPoint->next;
            fastPoint = fastPoint->next->next;
        }
        return slowPoint;
    }
};

int main()
{
    Solution *solution = new Solution();
    ListNode *node1 = new ListNode(2);
    ListNode *node2 = new ListNode(1);
    ListNode *node3 = new ListNode(3);
    node1->next = node2;
    node2->next = node3;
    ListNode *head = node1;
    head = solution->sortList(head);
    cout << "head is " << head->val << endl; 
    head = head->next;
    cout << "head is " << head->val << endl; 
    head = head->next;
    cout << "head is " << head->val << endl; 
    return 0;
}
