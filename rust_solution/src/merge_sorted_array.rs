use std::i32;

pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
    let mut pointer = (m + n) as usize;
    let mut p1 = m - 1;
    let mut p2 = n - 1;
    while pointer > 0 {
        let v1 = if p1 >= 0 {
            nums1[p1 as usize]
        } else {
            i32::MIN
        };

        let v2 = if p2 >= 0 {
            nums2[p2 as usize]
        } else {
            i32::MIN
        };

        nums1[pointer - 1] = if v1 > v2 {
            p1 -= 1;
            v1
        } else {
            p2 -= 1;
            v2
        };
        pointer -= 1;
    }
}

#[test]
fn test_merge() {
    let mut vec1 = vec![1,2,3,0,0,0];
    merge(&mut vec1, 3, &mut vec![4,5,6], 3);
    assert_eq!(vec![1,2,3,4,5,6], vec1);
}