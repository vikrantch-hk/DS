package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	char c;
	Map<Character, TrieNode> children = new HashMap<>();
	boolean isLeaf;
	public TrieNode() {
		super();
	}
	public TrieNode(char c) {
		this.c = c;
	}
}
