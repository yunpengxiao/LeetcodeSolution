#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution 
{
public:
    vector<string> anagrams(vector<string> &strs) 
    {
    	map<string, int> m;
    	multimap<string, string> mm;
    	string s;
    	vector<string> result;
    	if (strs.size() < 2)
    	{
    		return result;
    	} 

    	for (vector<string>::iterator it = strs.begin(); it != strs.end(); ++it)
    	{
    		s = *it;
    		sort(s.begin(), s.end());
    		if (m.find(s) == m.end())
    		{
    			m.insert(make_pair(s, 0));
    		}
    		m[s]++;
    		mm.insert(make_pair(s, *it));
    	}

    	for (map<string, int>::iterator it = m.begin(); it != m.end(); ++it)
    	{
    		s = it->first;
    		if (it->second < 2) continue;
    		else
    		{
    			pair<multimap<string, string>::iterator, std::multimap<string, string>::iterator> p = mm.equal_range(s);
    			for (multimap<string, string>::iterator it = p.first; it != p.second; ++it)
    			{
    				result.push_back(it->second);
    			}
    		}
    	}
    	return result;
    }

};

int main()
{
	Solution s;
	vector<string> t;
	vector<string> r;
	t.push_back("eat");
	t.push_back("ate");
	t.push_back("and");
	r = s.anagrams(t);
	for (vector<string>::iterator it = r.begin(); it != r.end(); ++it)
	{
		cout << *it << endl;
	}
	return 0;
}
