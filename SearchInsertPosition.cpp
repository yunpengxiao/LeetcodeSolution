#include <iostream>
using namespace std;

class Solution 
{
public:
    int searchInsert(int A[], int n, int target) 
    {
		int mid, start, end;
		start = 0;
		end = n - 1;
		//mid = (start + end) / 2;
		while (start <= end)
		{
			mid = (start + end) / 2;
			if (A[mid] == target) return mid;
			if (A[mid] > target) end = mid - 1;
			else start = mid + 1;
		}
		if (A[mid] > target) return mid;
		else return mid + 1;        
    }
};
int main()
{

	return 0;
}