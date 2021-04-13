package cn.nolaurence.stack;

import java.util.Stack;

public class Stack01 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[')
                stack.push(c);
            else if (!stack.isEmpty() && c == findOpposite(stack.peek()))
                stack.pop();
            count += 1;
            }
        return 2 * count == s.length();
    }

    private static char findOpposite(char c) {
        if (c == '{') return '}';
        if (c == '(') return ')';
        if (c == '[') return ']';
        else return 'n';
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
}
