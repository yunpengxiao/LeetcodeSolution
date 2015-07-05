#include <iostream>
#include <cstring>
using namespace std;

class Solution {
public:
    int removeElement(int A[], int n, int elem) 
    {
    	if (n == 1) 
    	{
    		if (A[0] == elem) return 0;
    			else return 1;
    	}
    	if (n == 0) return 0;
        int leng = n;
        int index = 0;
        while (index < leng)
        {
        	if (A[index] == elem)
        	{
        		for (int i = index; i < leng - 1; i++)
        			A[i] = A[i + 1];
        		leng--;
        		continue;
        	}
        	index++;
        }
        return leng;
    }
};

int main()
{
	Solution s;
	int a[2] = {3, 3};
	cout << s.removeElement(a, 2, 3) << endl;
	return 0;
}