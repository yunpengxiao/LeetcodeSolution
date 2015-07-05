#include <iostream>
#include <vector>
#include <algorithm>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    static bool myfunc(const Interval &a, const Interval &b)
    {
        return (a.start < b.start);
    }
    vector<Interval> merge(vector<Interval> &intervals)
    {
        vector<Interval> result;
        if (intervals.size() == 1 || intervals.size() == 0)
            return intervals;
        sort(intervals.begin(), intervals.end(), Solution::myfunc);
        result.push_back(*(intervals.begin()));
        vector<Interval>::iterator it = intervals.begin() + 1;
        while (it != intervals.end())
        {
            if (result[result.size() - 1].end >= (it)->start)
            {
                result[result.size() - 1].end = max((it)->end, result[result.size() - 1].end);                
            }
            else
            {
                result.push_back(*it);
            }
            ++it;
        }
        return intervals;
    }
};

int main()
{
    return 0;
}
