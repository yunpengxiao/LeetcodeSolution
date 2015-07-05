#include <iostream>
using namespace std;

class Solution {
public:
    int removeDuplicates(int A[], int n) 
    {
    	if (n < 2) return n;
    	int leng = n;
        int i = 1;
        while (i != leng)
        {
        	if (A[i] == A[i - 1])
        	{
        		for (int j = i; j < leng - 1; j++)
        		{
        			A[j] = A[j + 1];
        		}
        		leng--;
        	}
        	else i++;
        }
        return leng;
    }
};
int main()
{

	return 0;
}