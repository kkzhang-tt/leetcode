package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {

    /**
     * 解题思路：
     * 这道题目是在给定数组中找到四个数的和等于目标值的问题。
     * 类似于三数之和，可以使用双指针法来解决。
     * 首先对数组进行排序，然后使用两层循环固定前两个数，再使用双指针在剩下的数组中找到另外两个数，使得它们的和等于目标值。
     * 
     * 具体步骤如下：
     * 1. 对数组进行排序。
     * 2. 初始化一个结果列表 resultList。
     * 3. 使用两层循环，外层循环固定前两个数，内层循环使用双指针找到剩下的两个数，使得四个数的和等于目标值。
     * * * 在双指针法中，设置左指针 left 为当前数的下一个位置，右指针 right 为数组末尾。
     * * * 在每一步中，计算当前四个数的和，如果等于目标值，则将它们添加到结果列表中，并移动左右指针以避免重复。
     * 4. 返回结果列表。
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;// 避免重复
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;// 避免重复
                }

                int left = j + 1;
                int right = nums.length - 1;
                long sum = 0;
                while (left < right) {
                    // 防止溢出
                    sum += nums[i];
                    sum += nums[j];
                    sum += nums[left];
                    sum += nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++; // 避免重复
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--; // 避免重复
                        }
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return res;
    }
}
