import java.util.TreeMap;

public class MapSumPairs {

    private class Node {
        private boolean isWord;
        private int value;
        private TreeMap<Character, Node> next;

        public Node() {
            next = new TreeMap<>();
        }
    }

    private Node root;
    private int size;

    public MapSumPairs() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char a = key.charAt(i); // {'a' : {'b': {}}}
            if (cur.next.get(a) == null) {
                cur.next.put(a, new Node());
            }
            cur = cur.next.get(a);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char a = prefix.charAt(i); // {'a' : {'b': {}}}
            if (cur.next.get(a) == null) return 0;
            cur = cur.next.get(a);
        }
        return getRes(cur);
    }

    private int getRes(Node node) {
//        if (node.next.size() == 0) return node.value;
        int res = node.value;
        for (char a : node.next.keySet()) {
            res += getRes(node.next.get(a));
        }
        return res;
    }

}
