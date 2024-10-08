/*
 *17. Letter Combinations of a Phone Number
 Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
		if (digits.isBlank()) {
			return new ArrayList<>();
		}

		HashMap<Character, List<Character>> digitsToCharacters = new HashMap<>();
		digitsToCharacters.put('2', Arrays.asList('a', 'b', 'c'));
		digitsToCharacters.put('3', Arrays.asList('d', 'e', 'f'));
		digitsToCharacters.put('4', Arrays.asList('g', 'h', 'i'));
		digitsToCharacters.put('5', Arrays.asList('j', 'k', 'l'));
		digitsToCharacters.put('6', Arrays.asList('m', 'n', 'o'));
		digitsToCharacters.put('7', Arrays.asList('p', 'q', 'r', 's'));
		digitsToCharacters.put('8', Arrays.asList('t', 'u', 'v'));
		digitsToCharacters.put('9', Arrays.asList('w', 'x', 'y', 'z'));

		List<String> permutations = new ArrayList<>();
		permute(new StringBuilder(), permutations, digitsToCharacters, digits.toCharArray(), 0);

		return permutations;
	}

	private void permute(StringBuilder curr, List<String> permutations,
			HashMap<Character, List<Character>> digitsToCharacters, char[] digits, int index) {
		if (index == digits.length) {
			permutations.add(curr.toString());
		} else {
			List<Character> options = digitsToCharacters.get(digits[index]);
			for (char c : options) {
				curr.append(c);
				permute(curr, permutations, digitsToCharacters, digits, index + 1);
				curr.deleteCharAt(curr.length() - 1);
			}
		}
	}
}
