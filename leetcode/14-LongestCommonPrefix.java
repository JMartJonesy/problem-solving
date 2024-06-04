/**
14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
**/
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) {
			return "";
		}

		if (strs.length == 1) {
			return strs[0];
		}

		String overlap = strs[0];
		for(int i = 1; i < strs.length; ++i) {
			overlap = overlap(overlap, strs[i]);
			if(overlap.equals("")) {
				return "";
			}
		}

		return overlap;
	}

	private String overlap(String s, String t) {
		int sIndex = 0;
		int tIndex = 0;
		StringBuilder overlap = new StringBuilder();;
		while(sIndex < s.length() && tIndex < t.length()) {
			if(s.charAt(sIndex) == t.charAt(tIndex)) {
				overlap.append(s.charAt(sIndex));
			} else {
				break;
			}
			sIndex++;
			tIndex++;
		}

		return overlap.toString();
	}
}
