using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpSulutions
{
    class ContainerWithMostWater
    {
        public int MaxArea(int[] height)
        {
            if (height.Length == 0 || height.Length == 1)
            {
                return 0;
            }

            int start = 0;
            int end = height.Length;
            int maxArea = 0;
            while (start < end)
            {
                int area = Math.Min(height[start], height[end]) * (end - start);
                if (maxArea < area)
                {
                    maxArea = area;
                }

                if (height[start] > height[end])
                {
                    end++;
                }
                else
                {
                    start++;
                }
            }

            return maxArea;
        }
    }
}
