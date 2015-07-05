#include <iostream>
using namespace std;

class Solution
{
public:
    void merge(int A[], int m, int B[], int n)
    {
        if (B == NULL) return ;
        int len = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (index1 >= 0 && index2 >= 0)
        {
            if (A[index1] < B[index2])
            {
                A[len--] = A[index1--];
            }
            else
            {
                A[len--] = B[index2--];
            }
        }
        if (index2 != 0)
        {
            while (index2 >= 0)
            {
                A[len--] = B[index2--];
            }
        }
    }
};

int main()
{
    
    return 0;
}
