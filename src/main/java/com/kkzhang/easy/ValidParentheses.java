package com.kkzhang.easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/?envType=study-plan-v2&envId=top-interview-150
 */
public class ValidParentheses {
    /**
     * 解题思路：
     * 该问题可以使用栈来解决。
     * 遍历字符串，当遇到左括号时，将其压入栈中；
     * 当遇到右括号时，与栈顶元素进行匹配，如果匹配成功，则将栈顶元素出栈，继续遍历；如果匹配失败，则字符串不合法。
     * 
     * 具体步骤如下：
     * 1. 创建一个栈 stack，用于存储左括号。
     * 2. 遍历字符串 s 的每个字符 c：
     * 3. 如果 c 是左括号（'('，'{'，'['），将其压入栈中。
     * 4. 如果 c 是右括号（')'，'}'，']'），检查栈是否为空。如果为空，则字符串不合法，返回
     * false。否则，将栈顶元素出栈，并与当前的右括号进行匹配。如果匹配失败，返回 false。
     * 5. 遍历结束后，检查栈是否为空。如果栈为空，表示所有的左括号都有匹配的右括号，字符串合法；如果栈不为空，表示有未匹配的左括号，字符串不合法。
     * 
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '}') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char e = stack.pop();
                if ((c == ')' && e != '(') || (c == '}' && e != '{') || (c == ']' && e != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
