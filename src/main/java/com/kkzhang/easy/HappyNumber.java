package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/happy-number/?envType=study-plan-v2&envId=top-interview-150
 */
public class HappyNumber {
    /**
     * 解题思路：
     * 这道题可以使用快慢指针来解决。我们可以将问题转化为链表中的判断环问题。将每次的平方和作为下一个节点，判断是否存在环。
     * 
     * 具体步骤如下：
     * 1. 定义两个指针，快指针 fast 和慢指针 slow，初始时都指向数字 n。
     * 2. 在每次迭代中，快指针 fast 前进两步，慢指针 slow 前进一步。
     * 3. 判断迭代过程中是否出现了以下两种情况：
     * * 如果 fast 指针达到了 1，说明 n 是快乐数，返回 true。
     * * 如果 fast 指针和 slow 指针相遇，说明存在循环，即 n 不是快乐数，返回 false。
     * 4. 如果以上两种情况都不满足，继续进行迭代，直到找到快乐数或者确认不存在循环。
     * 
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && fast != slow) {
            fast = getNext(getNext(fast));
            slow = getNext(slow);
        }

        return fast == 1;

    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n / 10;
            sum += digit * digit;
            n = n % 10;
        }
        return sum;
    }
}
