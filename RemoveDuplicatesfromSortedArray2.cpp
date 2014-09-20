#include <iostream>
using namespace std;

class Solution
{
public:
    int removeDuplicates(int A[], int n)
    {
        if (n == 0 || n == 1)
            return n;
        bool twice = false;
            //int result = n;
        for (int i = 1; i < n; i++)
        {
            if (A[i - 1] == A[i])
            {
                if (twice == false)
                    twice = true;
                else
                {
                    n--;
                    for (int j = i - 1; j < n; j++)
                    {
                        A[j] = A[j + 1];
                    }
                    i--;
                }
            }
            else
                twice = false;
        }
        return n;
    }
};

int main()
{
    return 0;
}
