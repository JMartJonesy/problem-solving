/**
28. Find the Index of the First Occurrence in a String
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
**/
public class FindFirstOccurenceInString {
	public int strStr(String haystack, String needle) {
		if(needle.length() == 0) {
			return -1;
		}
		char startingChar = needle.charAt(0);
		for(int i = 0; i < haystack.length(); ++i) {
			if(haystack.charAt(i) == startingChar && checkString(haystack, i, needle)) {
				return i;
			}
		}

		return -1;
	}

	private boolean checkString(String haystack, int hayStackIndex, String needle) {
		int needleIndex = 0;
		while(hayStackIndex < haystack.length() && needleInex < needle.length()) {
			if(haystack.charAt(hayStackIndex) != needle.charAt(needleIndex)) {
				return false;
			}
			hayStackIndex++;
			needleIndex++;
		}
		return needleIndex == needle.length();
	}
}
