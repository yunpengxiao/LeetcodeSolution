#include <iostream>
using namespace std;

class Solution
{
public:
    int singleNumber(int A[], int n)
    {
        int t = A[0];
        for (int i = 1; i < n; i++)
        {
            t = t ^ A[i];
        }
        return t;
    }
};

int main()
{
    return 0;
}
