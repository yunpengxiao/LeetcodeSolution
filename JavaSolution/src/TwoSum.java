import java.util.HashMap;

/**
 * Created by xyunpeng on 12/30/15.
 */
public class TwoSum {
    // 记住返回值的index从1开始
    // 最优代码
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);               //这里+1没有赋值的时候+1方便
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                res[0] = i + 1;                                  //赋值的时候 + 1最好
                res[1] = map.get(target - nums[i]) + 1;          //不需要比较index的大小,因为i在前一定会被先放进去
                return res;
            }
        }
        return res;
    }
}
