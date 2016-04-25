package Google;

/**
 * Created by xyunpeng on 4/24/16.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int leftEdge = 0;
        int rightEdge = height.length - 1;
        while (leftEdge < rightEdge && height[leftEdge] < height[leftEdge + 1]) {
            leftEdge++;
        }

        while (leftEdge < rightEdge && height[rightEdge] < height[rightEdge - 1]) {
            rightEdge--;
        }

        int sum = 0;
        while (leftEdge < rightEdge) {
            int left = height[leftEdge];
            int right = height[rightEdge];
            if (left < right) {
                while (leftEdge < rightEdge && left > height[++leftEdge]) {
                    sum += (left - height[leftEdge]);
                }
            } else {
                while (leftEdge < rightEdge && right > height[--rightEdge]) {
                    sum += (right - height[rightEdge]);
                }
            }
        }

        return sum;
    }
}
