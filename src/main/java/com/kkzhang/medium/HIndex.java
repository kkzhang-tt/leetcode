package com.kkzhang.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/h-index/?envType=study-plan-v2&id=top-interview-150
 */
public class HIndex {
    /**
     * 解题思路：
     * 题目要求计算研究者的h指数，即满足条件的引用次数与被引用次数的关系。我们可以对数组进行排序，并逐个遍历寻找符合条件的h指数。
     * 
     * 具体步骤如下：
     * 1. 对数组进行降序排序，使得较大的引用次数排在前面。
     * 2. 遍历排序后的数组，对于每个元素，如果其值大于等于当前索引加1，说明至少有当前索引加1篇论文被引用了至少当前索引加1次。
     * 继续向后遍历，直到找到不满足该条件的位置。
     * 3. 返回最后一个满足条件的索引加1，即为研究者的h指数。
     * 
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int hIndex = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] > (n - 1 - i)) {
                hIndex = n - i;
            } else {
                break;
            }
        }
        return hIndex;
    }
}
