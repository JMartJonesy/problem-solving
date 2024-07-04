/**
67. Add Binary
Given two binary strings a and b, return their sum as a binary string.
**/
public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder addedBinary = new StringBuilder();
		char[] aChars = a.toCharArray();
		char[] bChars = b.toCharArray();
		int aIndex = aChars.length - 1;
		int bIndex = bChars.length - 1;
		boolean carry = false;
		while(aIndex >= 0 && bIndex >= 0) {
			char aCurr = aChars[aIndex];
			char bCurr = bChars[bIndex];
			char newChar;
			boolean newCarry = false;
			if(aCurr == '1' && bCurr == '1') {
				newCarry = true;
				newChar = '0';
			} else if(aCurr == '0' && bCurr == '0') {
				newChar = '0';
			} else{
				newChar = '1';
			}
			if(carry) {
				if(newChar == '0') {
					newChar = '1';
				} else {
					newChar = '0';
					newCarry = true;
				}
			} 
			carry = newCarry;
			addBinary.append(newChar);
			--aIndex;
			--bIndex;
		}

		if(aIndex >= 0) {
			return addRemaining(addBinary, aChars, aIndex, carry);
		} else {
			return addRemaining(addBinary, bChars, bIndex, carry);
		}
	}

	private String addRemaining(StringBuilder addBinary, char[] chars, int index, boolean carry) {
		for(int i = index; i >= 0; --i) {
			if(carry) {
				if(chars[index] == '0') {
					addBinary.append('1');
					carry = false;
				} else {
					addBinary.append('0');
				}
			} else {
				addBinary.append(chars[index]);
			}
		}

		if(carry) {
			addBinary.append('1');
		}

		addBinary.reverse();
		return addBinary.toString();
	}
}
