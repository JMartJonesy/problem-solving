/**
205. Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
**/
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> sMappings = new HashMap<>();
		HashMap<Character, Character> tMappings = new HashMap<>();
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		for(int i = 0; i < sChars.length; ++i) {
			char sCurr = sChars[i];
			char tCurr = tChars[i];
			if(!sMappings.containsKey(sCurr) && !tMappings.containsKey(tCurr)) {
				sMappings.put(sCurr, tCurr);
				tMappings.put(tCurr, sCurr);
			} else if(sMappings.containsKey(sCurr) && tMappings.containsKey(tCurr) && (sMappings.get(sCurr) != tCurr || tMappings.get(tCurr) != sCurr)){
				return false;
			} else if(!sMappings.containsKey(sCurr) || !tMappings.containsKey(tCurr)){
				return false;
			}
		}

		return true;
	}
}
