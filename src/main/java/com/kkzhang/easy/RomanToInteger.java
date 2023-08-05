package com.kkzhang.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150
 */
public class RomanToInteger {
    /**
     * 解题思路：
     * 这道题可以使用哈希表来解决。
     * 我们可以创建一个哈希表，将罗马数字的字符和对应的数值存储起来。
     * 然后遍历输入的罗马数字字符串，根据特殊规则和哈希表，将每个字符对应的数值累加起来，得到最终的整数值。
     * 
     * 具体步骤如下：
     * 1. 创建一个哈希表，将罗马数字的字符和对应的数值存储起来。
     * 2. 初始化变量 result 为 0，表示最终的整数值。
     * 3. 遍历输入的罗马数字字符串，对于每个字符 s[i]，执行以下操作：
     * * 3.1 如果 s[i] 对应的数值大于 s[i-1] 对应的数值，说明出现了特殊规则的情况，
     * * 需要减去 s[i-1] 对应的数值，然后加上 s[i] 对应的数值。
     * * 3.2 否则，直接将 s[i] 对应的数值累加到 result 中。
     * 4. 循环结束后，result 即为最终的整数值，返回 result。
     */
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (i > 0 && value > map.get(s.charAt(i - 1))) {
                result += value - 2 * map.get(s.charAt(i - 1));
            } else {
                result += value;
            }
        }

        return result;
    }
}
