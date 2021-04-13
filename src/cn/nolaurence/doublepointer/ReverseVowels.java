package cn.nolaurence.doublepointer;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowels {
    public static void main(String[] args) {
        String s = "leetcode";
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.reverseVowels2(s));
    }
}


class Solution1 {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s == null) return null;
        int left = 0, right = s.length() - 1;
        char[] result = new char[s.length()];

        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);
            if (!vowels.contains(cLeft))  result[left++] = cLeft;
            else if (!vowels.contains(cRight))  result[right--] = cRight;
            else {
                result[left++] = cRight;
                result[right--] = cLeft;
            }
        }

        return new String(result);
    }

    public String reverseVowels2(String s) {
        char[] chars = s.toCharArray();
        int l =0;   //左指针
        int r = chars.length - 1; //右指针

        //当左指针大于右指针就结束循环
        while(l < r) {
            //判断左指针是否是元音字母,不是就加
            if (!vowels.contains(chars[l])){
                l++;
                continue;
            }

            //判断右指针是否是元音字母,不是就减
            if (!vowels.contains(chars[r])) {
                r--;
                continue;
            }
            //元音字母互换
            chars[l] = (char) (chars[l] + chars[r]);
            chars[r] = (char) (chars[l] - chars[r]);
            chars[l] = (char) (chars[l] - chars[r]);
            //这种是容易看懂的替换,但是内存消耗看着有点大
            // char temp = chars[l];
            // chars[l] = chars[r];
            // chars[r] = temp;
            l++;
            r--;

        }
        return String.valueOf(chars);
    }
}