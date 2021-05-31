/*1832. Check if the Sentence Is Pangram

A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

 

Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false
 

Constraints:

1 <= sentence.length <= 1000
sentence consists of lowercase English letters.
*/

import java .util.*;
class Solution {
    public boolean checkIfPangram(String sentence) {
        
       char ch[] =  sentence.toCharArray();
        
       int pan[]=new int[26];
        
        for(int i=0;i<ch.length;i++){
            pan[ch[i]-'a']++;  // or else you can also do pan[ch[i]-97]++;  
			// ascii value of 'a' is 97 , value increments at the position of the found alphabet.  a-97=0 , b-97=1 , c-97=2 .... z-97=25
        }
        
        for(int i=0;i<26;i++){
            if(pan[i]<1) return false;      //checking if any alphabate is missing in that sentence
        }
        
        return true;
    }
}

