/*
    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".
*/
pub struct Solution {}

impl Solution {
    pub fn longest_common_prefix(strs: &Vec<String>) -> String {
        let mut result = String::from("");
        let mut i = 0;
        if strs.len() < 1 || strs[0].len() < 1 {
            return result;
        }

        let mut c;
        loop {
            c = strs[0].as_bytes()[i] as char;
            for s in strs {
                if i == s.len() || s.as_bytes()[i] as char != c {
                    return result;
                } 
            }
            result.push(c);
            i += 1;
        }
    }
}