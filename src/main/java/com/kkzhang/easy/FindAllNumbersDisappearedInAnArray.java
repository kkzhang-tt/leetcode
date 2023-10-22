package com.kkzhang.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 */
public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        List<Integer> res = new ArrayList<>();

        // 将原数组每个元素值作为索引，标记在临时数组中
        for (int i = 0; i < n; i++) {
            int index = nums[i];
            if (tmp[index - 1] == 0) {
                tmp[index - 1] = 1;
            }
        }
        // 如果临时数组对应索引值为 0，则对应 value 在原数组中不存在
        for (int i = 0; i < n; i++) {
            if (tmp[i] == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
    // chatgpt generation
    /**
     * 解题思路：
        这是一个数组操作的问题。
        1. 首先，遍历数组，将每个元素对应的位置的数取负数。
        2. 再次遍历数组，如果当前位置的数仍然是正数，说明该位置对应的数字没有出现在数组中，将位置加一添加到结果列表中。
     */
    /**
     * import java.util.*;

        public class FindDisappearedNumbers {
            public List<Integer> findDisappearedNumbers(int[] nums) {
                List<Integer> result = new ArrayList<>();
                
                for (int i = 0; i < nums.length; i++) {
                    int num = Math.abs(nums[i]);
                    if (nums[num - 1] > 0) {
                        nums[num - 1] = -nums[num - 1];
                    }
                }
                
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] > 0) {
                        result.add(i + 1);
                    }
                }
                
                return result;
            }
        }

     */
}
