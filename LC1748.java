// 1748. Sum of Unique Elements

// You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.

// Return the sum of all the unique elements of nums.

 

// Example 1:

// Input: nums = [1,2,3,2]
// Output: 4
// Explanation: The unique elements are [1,3], and the sum is 4.
// Example 2:

// Input: nums = [1,1,1,1,1]
// Output: 0
// Explanation: There are no unique elements, and the sum is 0.
// Example 3:

// Input: nums = [1,2,3,4,5]
// Output: 15
// Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
 

// Constraints:

// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100

// Alternate solution using hashmap
// class Solution {
//     public int sumOfUnique(int[] nums) {
//         int res = 0;
//         Map<Integer,Integer> map = new HashMap<>();
//         for(int i = 0;i<nums.length;i++){
//             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//             if(map.get(nums[i]) == 1)res+=nums[i];
//             else if(map.get(nums[i]) == 2)res-=nums[i];
//         }
//         return res;
//     }
// }

// Quicker solution using array
class Solution {
    public int sumOfUnique(int[] nums) {
        int sum = 0;
        int map[] = new int[101];
        for (int num : nums) {
            if (map[num] == 0) {
                sum += num;
            } else if (map[num] == 1) {
                sum -= num;
            }
            map[num] += 1;
        }
        
        return sum;
    }
}
