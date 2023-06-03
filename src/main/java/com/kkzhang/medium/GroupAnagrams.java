package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150
 */
public class GroupAnagrams {
    /**
     * 解题思路：
     * 该问题可以使用哈希表来解决。我们可以遍历字符串数组，对于每个字符串，将其进行排序，然后将排序后的字符串作为 key，原始字符串作为
     * value，存入哈希表中。这样，具有相同字符的字符串会被映射到同一个 key 上。
     * 
     * 具体步骤如下：
     * 1. 初始化一个空的哈希表 map，用于存储字母异位词。
     * 2. 遍历字符串数组 strs 的每个字符串 str：
     * * 将 str 转换为字符数组 charArray。
     * * 对 charArray 进行排序，得到排序后的字符数组 sortedArray。
     * * 将 sortedArray 转换为字符串 sortedStr。
     * * 如果 map 中不存在 sortedStr，则创建一个新的列表，将 str 添加到列表中，并将该列表存入 map 中，以 sortedStr 为
     * key。
     * * 如果 map 中存在 sortedStr，则直接将 str 添加到对应的列表中。
     * 3. 遍历 map 中的所有值，将结果列表进行初始化，并将每个列表添加到结果列表中。
     * 4. 返回结果列表。
     * 
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sMap = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);
            if (!sMap.containsKey(key)) {
                sMap.put(key, new ArrayList<>());
            }
            sMap.get(key).add(s);
        }

        return new ArrayList<>(sMap.values());
    }
}
