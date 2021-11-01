package Trees;

public class DiameterBinaryTree {

    int maxPathLength = 0;
    /**
     * The Diameter of the tree is maximum of diameter of left subtree, diameter of right subtree, the path that goes through current node (i.e. left high + right high + 1)
     */

    public int diameterOfBinaryTree(TreeNode root) {
        maxPathCalc(root);
        return maxPathLength - 1;
    }

    private int maxPathCalc(TreeNode node){
        if (node == null){
            return 0;
        }
        int leftDiameter = maxPathCalc(node.left);
        int rightDiameter = maxPathCalc(node.right);

        maxPathLength = Math.max(maxPathLength, leftDiameter + rightDiameter + 1);

        return Math.max(leftDiameter, rightDiameter) + 1;
    }
}
