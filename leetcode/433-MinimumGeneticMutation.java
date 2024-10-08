/*
 *433. Minimum Genetic Mutation
 *A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.

    For example, "AACCGGTT" --> "AACCGGTA" is one mutation.

There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumGeneticMutation {
	public class Neighbor {
		String gene;
		int steps;

		public Neighbor(String gene, int steps) {
			this.gene = gene;
			this.steps = steps;
		}
	}

	public int minMutation(String startGene, String endGene, String[] bank) {
		Queue<Neighbor> queue = new LinkedList<Neighbor>();
		HashSet<String> visited = new HashSet<>();

		HashSet<String> bankSet = new HashSet<>();
		for (String gene : bank) {
			bankSet.add(gene);
		}

		queue.offer(new Neighbor(startGene, 0));
		while (!queue.isEmpty()) {
			Neighbor top = queue.poll();
			visited.add(top.gene);
			if (top.gene.equals(endGene)) {
				return top.steps;
			}
			List<Neighbor> neighbors = generateNeighbors(top, bankSet, visited);
			for (Neighbor neighbor : neighbors) {
				queue.offer(neighbor);
			}
		}

		return -1;
	}

	private List<Neighbor> generateNeighbors(Neighbor curr, HashSet<String> bank, HashSet<String> visited) {
		char[] genes = new char[] { 'A', 'C', 'G', 'T' };

		List<Neighbor> neighbors = new ArrayList<>();
		StringBuilder neighbor = new StringBuilder();
		neighbor.append(curr.gene);
		for (int i = 0; i < neighbor.length(); ++i) {
			char originalCharacter = neighbor.charAt(i);
			for (char c : genes) {
				neighbor.setCharAt(i, c);
				String newNeighbor = neighbor.toString();
				if (!visited.contains(newNeighbor) && bank.contains(newNeighbor)) {
					neighbors.add(new Neighbor(newNeighbor, curr.steps + 1));
				}
			}
			neighbor.setCharAt(i, originalCharacter);
		}

		return neighbors;
	}
}
