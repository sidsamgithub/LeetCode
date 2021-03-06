/* 20. Valid Parentheses
*
* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
*
* An input string is valid if:
*
* Open brackets must be closed by the same type of brackets.
* Open brackets must be closed in the correct order.
*
*
* Example 1:
*
* Input: s = "()"
* Output: true
* Example 2:
*
* Input: s = "()[]{}"
* Output: true
* Example 3:
*
* Input: s = "(]"
* Output: false
* Example 4:
*
* Input: s = "([)]"
* Output: false
* Example 5:
*
* Input: s = "{[]}"
* Output: true
* 
*
* Constraints:
*
* 1 <= s.length <= 104
* s consists of parentheses only '()[]{}'.
*/
import java.util.*;
class Solution {
 public boolean isValid(String s) {
	Stack<Character> mystack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			mystack.push(')');
		else if (c == '{')
			mystack.push('}');
		else if (c == '[')
			mystack.push(']');
		else if (mystack.isEmpty() || mystack.pop() != c)
			return false;
	}
	return mystack.isEmpty();
}
}
