package cn.nolaurence.sort;


import edu.princeton.cs.algs4.*;

public class Selection extends Example{
    // ιζ©ζεΊ
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = 0; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }
}
