package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/?envType=study-plan-v2&id=top-interview-150
 */
public class InsertDeleteGetRandom {

}

/**
 * 解题思路：
 * 题目要求设计一个数据结构，支持插入、删除和随机获取元素，并且要求这些操作的平均时间复杂度为O(1)。
 * 我们可以使用哈希表和数组来实现。
 * 
 * 具体步骤如下：
 * 1. 使用哈希表存储元素值和对应的索引位置。
 * 2. 使用数组存储元素值。
 * 3. 插入元素时，首先判断元素是否已存在于哈希表中，若存在则返回false；若不存在，则将元素插入到数组末尾，同时更新哈希表中的映射关系。
 * 4. 删除元素时，首先判断元素是否存在于哈希表中，若不存在则返回false；若存在，则将数组中的该元素与数组末尾元素交换位置，同时更新哈希表中的映射关系。
 * 最后删除数组末尾元素，并更新哈希表中末尾元素的索引。
 * 5. 随机获取元素时，通过生成一个随机索引，从数组中获取对应位置的元素。
 */
class RandomizedSet {

    private HashMap<Integer, Integer> valToIndex; // 元素值到索引的映射
    private ArrayList<Integer> nums; // 存储元素值
    private Random random;

    public RandomizedSet() {
        valToIndex = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        valToIndex.put(val, index);
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        int index = valToIndex.get(val);
        int lastIndex = nums.size() - 1;
        int lastVal = nums.get(lastIndex);
        valToIndex.put(lastVal, index);
        nums.set(index, lastVal);

        nums.remove(lastIndex);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(nums.size());
        return nums.get(index);
    }
}
