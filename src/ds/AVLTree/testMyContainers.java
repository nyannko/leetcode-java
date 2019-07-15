package ds.AVLTree;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class testMyContainers {

    public static void testPerformance(MySet<String> set) {
        ArrayList<String> words = new ArrayList<>();
        double startTime, timeElapsed;
        startTime = System.nanoTime();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            for (String word : words) {
                set.add(word);
            }
            System.out.println("Total words: " + set.size());

            for (String word : words) {
                if (!set.contains(word)) throw new NoSuchElementException();
            }

            for (String word : words) {
                set.remove(word);
            }

            for (String word : words) {
                if (set.contains(word)) throw new NoSuchElementException();
            }
        }
        timeElapsed = (System.nanoTime() - startTime) / 1000000000;
        System.out.println("AVLset: " + timeElapsed + "s");
    }

    public static void testPerformance(MyMap<String, Integer> map) {
        ArrayList<String> words = new ArrayList<>();
        double startTime, timeElapsed;
        startTime = System.nanoTime();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            for (String word : words) {
                if (!map.contains(word)) {
                    map.put(word, 0);
                } else {
                    map.put(word, map.get(word) + 1);
                }
            }
            System.out.println("Total words: " + map.size());

            for (String word : words) {
                if (!map.contains(word)) throw new NoSuchElementException();
            }

            for (String word : words) {
                map.remove(word);
            }

            for (String word : words) {
                if (map.contains(word)) throw new NoSuchElementException();
            }
        }
        timeElapsed = (System.nanoTime() - startTime) / 1000000000;
        System.out.println("AVLMap: " + timeElapsed + "s");
    }


    public static void main(String[] args) {
        AVLMap map = new AVLMap();
        AVLSet set = new AVLSet();
        testPerformance(map);
        testPerformance(set);
    }
}
