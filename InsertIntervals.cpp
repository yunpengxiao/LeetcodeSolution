#include <iostream>
#include <vector>
#include "Utility.h"
using namespace std;

class Solution
{
public:
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval)
    {
        vector<Interval> result;
        if (intervals.size() == 0)
        {
            result.push_back(newInterval);
        }
        else
        {
            int i = 0;
            while (i < intervals.size() && intervals[i].end < newInterval.start)
            {
                result.push_back(intervals[i]);
                i++;
            }
            if (i < intervals.size())
            {
                newInterval.start = min(newInterval.start, intervals[i].start);
            }
            result.push_back(newInterval);
            while (i < intervals.size() && intervals[i].start <= result[result.size() - 1].end)
            {
                result[result.size() - 1].end = max(intervals[i].end, result[result.size() - 1].end);
                i++;
            }
            while (i < intervals.size())
            {
                result.push_back(intervals[i]);
                i++;
            }
        }
        return result;
    }
};

int main()
{
    return 0;
}
