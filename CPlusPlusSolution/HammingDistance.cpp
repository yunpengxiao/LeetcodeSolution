class Solution
{
public:
    int hammingDistance(int x, int y)
    {
        auto ret = 0;
        auto value = x ^ y;

        while (value != 0)
        {
            ret++;
            value &= (value - 1);
        }

        return ret;
    }
}
