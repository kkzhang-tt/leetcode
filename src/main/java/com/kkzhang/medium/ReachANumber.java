package com.kkzhang.medium;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * https://leetcode.com/problems/reach-a-number/description/
 */
public class ReachANumber {

    // 数学推理，不太理解
    public int reachNumber(int target) {
        target = Math.abs(target); // 转换为正数

        int n = 0;
        int sum = 0;

        while (sum < target || (sum - target) % 2 != 0) {
            n++;
            sum += n;
        }

        return n;
    }

    // BFS 层次遍历，大数超时
    public int reachNumber2(int target) {
        Queue<Integer> queue = new LinkedBlockingDeque<>();
        int level = 0;
        queue.add(0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == target) {
                    return level;
                }
                queue.offer(cur + level + 1);
                queue.offer(cur - level - 1);
            }
            level++;
        }

        return level;
    }

}
