#include <iostream>
#include <string>
#include <map>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s)
    {
        if (s.size() == 0 || s.size() == 1)
        {
            return s.size();
        }
        
        int maxlen = 0;
        //map<char, int> charMap;
        int as[256];
        for (int i = 0; i < s.size(); i++)
        {
        //    charMap.clear();
        //    charMap.insert(make_pair(s[i], i));
            
            memset(as, -1, sizeof(as));
            as[s[i]] = i;
            
            for (int j = i + 1; j < s.size(); j++)
            {
                //if (charMap.find(s[j]) != charMap.end())
                if (as[s[j]] != -1)
                {
                    if (maxlen < j - i)
                    {
                        maxlen = j - i;
                    }
                    i = as[s[j]];
                    //i = charMap[s[j]];
                    break;
                }
                if (j == s.size() - 1)
                {
                    if (maxlen < j - i + 1)
                        return j - i + 1;
                    else
                        break;
                }
                //charMap.insert(make_pair(s[j], j));
                as[s[j]] = j;
            }
        }
        return maxlen;
    }

};

int main()
{
	string t = "qopubjguxhxdipfzwswybgfylqvjzhar";
	Solution s;
	cout << s.lengthOfLongestSubstring(t) << endl;
	return 0;
}
