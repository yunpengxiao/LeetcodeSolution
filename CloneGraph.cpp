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
        unordered_map<UndirectedGraphNode*, UndirectedGraphNode*> nodeMap;
        queue<UndirectedGraphNode*> visit;
        visit.push(node);
        UndirectedGraphNode *newNode = new UndirectedGraphNode(node->label);
        while (visit.size() > 0)
        {
        	UndirectedGraphNode *head = visit.front();
        }
        return newNode;
    }
};

int main()
{
	return 0;
}
