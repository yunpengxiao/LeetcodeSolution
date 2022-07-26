pub struct Solution {}

impl Solution {
    pub fn plus_one(digits: Vec<i32>) -> Vec<i32> {
        let mut result = Vec::new();
        let mut next = 0;
        let mut digits = digits;
        let mut d = digits.pop().unwrap() + 1;
        while digits.len() >= 0 {
            if d >= 10 {
                next = 1;
                d = d % 10;
            } else {
                next = 0;
            }
            result.push(d);
            if digits.len() == 0 {
                break;
            }
            d = digits.pop().unwrap() + next;
        }

        if next > 0 {
            result.push(next);
        }
        result.reverse();
        result
    }
}