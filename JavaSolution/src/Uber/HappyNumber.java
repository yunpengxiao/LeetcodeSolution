package Uber;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xyunpeng on 4/10/16.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        int cur = n;
        Set<Integer> visited = new HashSet<>();

        while (!visited.contains(cur)) {
            visited.add(cur);
            cur = calculate(cur);
        }

        return cur == 1;
    }

    private int calculate(int n) {
        int sum = 0;
        int p = n;
        while (p != 0) {
            sum += (p % 10) * (p % 10);
            p = p / 10;
        }
        return sum;
    }
}
