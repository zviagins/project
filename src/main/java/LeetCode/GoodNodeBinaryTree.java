package LeetCode;

public class GoodNodeBinaryTree {

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

     public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
     }

     private int goodNodes(TreeNode node, int max){
         if (node == null){
             return 0;
         }
         int newMax = Math.max(node.val, max);
         return goodNodes(node.left, newMax) + goodNodes(node.right, newMax) + (node.val >= max ? 1 : 0);
     }

}
