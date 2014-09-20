#include <iostream>
#include <vector>
using namespace std;

class Solution
{    
public:
    vector<int> plusOne(vector<int> &digits)
    {
        int add = 1;
        for (int i = digits.size() - 1; i >= 0; i--)
        {
            digits[i] += add;
            if (digits[i] > 9)
            {
                add = 1;
                digits[i] = digits[i] % 10;
            }
            else
            {
                add = 0;
                break;
            }
        }
        if (add == 1)
            digits.insert(digits.begin(), 1);
        return digits;
    }
};

int main()
{
    
    return 0;
}
