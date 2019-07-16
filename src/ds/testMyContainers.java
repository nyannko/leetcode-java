package ds;

import ds.AVLTree.AVLMap;
import ds.AVLTree.AVLSet;
import ds.AVLTree.AVLTree;
import ds.AVLTree.FileOperation;
import ds.BSTree.BSTree;
import ds.RBTree.RBMap;
import ds.RBTree.RBSet;
import ds.RBTree.RBTree;
import ds.util.MyMap;
import ds.util.MySet;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

public class testMyContainers {

    public static double testPerformance(MySet<String> set, boolean flag) {
        ArrayList<String> words = new ArrayList<>();
        double startTime, timeElapsed;
        startTime = System.nanoTime();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
//            System.out.println("Total words: " + words.size());
            for (String word : words) {
                set.add(word);
            }
//            System.out.println("Total words in set: " + set.size());

            for (String word : words) {
                if (!set.contains(word)) throw new NoSuchElementException();
            }

            if (flag) {
                for (String word : words) {
                    set.remove(word);
                }

                for (String word : words) {
                    if (set.contains(word)) throw new NoSuchElementException();
                }
            }
        }
        timeElapsed = (System.nanoTime() - startTime) / 1000000000;
        return timeElapsed;
    }

    public static double testPerformance(MyMap<String, Integer> map, boolean flag) {
        ArrayList<String> words = new ArrayList<>();
        double startTime, timeElapsed;
        startTime = System.nanoTime();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
//            System.out.println("Total words: " + words.size());
            for (String word : words) {
                if (!map.contains(word)) {
                    map.put(word, 0);
                } else {
                    map.put(word, map.get(word) + 1);
                }
            }
//            System.out.println("Total words in map: " + map.size());

            for (String word : words) {
                if (!map.contains(word)) throw new NoSuchElementException();
            }

            if (flag) {
                for (String word : words) {
                    map.remove(word);
                }

                for (String word : words) {
                    if (map.contains(word)) throw new NoSuchElementException();
                }
            }
        }
        timeElapsed = (System.nanoTime() - startTime) / 1000000000;
        return timeElapsed;
    }

    public static void testAdd(boolean order) {
        int n = 20000000;

        ArrayList<Integer> testData = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            if (order) testData.add(i);
            else testData.add(rand.nextInt(Integer.MAX_VALUE));
        }

        AVLTree<Integer, Object> avl = new AVLTree<>();
        RBTree<Integer, Object> rbt = new RBTree<>();

        double startTime, ElapsedTime;

        if (!order) {
            BSTree<Integer, Object> bst = new BSTree<>();

            startTime = System.nanoTime();
            for (int i : testData) {
                bst.add(i, null);
            }
            ElapsedTime = (System.nanoTime() - startTime) / 1000000000;
            System.out.println("bst: " + ElapsedTime + "s");
        }

        // avl
        startTime = System.nanoTime();
        for (int i : testData) {
            avl.add(i, null);
        }
        ElapsedTime = (System.nanoTime() - startTime) / 1000000000;
        System.out.println("avl: " + ElapsedTime + "s");

        // rbt
        startTime = System.nanoTime();
        for (int i : testData) {
            rbt.add(i, null);
        }
        ElapsedTime = (System.nanoTime() - startTime) / 1000000000;
        System.out.println("rbt: " + ElapsedTime + "s");

    }

    public static void testOverallPerformance() {
        AVLMap avlmap = new AVLMap();
        AVLSet avlset = new AVLSet();
        RBMap rbmap = new RBMap<>();
        RBSet rbset = new RBSet<>();

        System.out.println("AVLMap: " + testPerformance(avlmap, false) + "s");
        System.out.println("RBMap: " + testPerformance(rbmap, false) + "s");

        System.out.println("AVLset: " + testPerformance(avlset, false) + "s");
        System.out.println("RBset: " + testPerformance(rbset, false) + "s");
    }

    public static void main(String[] args) {
//        testAdd(false);
//        bst: 54.510279185s
//        avl: 63.332307347s
//        rbt: 55.394132244s
//        testAdd(true); // why rb tree slow?
//        avl: 5.649993156s
//        rbt: 7.801314172s
    }
}
