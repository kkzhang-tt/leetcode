package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/gas-station/?envType=study-plan-v2&id=top-interview-150
 */
public class GasStation {
    /**
     * 解题思路：
     * 题目要求判断是否存在一个出发位置，可以绕环路行驶一周，即对于每个加油站，其剩余汽油量都不会小于0。
     * 
     * 具体步骤如下：
     * 初始化变量start和totalGas，分别表示起始位置和累计汽油量。
     * 初始化变量currentGas，表示当前加油站的汽油量。
     * 遍历数组gas和cost，计算每个加油站的剩余汽油量：
        * 对于当前加油站i，计算剩余汽油量currentGas = gas[i] - cost[i]。
        * 若currentGas小于0，说明无法到达下一个加油站，重置起始位置start为下一个加油站，并将totalGas重置为0。
        * 否则，累加currentGas到totalGas，并继续前往下一个加油站。
     * 若totalGas小于0，说明无法绕环路行驶一周，返回-1。
     * 否则，返回起始位置start作为出发位置。
     * 
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0; // 起始位置
        int totalGas = 0; // 累计汽油量
        int currentGas = 0; // 当前加油站的汽油量

        for (int i = 0; i < n; i++) {
            currentGas += gas[i] - cost[i]; // 计算当前加油站的剩余汽油量

            if (currentGas < 0) { // 无法到达下一个加油站
                start = i + 1; // 重置起始位置为下一个加油站
                totalGas = 0; // 重置累计汽油量为0
                currentGas = 0; // 重置当前加油站的汽油量为0
            } else {
                totalGas += currentGas; // 累加当前加油站的剩余汽油量
            }
        }

        return totalGas < 0 ? -1 : start; // 判断是否能绕环路行驶一周
    }
}
