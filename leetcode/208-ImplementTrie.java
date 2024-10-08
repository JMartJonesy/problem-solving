/*
 *208. Implement Trie (Prefix Tree)
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

    Trie() Initializes the trie object.
    void insert(String word) Inserts the string word into the trie.
    boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
    boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 */

import java.util.HashMap;

public class Trie {
	public class Node {
		boolean isWord;
		HashMap<Character, Node> children;

		public Node() {
			isWord = false;
			children = new HashMap<>();
		}
	}

	Node root;

	public Trie() {
		root = new Node();
	}

	public void insert(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); ++i) {
			char c = word.charAt(i);
			if (curr.children.containsKey(c)) {
				curr = curr.children.get(c);
			} else {
				Node newChild = new Node();
				curr.children.put(c, newChild);
				curr = newChild;
			}
		}
		curr.isWord = true;
	}

	public boolean search(String word) {
		Node curr = root;
		for (char c : word.toCharArray()) {
			if (!curr.children.containsKey(c)) {
				return false;
			} else {
				curr = curr.children.get(c);
			}
		}

		return curr.isWord;
	}

	public boolean startsWith(String prefix) {
		Node curr = root;
		for (char c : prefix.toCharArray()) {
			if (!curr.children.containsKey(c)) {
				return false;
			} else {
				curr = curr.children.get(c);
			}
		}

		return true;
	}
}
