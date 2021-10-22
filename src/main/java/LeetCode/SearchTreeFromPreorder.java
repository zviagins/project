package LeetCode;

import java.util.LinkedList;
import java.util.Stack;

public class SearchTreeFromPreorder {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;

            this.left = left;

            this.right = right;

        }

    }


    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i< preorder.length; i++){
            TreeNode n = new TreeNode(preorder[i]);
            if (n.val > stack.peek().val){
                stack.peek().left = n;
            }
        }
        return null;

    }

    private TreeNode buildTree(int[] preorder, int current, int right){
        if (current >= right)
            return null;
        TreeNode root = new TreeNode(preorder[current]);
        int left = current + 1;
        while(preorder[left] < preorder[current])
            left++;
        root.left = buildTree(preorder, current+1, right-1);
        root.right = buildTree(preorder, right, 1);
        return root;
    }

    public static void main(String[] args){
        int[] preorder = {8,5,1,7,10,12};
        SearchTreeFromPreorder s = new SearchTreeFromPreorder();
        System.out.println(s.bstFromPreorder(preorder));

    }

}
