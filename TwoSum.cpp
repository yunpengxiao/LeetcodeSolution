#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) 
    {
    	vector<int> a;
    	int index1, index2;
        for (int i = 0; i < numbers.size(); i++)
        {
        	for (int j = i + 1; j < numbers.size(); j++)
        	{
        		if ((numbers[i] + numbers[j]) == target)
        		{
        			index1 = i;
        			index2 = j;
        			break;
        		}
        	}
        }
        if (index1 < index2)
        {
        	a.push_back(index1 + 1);
        	a.push_back(index2 + 1);
        } 
        else
        {
        	a.push_back(index2 + 1);
        	a.push_back(index1 + 1);
        }
        return a;
    }
};

int main()
{
	Solution x;
	vector<int> n;
	n.push_back(2);
	n.push_back(7);
	n.push_back(11);
	n.push_back(15);
	int t = 9;
	vector<int> r = x.twoSum(n, t);
	cout << r[0] << " and " << r[1] << endl;
	//cout << "hello world!" << endl;
	return 0;
}