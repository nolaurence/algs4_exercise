package cn.nolaurence.stack;

import java.util.Stack;

public class Stack02 {
    public static int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;

        int sum = 0;
        while (left < right) {
            if (height[left] > leftMax) leftMax = height[left];
            if (height[right] > rightMax) rightMax = height[right];
            if (height[left] < height[right]) {
                sum += (leftMax -height[left]);
                left += 1;
            } else {
                sum += (rightMax - height[right]);
                right -= 1;
            }
        }

        return sum;
    }

    public static int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int currentWidth = j - i + 1;
                int currentHeight = findMin(heights, i, j);
                int area = currentHeight * currentWidth;
                if (area > max)  max = area;
            }
        }
        return max;
    }

    private static int findMin(int[] a, int lo, int hi) {
        if (hi == lo) return a[lo];
        int min = a[lo];
        for (int i = lo; i <= hi; i++) {
            if (min > a[i]) min = a[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] height= {0, 9};
        System.out.println(Stack02.largestRectangleArea(height));
    }
}
