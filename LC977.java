/*
 * 977. Squares of a Sorted Array Easy
 * 
 * Given an integer array nums sorted in non-decreasing order, return an
 * array of the squares of each number sorted in non-decreasing order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-4,-1,0,3,10] Output: [0,1,9,16,100] Explanation: After
 * squaring, the array becomes [16,1,0,9,100]. After sorting, it becomes
 * [0,1,9,16,100]. Example 2:
 * 
 * Input: nums = [-7,-3,2,3,11] Output: [4,9,9,49,121]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104 -104 <= nums[i] <= 104 nums is sorted in
 * non-decreasing order.
 */

// This solution uses a Two Pointer Technique
// We compare the square of the element at the right pointer
// with the element at the left pointer
// We add the max square value to the output array, 
// then we move that element's pointer closer to 
// the opposite side
// We repeat this process until the pointers are equal
// or one pointer has moved past the other

class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int result[] = new int [nums.length];
        
        // define pointers
        int left = 0;
        int right = nums.length - 1;
        
        for(int i=nums.length-1;i>=0;i--)
        {
            if ((nums[left]*nums[left]) > nums[right]*nums[right])
            {
                result[i]=nums[left]*nums[left];
                left++;
            }
            else
            {
                result[i]=nums[right]*nums[right];
                right--;
            }
        }
       
        return result;
        
    }
}