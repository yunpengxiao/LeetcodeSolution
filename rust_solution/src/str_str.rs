pub struct Solution {}

impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
        if needle.len() == 0 {
            return 0;
        }

        let mut i = 0;
        while i + needle.len() <= haystack.len() {
            if &haystack.as_bytes()[i..i + needle.len()] == needle.as_bytes() {
                return i as i32;
            } else {
                i += 1;
            }
        }

        -1
    }
}