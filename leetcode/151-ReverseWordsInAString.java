/**
151. Reverse Words in a String
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
**/
public class ReverseWordsInAString {
	public String reverseWords(String s) {
		char[] chars = s.toCharArray();
		reverse(chars, 0, chars.length - 1);

		int start = 0;
		int end = 0;
		boolean foundWord = false;
		while(end < chars.length) {
			while(end < chars.length && chars[end] != ' ') {
				if(!foundWord) {
					foundWord = true;
					start = end;
				}
				++end;
			}
			if(foundWord) {
				reverse(chars, start, end - 1);
				foundWord = false;
			}
			++end;
		}

		StringBuilder reversed = new StringBuilder();
		boolean keepSpace = false;
		for(char c : chars) {
			if(c != ' ') {
				reversed.append(c);
				keepSpace = true;
			} else if(keepSpace) {
				reversed.append(c);
				keepSpace = false;
			}
		}

		if(reversed.charAt(reversed.length() - 1) == ' ') {
			return reversed.substring(0, reversed().length - 1);
		} else {
			return reversed.toString();
		}
	}

	private void reverse(char[] chars, int start, int end) {
		while(start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			++start;
			--end;
		}
	}
}
