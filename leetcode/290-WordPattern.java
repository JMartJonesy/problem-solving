/**
290. Word Pattern
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
**/
public class WordPattern {
	public boolean wordPattern(String pattern, String s) {
		HashMap<Character, String> patternMappings = new HashMap<>();
		HashMap<String, Character> sMappings = new HashMap<>();
		char[] patternChars = pattern.toCharArray();
		String[] sWords = s.split(" ");

		if(patternChars.length != sWords.length) {
			return false;
		}

		for(int i = 0; i < patternChars.length; ++i) {
			char currChar = patternChars[i];
			String currWord = sWords[i];
			if(!patternMappings.containsKey(currChar) && !sMappings.containsKey(currWord)) {
				patternMappings.put(currChar, currWord);
				sMappings.put(currWord, currChar);
			} else if(patternMappings.containsKey(currChar) && sMappings.containsKey(currWord) && (!patternMappings.get(currChar).equals(currWord) || sMappings.get(currWord) != currChar)){
				return false;
			} else if(!patternMappings.containsKey(currChar) || !sMappings.containsKey(currWord)){
				return false;
			}
		}

		return true;
	}
}
