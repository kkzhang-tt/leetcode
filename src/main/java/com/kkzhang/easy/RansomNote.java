package com.kkzhang.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
 */
public class RansomNote {
    /**
     * 解题思路：
     * 该问题可以使用哈希表来解决。首先统计杂志字符串中每个字符的出现次数，然后遍历赎金信字符串，检查每个字符是否在哈希表中存在且出现次数大于等于赎金信中的次数。
     * 
     * 具体步骤如下：
     * 1. 创建两个哈希表 ransomMap 和 magazineMap，用于存储赎金信和杂志字符串中每个字符的出现次数。
     * 2. 遍历杂志字符串 magazine 的每个字符 c，将 c 对应的出现次数加入到 magazineMap 中。
     * 3. 遍历赎金信字符串 ransomNote 的每个字符 c：
     * * 如果 c 在 magazineMap 中不存在，或者 c 在 magazineMap 中的出现次数已经用完（等于0），返回 false。
     * * 否则，将 c 对应的出现次数减1。
     * 4. 遍历结束后，说明赎金信字符串中的每个字符在杂志字符串中都能找到对应的字符且出现次数不超过杂志字符串，返回 true。
     * 
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();

        for (char c : ransomNote.toCharArray()) {
            Integer count = ransomMap.get(c);
            if (count == null) {
                ransomMap.put(c, 1);
            } else {
                ransomMap.put(c, count + 1);
            }
        }

        for (char c : magazine.toCharArray()) {
            Integer count = magazineMap.get(c);
            if (count == null) {
                magazineMap.put(c, 1);
            } else {
                magazineMap.put(c, count + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : ransomMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (magazineMap.get(c) == null || magazineMap.get(c) < count) {
                return false;
            }
        }
        return true;
    }
}
