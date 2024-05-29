/**
373. Find K Pairs with Smallest Sums
You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
**/
public class FindKPairsWithSmallestSums {
	public class Pair {
		int l, r;
		int total;
		public Pair(int l, int r, int total) {
			this.l = l;
			this.r = r;
			this.total = total;
		}
	}
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<Pair> minPairs = new PriorityQueue<>(
			(a, b) -> a.total - b.total
		);
		Set<List<Integer>> visited = new HashSet<>();

		Pair addPair = new Pair(0, 0, nums1[0] + nums2[0]);
		visited.add(Arrays.asList(addPair.l, addPair.r));
		minPairs.offer(addPair);
		
		List<Pair> selected = new ArrayList<>();
		while(selected.size() < k) {
			Pair min = minPairs.poll();
			selected.add(min);
			if((min.l + 1) < nums1.length) {
				addPair = new Pair(min.l + 1, min.r, nums1[min.l + 1] + nums2[min.r]);
				List<Integer> pair = Arrays.asList(addPair.l, addPair.r);
				if(!visited.contains(pair)) {
				    visited.add(pair);
						    minPairs.offer(addPair);
				}
			}

			if((min.r + 1) < nums2.length) {
				addPair = new Pair(min.l, min.r + 1, nums1[min.l] + nums2[min.r + 1]);
				List<Integer> pair = Arrays.asList(addPair.l, addPair.r);
				if(!visited.contains(pair)) {
				    visited.add(pair);
						    minPairs.offer(addPair);
				}
			}
		}

		List<List<Integer>> answer = new ArrayList<>();
		for(Pair pair: selected) {
			answer.add(Arrays.asList(nums1[pair.l], nums2[pair.r]));
		}

		return answer;
	}
}
