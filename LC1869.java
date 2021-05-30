/*
1869. Longer Contiguous Segments of Ones than Zeros

Given a binary string s, return true if the longest contiguous segment of 1s is strictly longer than the longest contiguous segment of 0s in s. Return false otherwise.

For example, in s = "110100010" the longest contiguous segment of 1s has length 2, and the longest contiguous segment of 0s has length 3.
Note that if there are no 0s, then the longest contiguous segment of 0s is considered to have length 0. The same applies if there are no 1s.

Example 1:

Input: s = "1101"
Output: true
Explanation:
The longest contiguous segment of 1s has length 2: "1101"
The longest contiguous segment of 0s has length 1: "1101"
The segment of 1s is longer, so return true.
Example 2:

Input: s = "111000"
Output: false
Explanation:
The longest contiguous segment of 1s has length 3: "111000"
The longest contiguous segment of 0s has length 3: "111000"
The segment of 1s is not longer, so return false.
Example 3:

Input: s = "110100010"
Output: false
Explanation:
The longest contiguous segment of 1s has length 2: "110100010"
The longest contiguous segment of 0s has length 3: "110100010"
The segment of 1s is not longer, so return false.
 

Constraints:

1 <= s.length <= 100
s[i] is either '0' or '1'.


 * 
 * 
 * That's a clever trick. char's are actually of the same type / length as shorts. Now when you have a char that represents a ASCII/unicode digit (like '1'), and you subtract the smallest possible ASCII/unicode digit from it (e.g. '0'), then you'll be left with the digit's corresponding value (hence, 1)

Because char is the same as short (although, an unsigned short), you can safely cast it to an int. And the casting is always done automatically if arithmetics are involved



shorts can have negative values, char doesn't. Also is not ASCII but unicode ( small but important difference ) : try int y = '\uffff' - '\ufffe'; – OscarRyz Nov 30 '10 at 20:44 
You're right. For digits, ASCII and Unicode codes happen to coincide, that's why I thought of ASCII first – Lukas Eder Nov 30 '10 at 20:45 
That's great. I did need Mark Peter's comment to make me realise that by 'corresponding value' you mean I'm actually subtracting 48 from 49-57. Also, the error I was getting was really an array out of bounds exception so perhaps my question's misleading in saying the first example "doesn't work". Thanks! :) – ledneb Nov 30 '10 at 21:00
To be clear, a char isn't considered a subtype of short in Java... your answer kind of makes it sound like it is. char and short are both direct subtypes of int. Also, "casting" is done automatically between any type and any type that is considered a supertype of it regardless of whether arithmetic is involved. – ColinD Nov 30 '10 at 21:08 
Add a comment



This is an old ASCII trick which will work for any encoding that lines the digits '0' through '9' sequentially starting at '0'. In Ascii, '0' is a character with value 0x30 and '9' is 0x39. Basically, if you have a character that is a digit, subtracting '0' "converts" it to it's digit value.

I have to disagree with @Lukas Eder and suggest that it is a terrible trick; because the intent of this action aproaches 0% obvious from code. If you are using Java and have a String that contains digits and you want to convert said String to an int I suggest that you use Integer.parseInt(yourString);.

This technique has the benifit of being obvious to the future maintenance programmer.

*
*
*
*

class Solution{
    public boolean checkZeroOnes(String s) {
        int maxZerosCount = 0, maxOnesCount = 0;
        int currentZerosCount = 0, currentOnesCount = 0;


        for (int i=0; i<s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == '0') currentZerosCount++;
                else if (s.charAt(i) == '1') currentOnesCount++;
            } else if (s.charAt(i) == '0') {
                currentZerosCount = (s.charAt(i) == s.charAt(i-1)) ? currentZerosCount+1 : 1;
            } else if (s.charAt(i) == '1') {
                currentOnesCount = (s.charAt(i) == s.charAt(i-1)) ? currentOnesCount+1 : 1;
            }

            maxZerosCount = maxZerosCount < currentZerosCount ? currentZerosCount : maxZerosCount;
            maxOnesCount = maxOnesCount < currentOnesCount ? currentOnesCount : maxOnesCount;
        }
        return maxOnesCount > maxZerosCount;
    }
}
*/


class Solution {
    public boolean checkZeroOnes(String s) {
        int currentOnesLength = 0, maxOneLength = 0;
        int currentZeroLength = 0, maxZeroLength = 0;
        
        for(int i=0;i<s.length();i++){
            if((s.charAt(i) - '0')==1){
                currentOnesLength++;
                currentZeroLength = 0;
                if(currentOnesLength>maxOneLength){
                    maxOneLength = currentOnesLength;
                }
            }else if((s.charAt(i) - '0')==0){
                currentZeroLength++;
                currentOnesLength = 0;
                if(currentZeroLength>maxZeroLength){
                    maxZeroLength = currentZeroLength;
                }
            }
        }
        return maxOneLength>maxZeroLength;
    }
}