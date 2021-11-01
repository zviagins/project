package Trees;

import java.util.LinkedList;
import java.util.Queue;

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

    public static void printTreePreorder(TreeNode t){
        if (t == null){
            return;
        }
        System.out.print(t.val + " ");
        printTreePreorder(t.left);
        printTreePreorder(t.right);
    }

    public static void printTreeBFS(TreeNode root){
        Queue<TreeNode> s = new LinkedList<>();
        s.add(root);
        while (!s.isEmpty()){
            TreeNode t = s.poll();
            if (t.left != null)
                s.add(t.left);
            if (t.right != null)
                s.add(t.right);

            System.out.print(t.val + " ");
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
