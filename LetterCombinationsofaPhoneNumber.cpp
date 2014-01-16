#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution {
private:
	vector<string> num2letter;
public:
	Solution()
	{
		num2letter.push_back(" ");
		num2letter.push_back(" ");
		num2letter.push_back("abc");
		num2letter.push_back("def");
		num2letter.push_back("ghi");
		num2letter.push_back("jkl");
		num2letter.push_back("mno");
		num2letter.push_back("pqrs");
		num2letter.push_back("tuv");
		num2letter.push_back("wxyz");
	}
    vector<string> letterCombinations(string digits) 
    {
    	vector<string> r;
    	vector<string> t;
    	string d;
    	if (digits.size() == 0) 
    	{
    		r.push_back(d);
    		return r;
    	}
    	if (digits.size() == 1) 
    	{
    		for (int i = 0; i < num2letter[digits[0] - '0'].size(); i++)
    		{
    			d = num2letter[digits[0] - '0'][i];
    			r.push_back(d);
    		}
    		return r;
    	}
    	else
    	{
    		d = digits.substr(1, digits.size() - 1);
    		t = letterCombinations(d);
    		d = num2letter[digits[0] - '0'];
    		for (int i = 0; i < t.size(); i++)
    		{
    			for (int j = 0; j < d.size(); j++)
    			{
    				r.push_back(d[j] + t[i]);
    			}
    		}
    	}
    	return r;
    }
};
int main()
{

	return 0;
}