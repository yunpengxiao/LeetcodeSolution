#include <iostream>
#include <algorithm>
using namespace std;

class Solution 
{
public:
    string addBinary(string a, string b) 
    {
    	string res = "";
    	int t = 0;
    	int i = a.size() - 1;
    	int j = b.size() - 1;
    	int sum;
    	while (i >= 0 && j >= 0)
    	{
    		sum = (a[i] - '0') + (b[j] - '0') + t;
    		t = sum / 2;
    		sum = sum % 2;
    		res += sum + '0';
    		i--;
    		j--;
    	}
    	while (i >= 0)
    	{
    		sum = (a[i] - '0') + t;
    		t = sum / 2;
    		sum = sum % 2;
    		res += sum + '0';
    		i--;
    	}
    	while (j >= 0)
    	{
    		sum = (b[j] - '0') + t;
    		t = sum / 2;
    		sum = sum % 2;
    		res += sum + '0';
    		j--;
    	}
    	if (t == 1)
    		res += t + '0';
    	reverse(res.begin(), res.end());
    	return res;
    }
};

int main()
{
	Solution s;
	string a = "1";
	string b = "1";
	cout << s.addBinary(a, b) << endl;
	return 0;
}