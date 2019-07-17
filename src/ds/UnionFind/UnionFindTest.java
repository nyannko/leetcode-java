package ds.UnionFind;

import java.util.Random;

public class UnionFindTest {

    public static void testFind(UF u, int n) {
        Random rand = new Random();
        int size = u.getSize();
        double start, elapsed;

        start = System.nanoTime();

        for (int i = 0; i < n; i++) {
            int p = rand.nextInt(size);
            int q = rand.nextInt(size);
            u.unionElements(p, q);
        }

        for (int i = 0; i < n; i++) {
            int p = rand.nextInt(size);
            int q = rand.nextInt(size);
            u.isConnected(p, q);
        }
        elapsed = (System.nanoTime() - start) / 1000000000;
        System.out.println(u + ": " + elapsed + "s");
    }


    public static void main(String[] args) {
        int size = 10000;
        int n = 100000;
        UF u1 = new UnionFind1(size);
        UF u2 = new UnionFind2(size);
        UF u3 = new UnionFind3(size);
        UF u4 = new UnionFind4(size);
        UF u5 = new UnionFind5(size);
        UF u6 = new UnionFind6(size);

        testFind(u1, n);
        testFind(u2, n);
        testFind(u3, n);
        testFind(u4, n);
        testFind(u5, n);
        testFind(u6, n);
    }
}
