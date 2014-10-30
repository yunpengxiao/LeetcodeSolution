#include <iostream>
#include <unordered_map>
#include <queue>
#include "Utility.h"
using namespace std;

class Solution 
{
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) 
    {
        if (node == NULL || node->neighbors.size() == 0)
        	return node;
        queue<UndirectedGraphNode*> q;
        UndirectedGraphNode *t;
        unordered_map<int, UndirectedGraphNode*> s;
        q.push(node);
        UndirectedGraphNode *copy = new UndirectedGraphNode(node->label);
        s.insert(make_pair(node->label, copy));
        while (!q.empty())
        {
            t = q.front();
            q.pop();
            for (int i = 0; i < t->neighbors.size(); i++)
            {
                if (s.find(t->neighbors[i]->label) == s.end())
                {
                    UndirectedGraphNode *p = new UndirectedGraphNode(t->neighbors[i]->label);
                    s.insert(make_pair(t->neighbors[i]->label, p));
                    q.push(t->neighbors[i]);
                }
                s[t->label]->neighbors.push_back(s[t->neighbors[i]->label]);
            }
        }
        return copy;
    }
};

int main()
{
    UndirectedGraphNode *node = new UndirectedGraphNode(-1);
    Solution ss;
    cout << ss.cloneGraph(node)->label << endl;
	return 0;
}
