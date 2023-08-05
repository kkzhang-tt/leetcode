package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/gas-station/?envType=study-plan-v2&id=top-interview-150
 */
public class GasStation {

    /**
     * 解题思路：
     * 这道题可以使用贪心算法来解决。
     * 我们可以从任何一个加油站出发，试图绕环一周。如果我们能够绕一周，说明解存在；否则，解不存在。
     * 
     * 具体步骤如下：
     * 1. 初始化变量 totalGas 表示累计汽油量，currentGas 表示当前汽油量，startStation 表示起始加油站索引。
     * 2. 遍历加油站，对于每个加油站 i，执行以下操作：
     * * 2.1 将 totalGas 增加 gas[i] - cost[i]，表示从当前加油站出发的剩余汽油量。
     * * 2.2 将 currentGas 增加 gas[i] - cost[i]。
     * * 2.3 如果 currentGas 小于 0，说明无法从当前加油站出发，将 currentGas 重置为 0，并将 startStation
     * * * 更新为下一个加油站的索引。
     * 3. 循环结束后，如果 totalGas 小于 0，说明无法绕一周，返回 -1；否则，返回 startStation。
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int curGas = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            curGas += gas[i] - cost[i];

            if (curGas < 0) {
                startStation = i + 1;
                curGas = 0;
            }
        }

        return totalGas < 0 ? -1 : startStation;
    }
}
