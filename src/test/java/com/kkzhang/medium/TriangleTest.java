package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TriangleTest {
    private Triangle solution = new Triangle();

    @Test
    public void testTriangle() {
        List<Integer> first = new ArrayList<>();
        first.add(2);
        List<Integer> second = new ArrayList<>();
        second.add(3);
        second.add(4);
        List<Integer> third = new ArrayList<>();
        third.add(6);
        third.add(5);
        third.add(7);
        List<Integer> fourth = new ArrayList<>();
        fourth.add(4);
        fourth.add(1);
        fourth.add(8);
        fourth.add(3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);
        int res = solution.minimumTotal(list);
        System.out.println(res);
    }
}
