package trie;

public class Trie {
	TrieNode root;
	
	public Trie()
	{
		root=new TrieNode();
	}

	public void add(String s) {
		
		if(s == null || s.length() == 0){
	        return ;
	    }
		
		TrieNode node = root;
		for (int i = 0; i < s.length() ; i++) {
			if (!node.children.containsKey(s.charAt(i))) {
				TrieNode newNode = new TrieNode(s.charAt(i));
				node.children.put(s.charAt(i), newNode);
			}
			node = node.children.get(s.charAt(i));
		}
		node.isLeaf = true;
	}

	public boolean searchCompleteWord(String s) {
		

		if (s == null || s.length() == 0) {
			return true;
		}

		TrieNode node = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!node.children.containsKey(c)) {
				return false;
			} else {
				node = node.children.get(c);
			}
		}
	
		if (node.isLeaf) {
			return true;
		}
		return false;
	}

	private boolean searchPrefix(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		TrieNode node = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!node.children.containsKey(c)) {
				return false;
			} else {
				node = node.children.get(c);
			}
		}
		return true;
	}
	
	public static void main(String [] args)
	{
		Trie t = new Trie();
		t.add("to");
		t.add("tea");
		t.add("ted");
		t.add("ten");
		t.add("inn");
		System.out.println(t.searchCompleteWord("ten"));
		System.out.println(t.searchCompleteWord("te"));
		System.out.println(t.searchCompleteWord("to"));
		System.out.println(t.searchPrefix("in"));
	}
}
