package Linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by xyunpeng on 1/4/16.
 */
public class TwoSum {
    // Add the number to an internal data structure.

    private HashMap<Integer, Integer> nums;
    private ArrayList<Integer> elements;

    public TwoSum() {
        nums = new HashMap<>();
        elements = new ArrayList<>();
    }

    public void add(int number) {
        elements.add(number);
        if (nums.containsKey(number)) {
            nums.put(number, nums.get(number) + 1);
        } else {
            nums.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int i : elements) {
            if (nums.containsKey(value - i)) {
                if (value - i == i && nums.get(i) < 2) {
                    continue;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}

// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);