class Solution
{
public:
	// My own version
	std::vector<int> nextGreaterElement(std::vector<int>& findNums, std::vector<int>& nums)
	{
		auto len = nums.size();
		std::vector<int> ret;
		if (len == 0)
		{
			return ret;
		}

		std::vector<int> positionOfNextGreaterElement(len, 0);
		positionOfNextGreaterElement[len - 1] = -1;
		for (int i = len - 2; i >= 0; i--)
		{
			if (nums[i] < nums[i + 1])
			{
				positionOfNextGreaterElement[i] = i + 1;
			}
			else
			{
				int t = i + 1;
				while (nums[i] > nums[t])
				{
					if (positionOfNextGreaterElement[t] == -1)
					{
						t = -1;
						break;
					}
					else
					{
						t = positionOfNextGreaterElement[t];
					}
				}
				positionOfNextGreaterElement[i] = t;
			}

			// std::cout << nums[positionOfNextGreaterElement[i]] << std::endl;
		}

		std::unordered_map<int, int> positionMap;
		for (int i = 0; i < nums.size(); i++)
		{
			positionMap[nums[i]] = i;
		}

		for (int i = 0; i < findNums.size(); i++)
		{
			int x = positionOfNextGreaterElement[positionMap[findNums[i]]];
			if (x == -1)
			{
				ret.push_back(-1);
			}
			else
			{
				ret.push_back(nums[x]);
			}
		}

		return ret;
	}

	// A better algorithm
	std::vector<int> nextGreaterElement(std::vector<int>& findNums, std::vector<int>& nums)
	{
		std::vector<int> ret;
		if (nums.size() == 0)
		{
			return ret;
		}

		std::unordered_map<int, int> nextGreaterElementMap;
		std::stack<int> numsStack;

		for (auto n : nums)
		{
			while (!numsStack.empty() && numsStack.top() < n)
			{
				nextGreaterElementMap[numsStack.top()] = n;
				numsStack.pop();
			}
			numsStack.push(n);
		}

		while (!numsStack.empty())
		{
			nextGreaterElementMap[numsStack.top()] = -1;
			numsStack.pop();			
		}

		for (auto n : findNums)
		{
			ret.push_back(nextGreaterElementMap[n]);
		}

		return ret;
	}
};