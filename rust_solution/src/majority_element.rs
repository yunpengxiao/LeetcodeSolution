pub struct Solution {}

impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        let mut nums = nums;
        nums.sort();
        return nums[nums.len() / 2];
    }
}