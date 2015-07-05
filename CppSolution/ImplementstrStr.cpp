#include <iostream>
using namespace std;

class Solution {
public:
    char *strStr(char *haystack, char *needle) 
    {
    	if (haystack == NULL || needle == NULL) return NULL;
    	int m = 0; 
    	int n = 0;
    	int j; 
    	while ('\0' != haystack[m])
    	{
    		m++;
    	}
    	while ('\0' != needle[n])
    	{
    		n++;
    	}
    	if (m == 0 && n != 0) return NULL;
    	if (m != 0 && n == 0) return haystack;
    	if (m == 0 && n == 0) return haystack;
    	for (int i = 0; i < m; i++)
    	{
    		for (j = 0; j < n; j++)
    		{
    			if (i + j >= m) return NULL;
    			if (needle[j] != haystack[i + j]) break;
    		}
    		if (j == n) return haystack + i;
    	}
    	return NULL;    
    }
};

int main()
{
	return 0;
}