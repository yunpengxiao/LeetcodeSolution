pub struct Solution {}

impl Solution {
    pub fn generate(num_rows: i32) -> Vec<Vec<i32>> {
        let mut result = Vec::new();
        result.push(vec![1]);
        if num_rows == 1 {
            return result;
        }

        for i in 1..num_rows {
            let mut line = Vec::new();
            line.push(1);
            let previous_line = &result[i as usize - 1];
            for j in 1..previous_line.len() {
                line.push(previous_line[j as usize] + previous_line[j as usize - 1]);
            }
            line.push(1);
            result.push(line);
        }

        result
    }
}