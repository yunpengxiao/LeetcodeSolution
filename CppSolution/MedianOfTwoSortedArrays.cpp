//Solution is in http://leetcode.com/2011/03/median-of-two-sorted-arrays.html

#include <iostream>
using namespace std;

class Solution {
private:
	int MedianA;
	int MedianB;
	double CulBaseCase(int insert, int N[], int size)
	{
		int t1, t2;
		if ((size + 1) % 2 == 0)
		{
			t1 = N[size / 2];
			if (insert == t1) return insert;
			if (insert > t1) 
			{
				t2 = N[size / 2 + 1];
				if (insert < t2) return (t1 + insert) / 2.0;
				else return (t2 + t1) / 2.0;
			}
			else
			{
				t2 = N[size / 2 - 1];
                if (insert < t2) return (t2 + t1) / 2.0;
                else return (t1 + insert) / 2.0;
			}
		}
        else 
        {
            t1 = N[size / 2];
            if (insert == t1) return insert;
            if (insert > t1) return t1;
            else
            {
                t2 = N[size / 2 - 1];
                if (insert < t2) return t2;
                else return insert;
            }
        }
	}
    double basecase(int A[], int m, int B[], int n)
    {
        int *c = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < m + n; i++)
        {
            if (m != 0 && (A[index1] < B[index2] || index2 == n))
            {
                if (index1 != m )
                {
                    c[i] = A[index1];
                    //cout << c[i] << endl;
                    index1++;
                    continue; 
                }

            }
            if (n != 0 && (A[index1] >= B[index2] || index1 == m))
            {
                if (index2 != n)
                {
                    c[i] = B[index2];
                    //cout << c[i] << endl;
                    index2++;
                    continue;
                }
            }
        }

        if ((m + n) % 2 == 0) return (c[(m + n) / 2] + c[(m + n) / 2 - 1]) / 2.0;
        else return c[(m + n) / 2];

    }
public:
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
        if (m == 0 || n == 0)
        {
            return basecase(A, m, B, n);
        }
        if (m == 1 || n == 1)
        {
            //cout << "Begin to find mid!" << endl;
        	//int t = (n + 1) / 2;
        	if (m == 1) 
        	{
                //cout << "A became 1 first and B is " << n << " now"<< endl;
                //cout << "The only element in A is " << A[0] << endl;
        		return basecase(A, m, B, n);
        	}
        	if (n == 1)
        	{
                //cout << "B became 1 first and A is " << m << " now"<< endl;
                //cout << "The only element in B is " << B[0] << endl;
        		return basecase(A, m, B, n);
        	}
        }
        if (m == 2 || n == 2)
        {
            //cout << "Begin to find mid because of A or B gets to 2!" << endl;
            //cout << "B is " << n << " and A is " << m << endl;
            return basecase(A, m, B, n);
        }
        else
        {
        	MedianA = m / 2;
        	MedianB = n / 2;
            int t;
            //cout << "MA is " << MedianA << " and MB is " << MedianB << endl; 
        	if (A[MedianA] >= B[MedianB])
        	{
                //cout << "The median locates in the end of B and the head of A!" << endl;
                if (n % 2 != 0) 
                {
                    t = (MedianB > m - MedianA - 1)? m - MedianA - 1: MedianB;
                }
                else
                {
                    t = (MedianB - 1 > m - MedianA - 1)? m - MedianA - 1: MedianB - 1;
                }
                //cout << "Cut " << t << " element from two array!" << endl;
        		// int *tA = new int(m - t);
        		// int *tB = new int(n - t);
        		// for (int i = 0; i < m - t; i++)
        		// {
        		// 	tA[i] = A[i];
        		// }
        		// for (int i = 0; i < n - t; i++)
        		// {
        		// 	tB[i] = B[i + t];
        		// }
                //cout << "The size of array became A: " << m - t << " B: " << n - t << endl;
        		return findMedianSortedArrays(A, m - t, B + t, n - t);
        	}
        	else
        	{
                //cout << "The median locates in the end of A and the head of B!" << endl;
                if (m % 2 != 0)
                {
                    t = (MedianA > n - MedianB - 1)? n - MedianB - 1: MedianA;
                }
        		else
                {
                    t = (MedianA - 1 > n - MedianB - 1)? n - MedianB - 1: MedianA - 1;
                }
                //cout << "Cut " << t << " element from two array!" << endl;
        		// int *tA = new int(m - t);
        		// int *tB = new int(n - t);
        		// for (int i = 0; i < m - t; i++)
        		// {
        		// 	tA[i] = A[i + t];
        		// }
        		// for (int i = 0; i < n - t; i++)
        		// {
        		// 	tB[i] = B[i];
        		// }
                //cout << "The size of array became A: " << m - t << " B: " << n - t << endl;
        		return findMedianSortedArrays(A + t, m - t, B, n - t);
        	}

        }
    }
};

int main()
{
    int cA[3] = {1, 2, 3}; 
    int cB[5] = {4, 5, 6, 7, 8};
    Solution s1;
    cout << s1.findMedianSortedArrays(cA, 3, cB, 5) << endl; 
	return 0;
}