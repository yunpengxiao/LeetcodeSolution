mod two_sum;
mod longest_common_prefix;
mod valid_parentheses;
mod str_str;

fn main() {
    let nums = [1, 2, 3, 4, 5];
    let result = two_sum::Solution::two_sum(nums.to_vec(), 6);
    println!("{} {}", result[0], result[1]);

    let strs = vec!["123".to_string(), "1234".to_string()];
    println!("{}", longest_common_prefix::Solution::longest_common_prefix(strs));
}
