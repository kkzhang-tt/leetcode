package com.kkzhang.medium;

import org.junit.Test;

public class JumpGameTest {

    @Test
    public void testCanJump() {
        int[] nums = new int[] { 3, 2, 1, 0, 4 };
        System.out.println(JumpGame.canJump(nums));
    }
}
