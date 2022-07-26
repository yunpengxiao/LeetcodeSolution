use std::collections::HashMap;

pub struct Solution {}

impl Solution {
    pub fn contains_duplicate(nums: Vec<i32>) -> bool {
        let mut hm = HashMap::new();
        for n in &nums {
            if hm.get(&n) == Some(&1) {
                return true;
            } else {
                hm.insert(n, 1);
            }
        }
        false
    }
}