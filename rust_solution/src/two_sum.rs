/*
Given an array of integers nums and an integer target, return the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/
use std::collections::HashMap;

pub struct Solution {}

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
    	let mut result = Vec::new();
        if nums.len() < 2 {
            return result;
        }

        let mut hm = HashMap::new();
        for i in 0..nums.len() {
            match hm.get(&(target - nums[i])) {
                Some(&index) => {
                    result.push(index as i32);
                    result.push(i as i32);
                    return result;
                }
                _ => {
                    hm.insert(nums[i], i);
                }
            }
        }

        result
    }
}
