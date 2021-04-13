package cn.nolaurence.doublepointer;

public class JudgeSquareSum {
    public static void main(String[] args) {
        int c = 1;
        Solution s = new Solution();
        System.out.println(s.judgeSquareSum(c));
    }
}

class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while(left <= right) {
            int result = left * left + right * right;
            if (result == c){
                System.out.format("%d, %d\n", left, right);
                return true;
            }
            else if (result > c) right--;
            else  left++;
        }
        return false;
    }

    // credit: https://leetcode-cn.com/problems/sum-of-square-numbers/description/
    public boolean judgeSquareSumOfficial(int target) {
        if (target < 0) return false;
        int i = 0, j = (int) Math.sqrt(target);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == target) {
                return true;
            } else if (powSum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
