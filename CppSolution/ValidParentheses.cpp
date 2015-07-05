#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool isValid(string s) 
    {
        vector<char> stack;
        for (int i = 0; i < s.size(); i++)
        {
        	if (s[i] == '[' || s[i] == '{' || s[i] == '(') stack.push_back(s[i]);
        	else if (s[i] == ']' || s[i] == '}' || s[i] == ')')
        	{
        		if (stack.empty()) return false;
        		else 
        		{
        			if (s[i] == ')' && stack[stack.size() - 1] == '(') stack.pop_back();
        			else if (s[i] == ']' && stack[stack.size() - 1] == '[') stack.pop_back();
        			else if (s[i] == '}' && stack[stack.size() - 1] == '{') stack.pop_back();
        			else return false;
        		}
        	}
        }
        if (stack.empty()) return true;
        else return false;
    }
};

int main()
{

	return 0;
}