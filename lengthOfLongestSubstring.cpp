#include <iostream>
#include <string>
#include <cstring>
using namespace std;

class Solution {
private:
	char letters[26];
	int maxsub;
public:
    int lengthOfLongestSubstring(string s) 
    {
    	if (s.size() == 0) return 0;
    	if (s.size() == 1) return 1;
        maxsub = 0;
        int thissub;
        for (int i = 0; i < s.size() - 1; i++)
        {
        	thissub = 1;
        	memset(letters, 0, sizeof(letters));
        	letters[s[i] - 'a']++;
        	for (int j = i + 1; j < s.size(); j++)
        	{
        		if (letters[s[j] - 'a'] != 0) 
        		{
        			break;
        		}
        		else 
        		{
        			letters[s[j] - 'a']++;
        			thissub++;
        		}
        	}
        	if (thissub > maxsub) maxsub = thissub;
        }
        return maxsub;
    }
};

int main()
{
	string t = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
	Solution s;
	cout << s.lengthOfLongestSubstring(t) << endl;
	return 0;
}