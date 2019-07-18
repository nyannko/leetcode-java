import java.util.TreeMap;

public class AddAndSearchWord {

    private class Node {
        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node() {
            next = new TreeMap<>();
        }
    }

    private Node root;

    public AddAndSearchWord() {
        this.root = new Node();
    }


    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i); // {'a' : {'b': {}}}
            if (cur.next.get(a) == null) {
                cur.next.put(a, new Node());
            }
            cur = cur.next.get(a);
        }

        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index == word.length()) return node.isWord;
        char a = word.charAt(index);
        if (a != '.') {
            if (node.next.get(a) == null) return false;
            return match(node.next.get(a), word, index + 1);
        } else {
            for (char nextChar : node.next.keySet()) {
                if (match(node.next.get(nextChar), word, index + 1))
                    return true;
            }
            return false;
        }
    }
}
