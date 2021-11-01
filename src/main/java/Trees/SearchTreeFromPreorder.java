package Trees;

public class SearchTreeFromPreorder {

    public TreeNode bstFromPreorder(int[] arr){
        return buildTree(arr, 0, arr.length-1);
    }

    private TreeNode buildTree(int[] arr, int low, int high){
        if (low > high)
            return null;
        TreeNode root = new TreeNode(arr[low]);
        if (low == high){
            return root;
        }
        int i = low;
        while (i < arr.length && arr[i] <= root.val){
            i++;
        }
        root.left = buildTree(arr, low+1, i-1);
        root.right = buildTree(arr, i, high);

        return root;
    }

    public static void main(String[] args){
        //int[] preorder = {8,5,1,7,10,12};
        int[] preorder2 = {4, 2};
        SearchTreeFromPreorder s = new SearchTreeFromPreorder();
        TreeNode t = s.bstFromPreorder(preorder2);
        TreeNode.printTreePreorder(t);
        System.out.println();

        TreeNode.printTreeBFS(t);
    }

}
