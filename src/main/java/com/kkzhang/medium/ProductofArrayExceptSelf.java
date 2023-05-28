package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&id=top-interview-150
 */
public class ProductofArrayExceptSelf {
    /**
     * 解题思路：
     * 题目要求计算除自身以外所有元素的乘积。可以使用左右两个数组来保存每个元素左边和右边元素的乘积。
     * 
     * 具体步骤如下：
     * 1. 初始化两个数组，left和right，长度为n，用于保存每个元素左边和右边元素的乘积。
     * 2. 遍历数组nums，从左到右计算每个元素左边元素的乘积并保存到left数组中。初始时，left[0]=1。
     * 3. 对于i>0，left[i] = left[i-1] * nums[i-1]，表示第i个元素左边元素的乘积。
     * 4. 遍历数组nums，从右到左计算每个元素右边元素的乘积并保存到right数组中。初始时，right[n-1]=1。
     * 5. 对于i<n-1，right[i] = right[i+1] * nums[i+1]，表示第i个元素右边元素的乘积。
     * 6. 遍历数组nums，计算输出数组output的每个元素。对于第i个元素，output[i] = left[i] *
     * right[i]，即为左右两边元素的乘积。
     * 7. 返回输出数组output。
     * 
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n]; // 左边元素的乘积
        int[] right = new int[n]; // 右边元素的乘积
        int[] output = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            output[i] = left[i] * right[i];
        }
        return output;
    }

}
