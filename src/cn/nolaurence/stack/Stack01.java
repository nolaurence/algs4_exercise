package cn.nolaurence.stack;

import java.util.Stack;

public class Stack01 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(stack.isEmpty())
                if (c == '{' || c == '(' || c == '[')
                    stack.push(c);
            else {
                if (c == findOpposite(stack.peek()))
                    stack.pop();
            }
        }
        return !stack.isEmpty();
    }

    private static char findOpposite(char c) {
        if (c == '{') return '}';
        if (c == '(') return ')';
        if (c == '[') return ']';
        else return 'n';
    }

    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }
}
