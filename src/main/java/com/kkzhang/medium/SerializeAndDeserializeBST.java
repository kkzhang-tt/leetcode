package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 */
public class SerializeAndDeserializeBST {

    public class Codec {

        // 中序遍历
        public String serialize(TreeNode root) {
            List<Integer> vals = new ArrayList<>();
            preorderTraversal(root, vals);

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < vals.size(); i++) {
                sb.append(vals.get(i));
                if (i < vals.size() - 1) {
                    sb.append(",");
                }
            }

            return sb.toString();
        }

        // 根据中序遍历结果重新构建二叉树
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            String[] vals = data.split(",");
            int[] preorder = new int[vals.length];
            for (int i = 0; i < vals.length; i++) {
                preorder[i] = Integer.valueOf(vals[i]);
            }

            return construct(preorder, 0, preorder.length - 1);

        }

        private TreeNode construct(int[] preorder, int left, int right) {
            if (left > right) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[left]);
            int partition = partition(preorder, left, right);
            root.left = construct(preorder, left + 1, partition - 1);
            root.right = construct(preorder, partition, right);
            return root;
        }

        private int partition(int[] preorder, int left, int right) {
            for (int i = left; i <= right; i++) {
                if (preorder[i] > preorder[left]) {
                    return i;
                }
            }
            return right + 1;
        }

        private void preorderTraversal(TreeNode root, List<Integer> vals) {
            if (root == null) {
                return;
            }
            vals.add(root.val);
            preorderTraversal(root.left, vals);
            preorderTraversal(root.right, vals);
        }
    }
}
