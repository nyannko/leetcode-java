package ds.unionfind;

public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    // find the root node
    private int find(int p) {
        if (p < 0 || p > id.length - 1) {
            throw new IllegalArgumentException("index out of bounds");
        }
        return id[p];
    }

    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pid = find(p);
        int qid = find(q);

        if (pid == qid) return;

        // O(n)
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid)
                id[i] = qid;
        }
    }
}
