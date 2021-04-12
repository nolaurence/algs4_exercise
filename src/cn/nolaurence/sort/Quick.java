package cn.nolaurence.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick extends Example{
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);  // 消除对输入顺序的依赖
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)  return;
        int j = partition(a, lo, hi);  // 切分
        sort(a, lo, j - 1);         // 排序左半部分a[lo: j-1]
        sort(a, j + 1, hi);         // 排序右半部分a[j + 1: hi]
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // 切分函数：将数组切分为a[lo, i-1], a[i], a[i+1, hi]三个部分
        int i = lo, j = hi + 1;  // 左右扫描指针
        Comparable v = a[lo];    // 切分元素
        while(true) {  // 扫描左半边喝右半边，以i（lo）为初始比较元素
            while (less(a[++i], v))  if(i == hi)  break;  // 一次循环中，在左半找到比v大的元素  v为a[lo]
            while (less(v, a[--j]))  if(j == lo)  break;  // 一次循环中，在右半找到比v大的元素
            if (i >= j)  break;  // 限制条件一：左半指针应该比hi小，限制条件二：右半指针比lo大  限制条件三：j应该比i大。
            exch(a, i, j);  // 找到后，将i j处元素调换位置。确保v左边元素一定比v小，v右边元素一定比v大
        }
        exch(a, lo, j);  // 完成，将比较元素v 防道i j中较大的位置，也就是j
        return j;
    }
}
