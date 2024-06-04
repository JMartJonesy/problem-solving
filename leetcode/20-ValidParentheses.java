/**
20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

**/
public class ValidParentheses {
	public boolean isValid(String s) {
		HashMap<Character, Character> parenMatches = new HashMap<>();
		parenMatches.put(')', '(');
		parenMatches.put('}', '{');
		parenMatches.put(']', '[');
		Stack<Character> parens = new Stack();
		char[] chars = s.toCharArray();
		for(char c: chars) {
			if(c == ')' || c == '}' || c == ']') {
				if(parens.isEmpty() || parenMatches.get(c) != parens.peek()) {
					return false;
				}
				parens.pop();
			} else {
				parens.push(c);
			}
		}

		return parens.isEmpty();
	}
}
