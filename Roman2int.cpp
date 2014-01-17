#include <iostream>
#include <map>
using namespace std;

class Solution 
{
public:
    int romanToInt(string s) 
    {
    	map<string, int> r2n;
    	int r = 0;
    	string t, t1;
    	r2n.insert(pair<string, int>("M", 1000));
    	r2n.insert(pair<string, int>("CM", 900));
    	r2n.insert(pair<string, int>("D", 500));
    	r2n.insert(pair<string, int>("CD", 400));
    	r2n.insert(pair<string, int>("C", 100));
    	r2n.insert(pair<string, int>("XC", 90));
    	r2n.insert(pair<string, int>("L", 50));
    	r2n.insert(pair<string, int>("XL", 40));
    	r2n.insert(pair<string, int>("X", 10));
    	r2n.insert(pair<string, int>("IX", 9));
    	r2n.insert(pair<string, int>("V", 5));
    	r2n.insert(pair<string, int>("IV", 4));
    	r2n.insert(pair<string, int>("I", 1));
        for (int i = 0; i < s.size(); i++)
        {
        	t = s[i];
        	cout << r2n[t] << endl;
        	if (i + 1 == s.size()) 
        	{
        		r += r2n[t];
        		break;
        	}
        	t1 = s[i + 1];
     		if (r2n[t] >= r2n[t1]) 
     		{
     			r += r2n[t];
     		}
     		else 
     		{
     			t += t1;
     			r += r2n[t];
     			i++; 
     		}
        }
        return r;
    }
};
int main()
{
	Solution s;
	cout << s.romanToInt("MCMXCVI") << endl;
	return 0;
}