/**
6. Zigzag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
**/
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
		    return s;
		}

		int n = s.length();
		int sections = (int) Math.ceil(n / (2 * numRows - 2.0));
		int numCols = sections * (numRows - 1);

		char[][] matrix = new char[numRows][numCols];
		for (char[] row : matrix) {
		    Arrays.fill(row, ' ');
		}

		int currRow = 0, currCol = 0;
		int currStringIndex = 0;

		// Iterate in zig-zag pattern on matrix and fill it with string characters.
		while (currStringIndex < n) {
		    // Move down.
		    while (currRow < numRows && currStringIndex < n) {
			matrix[currRow][currCol] = s.charAt(currStringIndex);
			currRow++;
			currStringIndex++;
		    }

		    currRow -= 2;
		    currCol++;

		    // Move up (with moving right also).
		    while (currRow > 0 && currCol < numCols && currStringIndex < n) {
			matrix[currRow][currCol] = s.charAt(currStringIndex);
			currRow--;
			currCol++;
			currStringIndex++;
		    }
		}

		StringBuilder answer = new StringBuilder();
		for (char[] row : matrix) {
		    for (char character : row) {
			if (character != ' ') {
			    answer.append(character);
			}
		    }
		}

		return answer.toString();
	}

	public String convertButFast(String s, int numRows) {
		if (numRows == 1) {
		    return s;
		}

		StringBuilder answer = new StringBuilder();
		int n = s.length();
		int charsInSection = 2 * (numRows - 1);

		for (int currRow = 0; currRow < numRows; ++currRow) {
		    int index = currRow;

		    while (index < n) {
			answer.append(s.charAt(index));

			// If currRow is not the first or last row
			// then we have to add one more character of current section.
			if (currRow != 0 && currRow != numRows - 1) {
			    int charsInBetween = charsInSection - 2 * currRow;
			    int secondIndex = index + charsInBetween;

			    if (secondIndex < n) {
				answer.append(s.charAt(secondIndex));
			    }
			}
			// Jump to same row's first character of next section.
			index += charsInSection;
		    }
		}

		return answer.toString();
	}
}
