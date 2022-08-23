package com.kkzhang.medium;

import org.junit.Test;

import java.util.List;

public class PartitionLabelsTest {
    private PartitionLabels solution = new PartitionLabels();

    @Test
    public void testPartitionLabels() {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = solution.partitionLabels(s);
        printList(res);
    }

    private void printList(List<Integer> list) {
        for (Integer e : list) {
            System.out.print(e + " ");
        }
    }
}
