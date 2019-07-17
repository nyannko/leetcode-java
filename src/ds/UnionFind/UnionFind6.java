package ds.UnionFind;

public class UnionFind6 implements UF {

    private int[] parent;
    private int[] rank;

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            // all nodes point to itself
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        if (p < 0 || p > parent.length - 1) {
            throw new IllegalArgumentException("p out of bound");
        }

        // different path compression
        if (p != parent[p])
            p = find(parent[p]);
        return parent[p];
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        // if p is lower than q
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
    }
}
