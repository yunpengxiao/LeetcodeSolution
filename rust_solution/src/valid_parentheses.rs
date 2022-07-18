pub struct Solution {}

impl Solution {
    pub fn is_valid(s: String) -> bool {
        let mut parentheses = Vec::new();
        if s.len() == 0 {
            return true;
        }

        for i in 0..s.len() {
            let c = s.as_bytes()[i] as char;
            if c == '(' || c == '[' || c == '{' {
                parentheses.push(c);
            } else if c == ')' {
                if parentheses.len() > 0 && parentheses.pop().unwrap() == '(' {
                    continue;
                } else {
                    return false;
                }
            } else if c == ']' {
                if parentheses.len() > 0 && parentheses.pop().unwrap() == '[' {
                    continue;
                } else {
                    return false;
                }
            } else if c == '}' {
                if parentheses.len() > 0 && parentheses.pop().unwrap() == '{' {
                    continue;
                } else {
                    return false;
                }
            }
        }

        parentheses.len() == 0
    }
}