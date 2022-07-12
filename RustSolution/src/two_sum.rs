pub struct Solution {
    name: String,
}

impl Solution {
    pub fn new(name: String) -> Solution{
        Solution { name }
    }
}

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut result = Vec::new();
        if nums.len() < 2 {
            return result;
        }

        let mut v = nums;
        v.sort();
        let mut i = 0;
        let mut j = v.len() - 1;
        while i < j {
            if v[i] + v[j] == target {
                result.push(i as i32);
                result.push(j as i32);
                return result;
            } else if v[i] + v[j] > target {
                j -= 1;
            } else {
                i += 1;
            }
        }

        result
    }
}