package com.kkzhang.medium;

import org.junit.Test;

public class ReverseWordsInAStringTest {
    ReverseWordsInAString slution = new ReverseWordsInAString();

    @Test
    public void test() {
        String s = "  hello world  ";
        s = slution.reverseWords(s);
        System.out.println(s);
    }
}
