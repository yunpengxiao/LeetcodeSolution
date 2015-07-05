#include <iostream>
#include <sstream>
#include <map>
using namespace std;

class Solution
{
public:
    string countAndSay1(string s)
    {
        string result;
        int count = 1;
        if (s.size() == 1)
        {
            result += '1';
            result += s[0];
            return result;
        }
        for (int i = 1; i < s.size(); i++)
        {
            if (s[i] != s[i - 1])
            {
                result += count + '0';
                result += s[i - 1];
                count = 1;
            }
            else
                count++;
            if (i == s.size() - 1)
            {
                result += count + '0';
                result += s[i];
            }
        }
        return result;
    }
    string countAndSay(int n)
    {
        string t = "1";
        if (n == 1) return t;
        for (int i = 1; i < n; i++)
        {
            t = countAndSay1(t);
        }        
        return t;
    }
};

int main()
{
    Solution s;
    s.countAndSay(5);
    return 0;
}
