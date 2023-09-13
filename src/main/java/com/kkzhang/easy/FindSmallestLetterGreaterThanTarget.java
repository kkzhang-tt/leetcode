package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 */
public class FindSmallestLetterGreaterThanTarget {

    /**
     * 解题思路:
     * 由于数组已经按升序排序，我们可以使用二分查找来找到大于目标字母的最小字母。
     *
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] > target) {
                // 如果 mid 处的字母大于目标字母，意味着我们的目标字母可能在 mid 或者它的左侧。
                // 所以我们更新 right = mid - 1。
                right = mid - 1;
            } else {
                // 如果 mid 处的字母小于或等于目标字母，意味着我们需要在数组的右半部分查找。
                // 所以我们更新 left = mid + 1。
                left = left + 1;
            }
        }
        // 在循环结束后，left 将是第一个大于目标字母的索引。
        // 如果 left 超出了数组边界，我们将回到数组的第一个元素。
        return left < letters.length ? letters[left] : letters[0];
    }
}
