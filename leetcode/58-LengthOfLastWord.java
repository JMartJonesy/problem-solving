/**
58. Length of Last Word
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal
substring
consisting of non-space characters only.
**/
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		int wordLength = 0;
		boolean wordFound = false;
		int index = s.length() - 1;
		while(index >= 0) {
			if(s.charAt(index) == ' ' && wordFound) {
				break;
			}
			if(s.charAt(index) != ' ') {
				wordFound = true;
				wordLength++;
			}
			index--;
		}
		
		return wordLength;
	}
}
