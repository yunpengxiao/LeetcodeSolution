mod two_sum;

fn main() {
    let nums = [1, 2, 3, 4, 5];
    let result = two_sum::Solution::two_sum(nums.to_vec(), 6);
    println!("{} {}", result[0], result[1]);
}
