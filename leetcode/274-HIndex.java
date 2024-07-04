/**
274. H-Index
Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
**/
public class HIndex {
	public int hIndex(int[] citations) {
		int n = citations.length;
		int[] counts = new int[n + 1];
		for(int c : citations) {
			counts[Math.min(n, c)]++;
		}

		int k = n
		for(int i = counts[n]; k > i; i += counts[k]) {
			k--;
		}

		return k;
	}
}