package FaceBook;

/**
 * Created by xyunpeng on 1/3/16.
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        int head = 0, tail = numbers.length - 1;
        while (head < tail) {
            int t = numbers[head] + numbers[tail];
            if (t == target) {
                res[0] = head + 1;
                res[1] = tail + 1;
                return res;
            } else if (t < target) {
                head++;
            } else {
                tail--;
            }
        }

        return res;
    }
}

//还有个two sum III在linkedin里面