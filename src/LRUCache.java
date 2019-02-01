import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int capacity;
    Node head, tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = tail;
        this.tail.prev = head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = this.map.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (map.containsKey(key)) {
            Node nodeRemove = this.map.get(key);
            remove(nodeRemove);
        } else {
            if (this.capacity > 0) {
                this.capacity--;
            } else {
                Node nodeRemove = this.head.next; // get the least used node
                remove(nodeRemove); // delete from linked list
                map.remove(nodeRemove.key); // delete from hashmap
            }
        }
        add(newNode); // add to linked list
        map.put(key, newNode); // add to hashmap
    }

    private void add(Node node) {
        Node p = this.tail.prev;
        p.next = node;
        node.prev = p;
        node.next = this.tail;
        this.tail.prev = node;
    }

    private void remove(Node node) {
        Node p = node.prev;
        Node n = node.next;
        p.next = n;
        n.prev = p;
    }
}

class LRUCache2 {
    int capacity;
    Map<Integer, Integer> map;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true) { // remove by access order
            // return true if eldest element should be removed
            // (when self.size larger than capacity)
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache2 l = new LRUCache2(2);
        l.put(1, 1);
        l.put(2, 2);
        l.get(1);
        l.put(3, 3);
        System.out.println(l.get(2));
        System.out.println(l.map);
    }

}