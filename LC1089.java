/*1089. Duplicate Zeros

Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.

 

Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]
 

Note:

1 <= arr.length <= 10000
0 <= arr[i] <= 9*/



class Solution {
   public void duplicateZeros(int[] arr) {

       int countOfZeroes = 0;
       
       for (int a: arr)
       {
           if (a == 0) countOfZeroes++;
       }
       
        
       int i = arr.length-1;
       int j = arr.length + countOfZeroes - 1;
       
       while (i>=0 && j>=0)
       {
           if (arr[i]==0)
           {
               if(j<arr.length)
               {
                   arr[j]=arr[i];
               }
                   j--;
                   
                if(j<arr.length)
                {
                   arr[j]=arr[i];
                }
                   
               j--;
               i--;
 
           }
           else{
                
               if(j<arr.length)
               {
                   arr[j]=arr[i];
               }
               
               j--;
               i--;
               
           }
           
           
       }
       
   }
}
