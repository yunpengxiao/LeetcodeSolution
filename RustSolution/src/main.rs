mod two_sum;

fn main() {
    let _s = two_sum::Solution::new("2 Sum".to_string());
    let nums = [1, 2, 3, 4, 5];
    let result = two_sum::Solution::two_sum(nums.to_vec(), 6);
    println!("{} {}", result[0], result[1]);
}
