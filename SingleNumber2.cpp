#include <iostream>
#include <climits>
using namespace std;

class Solution
{
public:
    int singleNumber(int A[], int n)
    {
        int count[32];
        memset(count, 0, sizeof(count));
        int t;
        for (int i = 0; i < n; i++)
        {
            unsigned tt = A[i] + INT_MAX;
            for (int j = 0; j < 32; j++)
            {
                t = (tt >> j) & 1;
                count[j] += t;
            }
        }

        t = 0;
        for (int i = 0; i < 32; i++)
        {
            t += ((count[i] % 3) << i);
        }
        return t - INT_MAX;
    }
};

int main()
{
    Solution s;
    int a[1];
    a[0] = 1;
    cout << s.singleNumber(a, 1) << endl;
    return 0;
}
