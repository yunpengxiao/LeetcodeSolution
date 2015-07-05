#include "Utility.h"

class Solution 
{
public:
    string simplifyPath(string path) 
    {
    	vector<string> folder;
    	if (path.size() <= 1)
    		return path;
    	int index;
    	int i = 0;
    	string temp;
    	while (i < path.size())
    	{
    		index = ++i;
    		while (i < path.size() && path[i] != '/')
    			i++;
    		temp = path.substr(index, i - index);
    		if (temp == "..")
    		{
    			if (folder.size() > 0) 
    				folder.pop_back();
    		}
    		else if (temp == "." || temp == "")
    			continue;
    		else
    			folder.push_back(temp);
    	}
    	if (folder.size() == 0)
    		return "/";
    	string res = "";
    	for (int j = 0; j < folder.size(); j++)
    	{
    		res += "/" + folder[j];
    	}

    	return res;
    }
};

int main()
{
	string t = "/a/b/../";
	Solution ss;
	cout << ss.simplifyPath(t) << endl;
	return 0;
}