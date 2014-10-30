#include <iostream>
#include <vector>
#include <queue>
#include <unordered_set>
using namespace std;

class Solution 
{
public:
    int ladderLength(string start, string end, unordered_set<string> &dict) 
    {
        if (start.size() == 0 || end.size() == 0 || dict.size() == 0)
        	return 0;
        queue<string> wordq;
        queue<int> distq;
        wordq.push(start);
        distq.push(1);

        while (!wordq.empty())
        {
        	string t = wordq.front();
        	wordq.pop();
        	int dis = distq.front();
        	distq.pop();
        	if (t == end)
        		return dis;
        	for (int i = 0; i < t.size(); i++)
        	{
        		string tmp = t;
        		for (char c = 'a'; c <= 'z'; c++)
        		{
        			if (tmp[i] == c)
        				continue;
        			tmp[i] = c;
        			if (dict.find(tmp) != dict.end())
        			{
        				wordq.push(tmp);
        				distq.push(dis + 1);
        				dict.erase(tmp);
        			}
        		}
        	}
        }
        return 0;
    }
};

int main()
{
	return 0;
}