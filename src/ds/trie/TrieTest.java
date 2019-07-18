package ds.trie;

import ds.bstree.BSTree;
import ds.util.FileOperation;

import java.util.ArrayList;

public class TrieTest {

    public static void main(String[] args) {
        // compare with bstree
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            Trie trie = new Trie();
            double start, elapsed;

            start = System.nanoTime();
            for (String word : words) {
                trie.add(word);
            }

            for (String word : words) {
                trie.contains(word);
            }
            elapsed = (System.nanoTime() - start) / 1000000000;
            System.out.println("Trie: " + elapsed + "s");

            start = System.nanoTime();
            BSTree b = new BSTree();
            for (String word : words) {
                b.add(word, null);
            }

            for (String word : words) {
                b.contains(word);
            }
            elapsed = (System.nanoTime() - start) / 1000000000;
            System.out.println("BSTree: " + elapsed + "s");
            // test result
            // Trie: 0.125574381s
            // BSTree: 0.171143983s
        }
    }
}
