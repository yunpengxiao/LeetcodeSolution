class Solution
{
public:
    vector<int> selfDividingNumbers(int left, int right)
    {
        vector<int> ret;
        for (int i = left; i <= right; i++)
        {
            if (isSelfDividingNumber(i))
            {
                ret.push_back(i);
            }
        }

        return ret;
    }

private:
    bool isSelfDividingNumber(int num)
    {
        int tmp = num;
        while (tmp != 0)
        {
            int n = tmp % 10;
            if (n == 0 || num % n != 0) return false;
            tmp = tmp / 10;
        }

        return true;
    }
};
