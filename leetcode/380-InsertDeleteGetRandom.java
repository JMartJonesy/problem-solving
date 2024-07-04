/**
  380. Insert Delete GetRandom O(1)
Implement the RandomizedSet class:

    RandomizedSet() Initializes the RandomizedSet object.
    bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
    bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
    int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.

You must implement the functions of the class such that each function works in average O(1) time complexity.
**/
public class InsertDeleteGetRandom {
	HashMap<Integer, Integer> valToIndex;
	ArrayList<Integer> vals;
	Random random;
	public RandomizedSet() {
		valToIndex = new HashMap<>();
		vals = new ArrayList<>();
		random = new Random();
	}
	public boolean insert(int val) {
		if(!valToIndex.containsKey(val)) {
			valToIndex.put(val, vals.size());
			vals.add(val);
			return true;
		} else {
			return false;
		}
	}
	public boolean remove(int val) {
		if(valToIndex.containsKey(val)) {
			int valIndex = valToIndex.get(val);
			int lastIndex = vals.size() - 1;
			int lastVal = vals.get(lastIndex);

			vals.set(valIndex, lastVal);
			vals.remove(lastIndex);

			valToIndex.set(lastVal, valIndex);
			valToIndex.remove(val);

			return true;
		} else {
			return false;
		}
	}
	public int getRandom() {
		return vals.get(random.nextInt() % vals.size());
	}
}
