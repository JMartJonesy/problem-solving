/**
242. Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
**/
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}

		HashMap<Character, Integer> counts = new HashMap<>();

		for(char c: s.toCharArray()) {
			counts.put(c, counts.getOrDefault(c, 0) + 1);
		}

		for(char c: t.toCharArray()) {
			if(!counts.containsKey(c) || counts.get(c) == 0) {
				return false;
			} else {
				counts.put(c, counts.get(c) - 1);
			}
		}

		return true;
	}
}
