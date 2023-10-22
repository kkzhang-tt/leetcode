package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/description/
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, cur, candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int[] candidates, int remain, int start) {
        if (remain < 0 || res.contains(cur)) {
            return;
        }
        if (remain == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) {
                continue;
            }
            // 此处判断有两个作用：1. 相同元素避免重复选择；2. 在 corer case 情况下，candidates 中全部是相同元素，会导致超时
            // 移除此处判断也正确，由方法入口处去重即可
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur.add(candidates[i]);
            // 当前位置不可以继续选择，下一层的起始位置为 i + 1
            // 注意与 https://leetcode.com/problems/combination-sum/ 的区别
            backtrack(res, cur, candidates, remain - candidates[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }

    // chatgpt generation
    /**
     * 解题思路：
        这是一个回溯算法的问题。
        1. 首先，对 candidates 数组进行排序，以便在后续的递归过程中剪枝。
        2. 创建一个结果集 result 和一个临时列表 temp，用于保存最终的组合和临时的组合。
        3. 调用递归函数 combinationSum2Helper 进行求解。
        4. 在 combinationSum2Helper 方法中，首先判断如果 target 等于0，说明已经找到一个符合条件的组合，将 temp 添加到 result 中。
        5. 然后，遍历 candidates 数组，对于每一个数字，判断它是否小于等于 target，如果不是，直接跳过。
        6. 在可以使用当前数字的情况下，将它添加到 temp 中，并递归调用 combinationSum2Helper。
        7. 在递归调用后，将最后添加的数字从 temp 中移除，以便尝试下一个数字。
        8. 重复步骤5至7，直到遍历完所有的数字。
     */
    /**
     *  import java.util.*;

        public class CombinationSum2 {
            public List<List<Integer>> combinationSum2(int[] candidates, int target) {
                Arrays.sort(candidates);
                List<List<Integer>> result = new ArrayList<>();
                List<Integer> temp = new ArrayList<>();
                combinationSum2Helper(candidates, target, 0, temp, result);
                return result;
            }

            private void combinationSum2Helper(int[] candidates, int target, int start, List<Integer> temp, List<List<Integer>> result) {
                if (target == 0) {
                    result.add(new ArrayList<>(temp));
                    return;
                }

                for (int i = start; i < candidates.length; i++) {
                    if (i > start && candidates[i] == candidates[i - 1]) {
                        continue;
                    }

                    if (candidates[i] <= target) {
                        temp.add(candidates[i]);
                        combinationSum2Helper(candidates, target - candidates[i], i + 1, temp, result);
                        temp.remove(temp.size() - 1);
                    } else {
                        break;
                    }
                }
            }
        }

     */
}
