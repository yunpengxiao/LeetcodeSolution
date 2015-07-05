#include <iostream>
using namespace std;


class Solution 
{
public:
	void sortColors(int A[], int n) 
	{
		if (n == 0)
			return;
		int first = 0;
		int last = n - 1;
		int index = 0;
		while (index <= last)
		{
			if (A[index] == 0)
			{
				int t = A[first];
				A[first] = A[index];
				A[index] = t;
				first++;
				index++;
			}
			else if (A[index] == 2)
			{
				int t = A[last];
				A[last] = A[index];
				A[index] = t;
				last--;
			}
			else
				index++;
		}
    }
};

int main()
{

	return 0;
}