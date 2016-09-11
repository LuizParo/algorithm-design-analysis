package com.coursera.algorithm.mergesort;

public class BruteForceSort {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static long sort(Comparable[] array, int size) {
        long inversions = 0;
        
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if(array[i].compareTo(array[j]) > 0) {
                    ++inversions;
                    swap(array, i, j);
                }
            }
        }
        
        return inversions;
    }

    private static void swap(Comparable<?>[] array, int from, int to) {
        Comparable<?> elementFrom = array[from];
        array[from] = array[to];
        array[to] = elementFrom;
    }
}